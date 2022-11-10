package com.ultreon.mods.motobox.automobile.render.frame;

import com.ultreon.mods.motobox.Automobility;
import com.ultreon.mods.motobox.automobile.render.BaseModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class MotorbikeFrameModel extends BaseModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Automobility.id("automobile/frame/motorbike"), "main");

    public MotorbikeFrameModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityTranslucentCull, ctx, MODEL_LAYER);
    }
}
