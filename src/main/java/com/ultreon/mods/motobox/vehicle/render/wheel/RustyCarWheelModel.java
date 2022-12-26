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

		ModelPartData front = root.addChild("front", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.2F, -1.6F));

		ModelPartData fronttire = front.addChild("fronttire", ModelPartBuilder.create(), ModelTransform.pivot(-26.4133F, -8.3147F, -21.7881F));

		ModelPartData ftl8 = fronttire.addChild("ftl8", ModelPartBuilder.create().uv(79, 197).cuboid(18.6274F, 6.4906F, 18.0175F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(194, 196).cuboid(28.9653F, 6.4906F, 18.0175F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(121, 172).cuboid(23.3025F, 12.1535F, 18.0175F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(162, 121).cuboid(23.3025F, 1.8155F, 18.0175F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(1.95F, 0.6F, 2.3407F));

		ModelPartData ftl_r1 = ftl8.addChild("ftl_r1", ModelPartBuilder.create().uv(151, 59).cuboid(-1.1608F, -5.8359F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(172, 21).cuboid(-1.1608F, 4.502F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(141, 196).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(69, 197).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, 0.3927F));

		ModelPartData ftl_r2 = ftl8.addChild("ftl_r2", ModelPartBuilder.create().uv(0, 166).cuboid(-1.1608F, -5.8359F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(174, 38).cuboid(-1.1608F, 4.502F, -1.8341F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(197, 17).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(89, 197).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, -0.3927F));

		ModelPartData ftl_r3 = ftl8.addChild("ftl_r3", ModelPartBuilder.create().uv(131, 196).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(59, 197).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, 0.7854F));

		ModelPartData ftl_r4 = ftl8.addChild("ftl_r4", ModelPartBuilder.create().uv(197, 20).cuboid(4.502F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(99, 197).cuboid(-5.8359F, -1.1608F, -1.8341F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(24.4633F, 7.6515F, 19.8516F, 0.0F, 0.0F, -0.7854F));

		ModelPartData frl8 = fronttire.addChild("frl8", ModelPartBuilder.create().uv(0, 200).cuboid(6.8855F, 1.2087F, 2.823F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(115, 184).cuboid(15.0558F, 1.2087F, 2.823F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(49, 196).cuboid(10.492F, 5.7724F, 2.823F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(179, 147).cuboid(10.492F, -2.3978F, 2.823F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0258F, 6.1473F, 17.952F));

		ModelPartData frl_r1 = frl8.addChild("frl_r1", ModelPartBuilder.create().uv(126, 135).cuboid(-0.8955F, -4.502F, -1.4173F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(196, 47).cuboid(-0.8955F, 3.6683F, -1.4173F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(169, 143).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(194, 199).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.3927F));

		ModelPartData frl_r2 = frl8.addChild("frl_r2", ModelPartBuilder.create().uv(195, 63).cuboid(-0.8955F, -4.502F, -1.4173F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(121, 196).cuboid(-0.8955F, 3.6683F, -1.4173F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(104, 188).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(29, 200).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.3927F));

		ModelPartData frl_r3 = frl8.addChild("frl_r3", ModelPartBuilder.create().uv(46, 143).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(160, 199).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.7854F));

		ModelPartData frl_r4 = frl8.addChild("frl_r4", ModelPartBuilder.create().uv(152, 199).cuboid(3.6683F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(37, 200).cuboid(-4.502F, -0.8955F, -1.4173F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.7854F));

		ModelPartData firl14 = fronttire.addChild("firl14", ModelPartBuilder.create().uv(46, 133).cuboid(7.3004F, -1.6475F, 4.1103F, 7.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(15.1528F, 6.1473F, 17.9067F));

		ModelPartData firl15 = fronttire.addChild("firl15", ModelPartBuilder.create().uv(206, 162).cuboid(8.0527F, 1.4408F, 3.2399F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(182, 49).cuboid(13.8886F, 1.4408F, 3.2399F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(10, 166).cuboid(10.7242F, 4.6053F, 3.2399F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(24, 53).cuboid(10.7242F, -1.2306F, 3.2399F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0258F, 6.1473F, 17.952F));

		ModelPartData firl3_r1 = firl15.addChild("firl3_r1", ModelPartBuilder.create().uv(6, 53).cuboid(-0.6633F, -3.3348F, -1.0004F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(91, 35).cuboid(-0.6633F, 2.5011F, -1.0004F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(172, 32).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(206, 158).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.3927F));

		ModelPartData firl3_r2 = firl15.addChild("firl3_r2", ModelPartBuilder.create().uv(80, 63).cuboid(-0.6633F, -3.3348F, -1.0004F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(121, 169).cuboid(-0.6633F, 2.5011F, -1.0004F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(204, 174).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(206, 191).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.3927F));

		ModelPartData firl3_r3 = firl15.addChild("firl3_r3", ModelPartBuilder.create().uv(129, 169).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(205, 80).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, 0.7854F));

		ModelPartData firl3_r4 = firl15.addChild("firl3_r4", ModelPartBuilder.create().uv(205, 57).cuboid(2.5011F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(207, 11).cuboid(-3.3348F, -0.6633F, -1.0004F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.3875F, 2.1042F, 4.2403F, 0.0F, 0.0F, -0.7854F));

		ModelPartData fal8 = fronttire.addChild("fal8", ModelPartBuilder.create(), ModelTransform.pivot(21.0133F, 8.6875F, 24.4655F));

		ModelPartData a74 = fal8.addChild("a74", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a75 = fal8.addChild("a75", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a3_r1 = a75.addChild("a3_r1", ModelPartBuilder.create().uv(119, 129).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a76 = fal8.addChild("a76", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a4_r1 = a76.addChild("a4_r1", ModelPartBuilder.create().uv(17, 107).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a77 = fal8.addChild("a77", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a5_r1 = a77.addChild("a5_r1", ModelPartBuilder.create().uv(104, 80).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a78 = fal8.addChild("a78", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a6_r1 = a78.addChild("a6_r1", ModelPartBuilder.create().uv(45, 100).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a79 = fal8.addChild("a79", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a7_r1 = a79.addChild("a7_r1", ModelPartBuilder.create().uv(91, 37).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a80 = fal8.addChild("a80", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a8_r1 = a80.addChild("a8_r1", ModelPartBuilder.create().uv(80, 65).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a81 = fal8.addChild("a81", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a9_r1 = a81.addChild("a9_r1", ModelPartBuilder.create().uv(79, 60).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a82 = fal8.addChild("a82", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a10_r1 = a82.addChild("a10_r1", ModelPartBuilder.create().uv(78, 53).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a83 = fal8.addChild("a83", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a11_r1 = a83.addChild("a11_r1", ModelPartBuilder.create().uv(68, 53).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a84 = fal8.addChild("a84", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a12_r1 = a84.addChild("a12_r1", ModelPartBuilder.create().uv(24, 55).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		ModelPartData a85 = fal8.addChild("a85", ModelPartBuilder.create(), ModelTransform.pivot(-15.6038F, -6.4411F, -8.1648F));

		ModelPartData a13_r1 = a85.addChild("a13_r1", ModelPartBuilder.create().uv(6, 55).cuboid(-1.4529F, -3.7973F, -0.2F, 0.0F, 0.0F, 0.0F, new Dilation(-0.2F)), ModelTransform.of(21.0038F, 6.0051F, 5.8916F, 0.0F, 0.0F, 0.3054F));

		return TexturedModelData.of(modelData, 512, 512);
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