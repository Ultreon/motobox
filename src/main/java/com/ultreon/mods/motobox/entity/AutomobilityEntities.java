package com.ultreon.mods.motobox.entity;

import com.ultreon.mods.motobox.automobile.render.frame.*;
import com.ultreon.mods.motobox.entity.render.AutomobileEntityRenderer;
import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.render.ExhaustFumesModel;
import com.ultreon.mods.motobox.automobile.render.SkidEffectModel;
import com.ultreon.mods.motobox.automobile.render.attachment.front.HarvesterFrontAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.front.MobControllerFrontAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.rear.BannerPostRearAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.rear.BlockRearAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.rear.ChestRearAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.rear.GrindstoneRearAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.rear.PassengerSeatRearAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.attachment.rear.StonecutterRearAttachmentModel;
import com.ultreon.mods.motobox.automobile.render.engine.CopperEngineModel;
import com.ultreon.mods.motobox.automobile.render.engine.CreativeEngineModel;
import com.ultreon.mods.motobox.automobile.render.engine.DiamondEngineModel;
import com.ultreon.mods.motobox.automobile.render.engine.GoldEngineModel;
import com.ultreon.mods.motobox.automobile.render.engine.IronEngineModel;
import com.ultreon.mods.motobox.automobile.render.engine.StoneEngineModel;
import com.ultreon.mods.motobox.automobile.render.wheel.CarriageWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.OffRoadWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.StandardWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.SteelWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.TractorWheelModel;
import io.github.foundationgames.jsonem.JsonEM;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public enum AutomobilityEntities {;
    public static final EntityType<AutomobileEntity> AUTOMOBILE = Registry.register(
            Registry.ENTITY_TYPE,
            Motobox.id("automobile"),
            FabricEntityTypeBuilder.<AutomobileEntity>create(SpawnGroup.MISC, AutomobileEntity::new).dimensions(new EntityDimensions(1f, 0.66f, true)).trackedUpdateRate(3).trackRangeChunks(10).build()
    );

    public static final TagKey<EntityType<?>> DASH_PANEL_BOOSTABLES = TagKey.of(Registry.ENTITY_TYPE_KEY, Motobox.id("dash_panel_boostables"));

    public static final DamageSource AUTOMOBILE_DAMAGE_SOURCE = new AutomobileDamageSource("automobile");

    public static void init() {
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        EntityRendererRegistry.register(AUTOMOBILE, AutomobileEntityRenderer::new);

        JsonEM.registerModelLayer(StandardFrameModel.MODEL_LAYER);
        JsonEM.registerModelLayer(TractorFrameModel.MODEL_LAYER);
        JsonEM.registerModelLayer(MotorcarFrameModel.MODEL_LAYER);
        JsonEM.registerModelLayer(TruckFrameModel.MODEL_LAYER);
        JsonEM.registerModelLayer(ShoppingCartFrameModel.MODEL_LAYER);
        JsonEM.registerModelLayer(CARRFrameModel.MODEL_LAYER);
        JsonEM.registerModelLayer(PineappleFrameModel.MODEL_LAYER);

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
