package com.ultreon.mods.motobox.automobile.render.frame;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.render.BaseModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ShoppingCartFrameModel extends BaseModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("automobile/frame/shopping_cart"), "main");

    public ShoppingCartFrameModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityCutoutNoCull, ctx, MODEL_LAYER);
    }
}
