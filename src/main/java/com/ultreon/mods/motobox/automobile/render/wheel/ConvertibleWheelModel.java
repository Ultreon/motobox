package com.ultreon.mods.motobox.automobile.render.wheel;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.util.AUtils;
import dev.monarkhes.myron.api.Myron;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;

public class ConvertibleWheelModel extends Model {
    // Credit to https://github.com/Sk3leCreeper for model
    private final BakedModel model = Myron.getModel(Motobox.id("models/misc/automobile/wheel/convertible"));

    public ConvertibleWheelModel(EntityRendererFactory.Context ctx) {
        super(id -> RenderLayer.getSolid());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        if (model == null) return;
        matrices.push();
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
        matrices.translate(0, -0.325, 0);
        AUtils.renderMyronObj(model, vertices, matrices, light, overlay);
        matrices.pop();
    }
}
