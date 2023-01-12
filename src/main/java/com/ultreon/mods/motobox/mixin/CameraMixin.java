package com.ultreon.mods.motobox.mixin;

import com.ultreon.mods.motobox.entity.VehicleEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {
    private float motobox$tickDelta;

    @Shadow protected abstract double clipToSpace(double desiredCameraDistance);
    @Shadow private Entity focusedEntity;
    @Shadow private float cameraY;
    @Shadow private float lastCameraY;
    @Shadow protected abstract void setPos(double x, double y, double z);
    @Shadow private Vec3d pos;

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;clipToSpace(D)D"), method = "update")
    public double motobox$changeThirdsPersonDistance(Camera instance, double desiredCameraDistance) {
        if (focusedEntity.getVehicle() instanceof VehicleEntity) {
            return clipToSpace(desiredCameraDistance * 2);
        }
        return clipToSpace(desiredCameraDistance);
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lorg/joml/Quaternionf;rotationYXZ(FFF)Lorg/joml/Quaternionf;", remap = false), method = "setRotation(FF)V")
    public Quaternionf motobox$rollRotation(Quaternionf instance, float angleY, float angleX, float angleZ) {
        if (focusedEntity.getVehicle() instanceof VehicleEntity vehicle) {
            float angZ = vehicle.getDisplacement().getAngularZ(MinecraftClient.getInstance().getTickDelta());
            float angX = vehicle.getDisplacement().getAngularX(MinecraftClient.getInstance().getTickDelta());

            instance.rotationYXZ(angleY, angleX, angleZ);
            return instance.rotateXYZ((float) Math.toRadians(angX), 0, (float) Math.toRadians(-angZ));
        }
        return instance.rotationYXZ(angleY, angleX, angleZ);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;moveBy(DDD)V", shift = At.Shift.AFTER, ordinal = 0), method = "update")
    public void motobox$moveThirdPersonView(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        if (focusedEntity.getVehicle() instanceof VehicleEntity) {
            this.pos = this.pos.add(0, MathHelper.lerp(motobox$tickDelta, this.lastCameraY, this.cameraY), 0);
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;moveBy(DDD)V", shift = At.Shift.AFTER, ordinal = 1), method = "update")
    public void motobox$moveSleepView(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        if (focusedEntity.getVehicle() instanceof VehicleEntity) {
            this.pos = this.pos.add(0, MathHelper.lerp(motobox$tickDelta, this.lastCameraY, this.cameraY), 0);
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;setPos(DDD)V", shift = At.Shift.AFTER), method = "update")
    public void motobox$setPosLower(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        if (focusedEntity.getVehicle() instanceof VehicleEntity) {
            this.motobox$tickDelta = tickDelta;
            this.setPos(MathHelper.lerp(tickDelta, focusedEntity.prevX, focusedEntity.getX()), MathHelper.lerp(tickDelta, focusedEntity.prevY, focusedEntity.getY()), MathHelper.lerp(tickDelta, focusedEntity.prevZ, focusedEntity.getZ()));
        }
    }
}
