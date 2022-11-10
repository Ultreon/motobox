package com.ultreon.mods.motobox.automobile.render.frame;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.render.BaseModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class TruckFrameModel extends BaseModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("automobile/frame/truck"), "main");

    public TruckFrameModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityTranslucentCull, ctx, MODEL_LAYER);
    }
}
