package com.ultreon.mods.motobox.entity;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.entity.render.VehicleEntityRenderer;
import com.ultreon.mods.motobox.vehicle.render.ExhaustFumesModel;
import com.ultreon.mods.motobox.vehicle.render.SkidEffectModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.front.HarvesterFrontAttachmentModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.front.MobControllerFrontAttachmentModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.rear.*;
import com.ultreon.mods.motobox.vehicle.render.engine.*;
import com.ultreon.mods.motobox.vehicle.render.frame.MotorbikeFrameModel;
import com.ultreon.mods.motobox.vehicle.render.frame.RustyCarFrameModel;
import com.ultreon.mods.motobox.vehicle.render.frame.TruckFrameModel;
import com.ultreon.mods.motobox.vehicle.render.wheel.*;
import io.github.foundationgames.jsonem.JsonEM;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public enum MotoboxEntities {
    ;
    public static final EntityType<VehicleEntity> AUTOMOBILE = Registry.register(
            Registry.ENTITY_TYPE,
            Motobox.id("vehicle"),
            FabricEntityTypeBuilder.<VehicleEntity>create(SpawnGroup.MISC, VehicleEntity::new).dimensions(new EntityDimensions(1f, 0.66f, true)).trackedUpdateRate(3).trackRangeChunks(10).build()
    );

    public static final TagKey<EntityType<?>> DASH_PANEL_BOOSTABLES = TagKey.of(Registry.ENTITY_TYPE_KEY, Motobox.id("dash_panel_boostables"));

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

        JsonEM.registerModelLayer(StandardWheelModel.MODEL_LAYER);
        JsonEM.registerModelLayer(OffRoadWheelModel.MODEL_LAYER);
        JsonEM.registerModelLayer(TractorWheelModel.MODEL_LAYER);
        JsonEM.registerModelLayer(CarriageWheelModel.MODEL_LAYER);
        JsonEM.registerModelLayer(SteelWheelModel.MODEL_LAYER);

        JsonEM.registerModelLayer(StoneEngineModel.MODEL_LAYER);
        JsonEM.registerModelLayer(IronEngineModel.MODEL_LAYER);
        JsonEM.registerModelLayer(CopperEngineModel.MODEL_LAYER);
        JsonEM.registerModelLayer(GoldEngineModel.MODEL_LAYER);
        JsonEM.registerModelLayer(DiamondEngineModel.MODEL_LAYER);
        JsonEM.registerModelLayer(CreativeEngineModel.MODEL_LAYER);

        JsonEM.registerModelLayer(PassengerSeatRearAttachmentModel.MODEL_LAYER);
        JsonEM.registerModelLayer(BlockRearAttachmentModel.MODEL_LAYER);
        JsonEM.registerModelLayer(GrindstoneRearAttachmentModel.MODEL_LAYER);
        JsonEM.registerModelLayer(StonecutterRearAttachmentModel.MODEL_LAYER);
        JsonEM.registerModelLayer(ChestRearAttachmentModel.MODEL_LAYER);
        JsonEM.registerModelLayer(BannerPostRearAttachmentModel.MODEL_LAYER);

        JsonEM.registerModelLayer(MobControllerFrontAttachmentModel.MODEL_LAYER);
        JsonEM.registerModelLayer(HarvesterFrontAttachmentModel.MODEL_LAYER);

        JsonEM.registerModelLayer(SkidEffectModel.MODEL_LAYER);
        JsonEM.registerModelLayer(ExhaustFumesModel.MODEL_LAYER);
    }
}
