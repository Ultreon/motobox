package com.ultreon.mods.motobox.automobile.render.wheel;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.render.BaseModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;

public class OffRoadWheelModel extends BaseModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("automobile/wheel/off_road"), "main");

    public OffRoadWheelModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityCutout, ctx, MODEL_LAYER);
    }

    @Override
    protected void prepare(MatrixStack matrices) {
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-90));
    }
}
