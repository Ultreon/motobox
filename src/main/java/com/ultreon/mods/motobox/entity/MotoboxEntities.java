package com.ultreon.mods.motobox.entity;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.entity.render.VehicleEntityRenderer;
import com.ultreon.mods.motobox.vehicle.render.ExhaustFumesModel;
import com.ultreon.mods.motobox.vehicle.render.SkidEffectModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.rear.TrailerRearAttachmentRenderModel;
import com.ultreon.mods.motobox.vehicle.render.engine.MotorbikeEngineModel;
import com.ultreon.mods.motobox.vehicle.render.engine.TruckEngineModel;
import com.ultreon.mods.motobox.vehicle.render.frame.MotorbikeFrameModel;
import com.ultreon.mods.motobox.vehicle.render.frame.RustyCarFrameModel;
import com.ultreon.mods.motobox.vehicle.render.frame.TruckFrameModel;
import com.ultreon.mods.motobox.vehicle.render.wheel.TruckWheelModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;

public enum MotoboxEntities {
    ;
    public static final EntityType<VehicleEntity> AUTOMOBILE = Registry.register(
            Registries.ENTITY_TYPE,
            Motobox.id("vehicle"),
            FabricEntityTypeBuilder.<VehicleEntity>create(SpawnGroup.MISC, VehicleEntity::new).dimensions(new EntityDimensions(1f, 0.66f, true)).trackedUpdateRate(3).trackRangeChunks(10).build()
    );

    public static final TagKey<EntityType<?>> DASH_PANEL_BOOSTABLES = TagKey.of(Registries.ENTITY_TYPE.getKey(), Motobox.id("dash_panel_boostables"));

    public static final DamageSource AUTOMOBILE_DAMAGE_SOURCE = new VehicleDamageSource("vehicle");

    public static void init() {
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        EntityRendererRegistry.register(AUTOMOBILE, VehicleEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TruckFrameModel.MODEL_LAYER, TruckFrameModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(MotorbikeFrameModel.MODEL_LAYER, MotorbikeFrameModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(RustyCarFrameModel.MODEL_LAYER, RustyCarFrameModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(TrailerRearAttachmentRenderModel.MODEL_LAYER, TrailerRearAttachmentRenderModel::createBodyLayer);

        EntityModelLayerRegistry.registerModelLayer(TruckWheelModel.MODEL_LAYER, TruckWheelModel::createBodyLayer);

        EntityModelLayerRegistry.registerModelLayer(TruckEngineModel.MODEL_LAYER, TruckEngineModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MotorbikeEngineModel.MODEL_LAYER, MotorbikeEngineModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(SkidEffectModel.MODEL_LAYER, SkidEffectModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ExhaustFumesModel.MODEL_LAYER, ExhaustFumesModel::createBodyLayer);
    }
}
