package com.ultreon.mods.motobox.vehicle.render.wheel;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.util.AUtils;
import com.ultreon.mods.myron.api.Myron;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionf;

public class ConvertibleWheelModel extends Model {
    // Credit to https://github.com/Sk3leCreeper for model
    private final BakedModel model = Myron.getModel(Motobox.id("models/misc/vehicle/wheel/convertible"));

    public ConvertibleWheelModel(EntityRendererFactory.Context ctx) {
        super(id -> RenderLayer.getSolid());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        if (model == null) return;
        matrices.push();
        matrices.multiply(new Quaternionf().rotateZ((float) Math.toRadians(180)));
        matrices.multiply(new Quaternionf().rotateY((float) Math.toRadians(90)));
        matrices.translate(0, -0.325, 0);
        AUtils.renderMyronObj(model, vertices, matrices, light, overlay);
        matrices.pop();
    }
}
