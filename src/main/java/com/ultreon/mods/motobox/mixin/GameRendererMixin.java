package com.ultreon.mods.motobox.mixin;

import com.ultreon.mods.motobox.entity.VehicleEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Shadow @Final MinecraftClient client;

    private float tickDelta = 0f;

    @Inject(method = "getFov", at = @At("HEAD"))
    private void motobox$cacheGetFovArgs(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir) {
        this.tickDelta = tickDelta;
    }

    @ModifyVariable(method = "getFov", at = @At(value = "RETURN", ordinal = 1, shift = At.Shift.BEFORE), index = 4)
    private double motobox$applyBoostFovEffect(double old) {
        var player = client.player;
        if (player.getVehicle() instanceof VehicleEntity vehicle) {
            return old + ((vehicle.getBoostSpeed(tickDelta) * 18) * client.options.getFovEffectScale().getValue());
        }
        return old;
    }

    @Inject(method = "renderWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;getPitch()F"))
    private void motobox$cameraRoll(float tickDelta, long limitTime, MatrixStack matrices, CallbackInfo ci) {
        var player = client.player;
        if (player.getVehicle() instanceof VehicleEntity vehicle) {
            float angZ = vehicle.getDisplacement().getAngularZ(MinecraftClient.getInstance().getTickDelta());
            float angX = vehicle.getDisplacement().getAngularX(MinecraftClient.getInstance().getTickDelta());

            matrices.multiply(new Quaternionf().rotationXYZ((float) Math.toRadians(-angX), 0, (float) Math.toRadians(-angZ)));
        }
    }
}
