package com.ultreon.mods.motobox.vehicle.render.wheel;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.ultreon.mods.motobox.entity.VehicleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Quaternionf;

public class RustyCarWheelModel<T extends VehicleEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(new Identifier("modid", "rusty_car_1_converted"), "main");
	private final ModelPart front;

	public RustyCarWheelModel(EntityRendererFactory.Context context) {
		this.front = context.getPart(MODEL_LAYER).getChild("front");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData modelData = new ModelData();
		ModelPartData root = modelData.getRoot();

		ModelPartData front = root.addChild("front", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0632F, -1.6F));

		ModelPartData fronttire = front.addChild("fronttire", ModelPartBuilder.create(), ModelTransform.pivot(-26.4133F, -8.3147F, -21.7881F));

		ModelPartData ftl8 = fronttire.addChild("ftl8", ModelPartBuilder.create().uv(0, 24).cuboid(18.6274F, 6.4906F, 18.0175F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(16, 18).cuboid(28.9653F, 6.4906F, 18.0175F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(15, 0).cuboid(23.3025F, 12.1535F, 18.0175F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(8, 10).cuboid(23.3025F, 1.8155F, 18.0175F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(1.95F, 0.6F, 2.3407F));

		ModelPartData ftl_r1 = ftl8.addChild("ftl_r1", ModelPartBuilder.create().uv(0, 8).cuboid(-1.1608F, -5.8359F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 13).cuboid(-1.1608F, 4.502F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 18).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(16, 18).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, 0.3927F));

		ModelPartData ftl_r2 = ftl8.addChild("ftl_r2", ModelPartBuilder.create().uv(12, 5).cuboid(-1.1608F, -5.8359F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(8, 15).cuboid(-1.1608F, 4.502F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(6, 21).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(12, 24).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, -0.3927F));

		ModelPartData ftl_r3 = ftl8.addChild("ftl_r3", ModelPartBuilder.create().uv(16, 12).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(22, 15).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, 0.7854F));

		ModelPartData ftl_r4 = ftl8.addChild("ftl_r4", ModelPartBuilder.create().uv(22, 7).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(26, 0).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, -0.7854F));

		ModelPartData frl8 = fronttire.addChild("frl8", ModelPartBuilder.create().uv(31, 11).cuboid(6.8855F, 1.2087F, 2.823F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 28).cuboid(15.0558F, 1.2087F, 2.823F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 21).cuboid(10.492F, 5.7724F, 2.823F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 6).cuboid(10.492F, -3.5641F, 2.823F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0258F, 6.1473F, 17.952F));

		ModelPartData frl_r1 = frl8.addChild("frl_r1", ModelPartBuilder.create().uv(21, 27).cuboid(-0.8955F, -5.6683F, -1.4173F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 13).cuboid(-0.8955F, 3.6683F, -1.4173F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 28).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(29, 13).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.3927F));

		ModelPartData frl_r2 = frl8.addChild("frl_r2", ModelPartBuilder.create().uv(30, 10).cuboid(-0.8955F, -5.6683F, -1.4173F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(26, 28).cuboid(-0.8955F, 3.6683F, -1.4173F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 28).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(27, 29).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.3927F));

		ModelPartData frl_r3 = frl8.addChild("frl_r3", ModelPartBuilder.create().uv(22, 28).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(31, 10).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.7854F));

		ModelPartData frl_r4 = frl8.addChild("frl_r4", ModelPartBuilder.create().uv(22, 28).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(27, 29).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.7854F));

		ModelPartData firl14 = fronttire.addChild("firl14", ModelPartBuilder.create().uv(0, 0).cuboid(7.3004F, -1.6475F, 4.1103F, 7.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(15.1528F, 6.1473F, 17.9067F));

		ModelPartData firl15 = fronttire.addChild("firl15", ModelPartBuilder.create().uv(19, 20).cuboid(8.0527F, 1.4408F, 3.2399F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(4, 14).cuboid(13.8886F, 1.4408F, 3.2399F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(11, 16).cuboid(10.7242F, 4.6053F, 3.2399F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(20, 5).cuboid(10.7242F, -2.3969F, 3.2399F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0258F, 6.1473F, 17.952F));

		ModelPartData firl3_r1 = firl15.addChild("firl3_r1", ModelPartBuilder.create().uv(16, 10).cuboid(-0.6633F, -4.5011F, -1.0004F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(23, 0).cuboid(-0.6633F, 2.5011F, -1.0004F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(4, 9).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(3, 20).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.3927F));

		ModelPartData firl3_r2 = firl15.addChild("firl3_r2", ModelPartBuilder.create().uv(22, 13).cuboid(-0.6633F, -4.5011F, -1.0004F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(32, 0).cuboid(-0.6633F, 2.5011F, -1.0004F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(18, 1).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(15, 26).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.3927F));

		ModelPartData firl3_r3 = firl15.addChild("firl3_r3", ModelPartBuilder.create().uv(4, 9).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 16).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.7854F));

		ModelPartData firl3_r4 = firl15.addChild("firl3_r4", ModelPartBuilder.create().uv(3, 20).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(25, 17).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.7854F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		poseStack.push();
		poseStack.scale(1.7f, 1.7f, 1.7f);
		poseStack.translate(0 / 16.0, -24 / 16.0, 0 / 16.0);
		poseStack.multiply(new Quaternionf().rotateY((float) Math.toRadians(270)));
		poseStack.multiply(new Quaternionf().rotateZ((float) Math.toRadians(0)));

		front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

		poseStack.pop();
	}
}