package com.ultreon.mods.motobox.entity.render;

import com.ultreon.mods.motobox.entity.model.UfoEntityModel;
import com.ultreon.mods.motobox.entity.ufo.UfoEntity;

import net.minecraft.client.render.entity.EntityRendererFactory;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UfoEntityRenderer extends GeoEntityRenderer<UfoEntity> {

    public UfoEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new UfoEntityModel());
    }
}