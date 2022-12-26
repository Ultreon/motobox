package com.ultreon.mods.motobox.render;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.vehicle.render.EmptyModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.front.HarvesterFrontAttachmentModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.front.MobControllerFrontAttachmentModel;
import com.ultreon.mods.motobox.vehicle.render.attachment.rear.*;
import com.ultreon.mods.motobox.vehicle.render.engine.*;
import com.ultreon.mods.motobox.vehicle.render.frame.MotorbikeFrameModel;
import com.ultreon.mods.motobox.vehicle.render.frame.RustyCarFrameModel;
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
        MODELS.put(Motobox.id("frame_rusty_car"), RustyCarFrameModel::new);

        MODELS.put(Motobox.id("wheel_truck"), TruckWheelModel::new);
        MODELS.put(Motobox.id("wheel_rusty_car"), RustyCarWheelModel::new);


        MODELS.put(Motobox.id("truck_engine"), TruckEngineModel::new);
        MODELS.put(Motobox.id("motorbike_engine"), MotorbikeEngineModel::new);
        MODELS.put(Motobox.id("rusty_car_engine"), TruckEngineModel::new);

        MODELS.put(Motobox.id("rearatt_trailer"), TrailerRearAttachmentRenderModel::new);
        MODELS.put(Motobox.id("rearatt_caravan"), CaravanRearAttachmentRenderModel::new);
    }
}
