package com.ultreon.mods.motobox.render;

import com.ultreon.mods.motobox.Automobility;
import com.ultreon.mods.motobox.automobile.render.EmptyModel;
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
import com.ultreon.mods.motobox.automobile.render.frame.*;
//import com.ultreon.mods.motobox.automobile.render.frame.DaBabyFrameModel;
import com.ultreon.mods.motobox.automobile.render.wheel.CarriageWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.ConvertibleWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.OffRoadWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.StandardWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.SteelWheelModel;
import com.ultreon.mods.motobox.automobile.render.wheel.TractorWheelModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
public enum AutomobilityModels {;
    public static final Map<Identifier, Function<EntityRendererFactory.Context, Model>> MODELS = new HashMap<>();

    @Environment(EnvType.CLIENT)
    public static void init() {
        MODELS.put(Automobility.id("empty"), EmptyModel::new);

        MODELS.put(Automobility.id("frame_standard"), StandardFrameModel::new);
        MODELS.put(Automobility.id("frame_tractor"), TractorFrameModel::new);
        MODELS.put(Automobility.id("frame_shopping_cart"), ShoppingCartFrameModel::new);
        MODELS.put(Automobility.id("frame_c_arr"), CARRFrameModel::new);
        MODELS.put(Automobility.id("frame_pineapple"), PineappleFrameModel::new);
        MODELS.put(Automobility.id("frame_motorcar"), MotorcarFrameModel::new);
        MODELS.put(Automobility.id("frame_truck"), TruckFrameModel::new);
        MODELS.put(Automobility.id("frame_motorbike"), MotorbikeFrameModel::new);
//        MODELS.put(Automobility.id("frame_dababy"), DaBabyFrameModel::new);

        MODELS.put(Automobility.id("wheel_standard"), StandardWheelModel::new);
        MODELS.put(Automobility.id("wheel_off_road"), OffRoadWheelModel::new);
        MODELS.put(Automobility.id("wheel_steel"), SteelWheelModel::new);
        MODELS.put(Automobility.id("wheel_tractor"), TractorWheelModel::new);
        MODELS.put(Automobility.id("wheel_carriage"), CarriageWheelModel::new);
        MODELS.put(Automobility.id("wheel_convertible"), ConvertibleWheelModel::new);

        MODELS.put(Automobility.id("engine_stone"), StoneEngineModel::new);
        MODELS.put(Automobility.id("engine_iron"), IronEngineModel::new);
        MODELS.put(Automobility.id("engine_copper"), CopperEngineModel::new);
        MODELS.put(Automobility.id("engine_gold"), GoldEngineModel::new);
        MODELS.put(Automobility.id("engine_diamond"), DiamondEngineModel::new);
        MODELS.put(Automobility.id("engine_creative"), CreativeEngineModel::new);

        MODELS.put(Automobility.id("rearatt_passenger_seat"), PassengerSeatRearAttachmentModel::new);
        MODELS.put(Automobility.id("rearatt_block"), BlockRearAttachmentModel::new);
        MODELS.put(Automobility.id("rearatt_grindstone"), GrindstoneRearAttachmentModel::new);
        MODELS.put(Automobility.id("rearatt_stonecutter"), StonecutterRearAttachmentModel::new);
        MODELS.put(Automobility.id("rearatt_chest"), ChestRearAttachmentModel::new);
        MODELS.put(Automobility.id("rearatt_banner_post"), BannerPostRearAttachmentModel::new);

        MODELS.put(Automobility.id("frontatt_mob_controller"), MobControllerFrontAttachmentModel::new);
        MODELS.put(Automobility.id("frontatt_harvester"), HarvesterFrontAttachmentModel::new);
    }
}
