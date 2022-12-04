package com.ultreon.mods.motobox.render;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.vehicle.render.EmptyModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.front.HarvesterFrontAttachmentModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.front.MobControllerFrontAttachmentModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.rear.*;
import com.ultreon.mods.motobox.vehicle.render.engine.*;
import com.ultreon.mods.motobox.vehicle.render.frame.MotorbikeFrameModel;
import com.ultreon.mods.motobox.vehicle.render.frame.TruckFrameModel;
import com.ultreon.mods.motobox.vehicle.render.wheel.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
public enum MotoboxModels {
    ;
    public static final Map<Identifier, Function<EntityRendererFactory.Context, Model>> MODELS = new HashMap<>();

    @Environment(EnvType.CLIENT)
    public static void init() {
        MODELS.put(Motobox.id("empty"), EmptyModel::new);

        MODELS.put(Motobox.id("frame_truck"), TruckFrameModel::new);
        MODELS.put(Motobox.id("frame_motorbike"), MotorbikeFrameModel::new);

        MODELS.put(Motobox.id("wheel_standard"), StandardWheelModel::new);
        MODELS.put(Motobox.id("wheel_off_road"), OffRoadWheelModel::new);
        MODELS.put(Motobox.id("wheel_steel"), SteelWheelModel::new);
        MODELS.put(Motobox.id("wheel_tractor"), TractorWheelModel::new);
        MODELS.put(Motobox.id("wheel_carriage"), CarriageWheelModel::new);
        MODELS.put(Motobox.id("wheel_convertible"), ConvertibleWheelModel::new);

        MODELS.put(Motobox.id("engine_stone"), StoneEngineModel::new);
        MODELS.put(Motobox.id("engine_iron"), IronEngineModel::new);
        MODELS.put(Motobox.id("engine_copper"), CopperEngineModel::new);
        MODELS.put(Motobox.id("engine_gold"), GoldEngineModel::new);
        MODELS.put(Motobox.id("engine_diamond"), DiamondEngineModel::new);
        MODELS.put(Motobox.id("engine_creative"), CreativeEngineModel::new);

        MODELS.put(Motobox.id("rearatt_passenger_seat"), PassengerSeatRearAttachmentModel::new);
        MODELS.put(Motobox.id("rearatt_block"), BlockRearAttachmentModel::new);
        MODELS.put(Motobox.id("rearatt_grindstone"), GrindstoneRearAttachmentModel::new);
        MODELS.put(Motobox.id("rearatt_stonecutter"), StonecutterRearAttachmentModel::new);
        MODELS.put(Motobox.id("rearatt_chest"), ChestRearAttachmentModel::new);
        MODELS.put(Motobox.id("rearatt_banner_post"), BannerPostRearAttachmentModel::new);
        MODELS.put(Motobox.id("rearatt_trailer"), TrailerRearAttachmentRenderModel::new);

        MODELS.put(Motobox.id("frontatt_mob_controller"), MobControllerFrontAttachmentModel::new);
        MODELS.put(Motobox.id("frontatt_harvester"), HarvesterFrontAttachmentModel::new);
    }
}
