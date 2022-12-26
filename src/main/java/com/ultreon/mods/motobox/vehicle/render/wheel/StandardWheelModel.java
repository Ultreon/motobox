package com.ultreon.mods.motobox.vehicle.render.wheel;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.vehicle.render.BaseModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionf;

public class StandardWheelModel extends BaseModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("vehicle/wheel/standard"), "main");

    public StandardWheelModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityCutout, ctx, MODEL_LAYER);
    }

    @Override
    protected void prepare(MatrixStack matrices) {
        matrices.multiply(new Quaternionf().rotateY((float) Math.toRadians(-90)));
    }
}
