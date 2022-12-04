package com.ultreon.mods.motobox.vehicle.render.attachment.rear;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.ultreon.mods.motobox.Motobox;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;

public class TrailerRearAttachmentRenderModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("rear_attachment_trailer"), "main");
    private final ModelPart bb_main;

    public TrailerRearAttachmentRenderModel(EntityRendererFactory.Context ctx) {
        this.bb_main = ctx.getPart(MODEL_LAYER).getChild("bb_main");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        ModelPartData bb_main = root.addChild("bb_main", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-10.0F, -4.0F, -6.0F, 20.0F, 1.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 2).cuboid(-1.0F, -4.1F, -6.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(26, 21).cuboid(-2.0F, -3.1F, -6.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(13, 25).cuboid(3.0F, -3.1F, -6.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 25).cuboid(3.0F, -3.1F, 5.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -4.1F, 5.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 4).cuboid(-2.0F, -3.1F, 5.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-9.0F, -7.0F, -6.0F, 18.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 17).cuboid(0.5F, -2.0F, -5.5F, 1.0F, 1.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 15).cuboid(-9.0F, -7.0F, 6.0F, 18.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(26, 26).cuboid(9.0F, -7.0F, -6.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(9.0F, -7.0F, 5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(13, 10).cuboid(10.0F, -5.0F, -5.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F))
                .uv(13, 9).cuboid(10.0F, -7.0F, -5.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F))
                .uv(5, 7).cuboid(10.0F, -6.0F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(10.0F, -6.0F, -1.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 4).cuboid(10.0F, -6.0F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 14).cuboid(-9.0F, -5.0F, 6.0F, 18.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 13).cuboid(-9.0F, -5.0F, -6.0F, 18.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(23, 23).cuboid(-10.0F, -7.0F, 5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(19, 23).cuboid(-10.0F, -7.0F, -6.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(18, 21).cuboid(6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(9, 17).cuboid(3.0F, -6.0F, -6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(17, 27).cuboid(-1.0F, -6.0F, -6.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 7).cuboid(-4.0F, -6.0F, -6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 10).cuboid(-7.0F, -6.0F, -6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 3).cuboid(6.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 1).cuboid(3.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(9, 2).cuboid(-4.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(9, 0).cuboid(-7.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 17).cuboid(-1.0F, -6.0F, 6.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(13, 8).cuboid(-10.0F, -7.0F, -5.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(-10.0F, -6.0F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 3).cuboid(-10.0F, -6.0F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(13, 7).cuboid(-10.0F, -5.0F, -5.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F))
                .uv(6, 8).cuboid(6.0F, -3.6F, 5.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 8).cuboid(6.0F, -3.6F, -6.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 5).cuboid(9.5F, -3.6F, -6.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(9.5F, -3.6F, 4.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 29).cuboid(-19.0F, -4.0F, -0.5F, 9.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.push();
        poseStack.scale(3, 3, 3);
        poseStack.translate(0, -1.5 + (0.0 / 16.0), 0);
        poseStack.multiply(new Quaternion(Vec3f.POSITIVE_Y, -90, true));

        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.pop();
    }
}