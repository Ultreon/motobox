package com.ultreon.mods.motobox.vehicle.render.wheel;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;

public class TruckWheelModel<T extends VehicleEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("wheel_truck"), "main");
	private final ModelPart wheel;

	public TruckWheelModel(EntityRendererFactory.Context context) {
		this.wheel = context.getPart(MODEL_LAYER).getChild("wheel");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData modelData = new ModelData();
		ModelPartData root = modelData.getRoot();

		ModelPartData wheel = root.addChild("wheel", ModelPartBuilder.create(), ModelTransform.pivot(-7.975F, 20.0F, 5.875F));

		ModelPartData group2 = wheel.addChild("group2", ModelPartBuilder.create().uv(0, 0).cuboid(19.8003F, 1.8745F, -4.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(15.5044F, -2.4213F, -4.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(15.5044F, 6.1704F, -4.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(11.2086F, 1.8745F, -4.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.592F, 1.0541F, -6.0166F));

		group2.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-5.3625F, -1.0667F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0667F, 3.2292F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0667F, -5.3625F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.2292F, -1.0667F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(16.5711F, 2.9412F, -2.0F, 0.0F, 0.0F, 0.3927F));

		group2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-5.3625F, -1.0667F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0667F, 3.2292F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.2292F, -1.0667F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0667F, -5.3625F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(16.5711F, 2.9412F, -2.0F, 0.0F, 0.0F, -0.3927F));

		group2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-5.3625F, -1.0667F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.2292F, -1.0667F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0667F, 3.2292F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0667F, -5.3625F, -2.1334F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(16.5711F, 2.9412F, -2.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData group3 = wheel.addChild("group3", ModelPartBuilder.create().uv(0, 0).cuboid(18.6378F, 2.2585F, -3.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(15.8884F, -0.4908F, -3.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(15.8884F, 5.0079F, -3.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(13.1391F, 2.2585F, -3.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.592F, 1.0541F, -6.0166F));

		group3.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-0.6827F, -3.432F, -1.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.432F, -0.6827F, -1.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(2.0667F, -0.6827F, -1.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.6827F, 2.0667F, -1.3653F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-2.2292F, -2.1334F, -0.5333F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.8958F, -0.8F, -1.4667F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(16.5711F, 2.9412F, -2.0F, 0.0F, 0.0F, -0.7854F));

		group3.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-3.432F, -0.6827F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.6827F, 2.0667F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.6827F, -3.432F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(2.0667F, -0.6827F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(16.5711F, 2.9412F, -2.0F, 0.0F, 0.0F, 0.3927F));

		group3.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-3.432F, -0.6827F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.6827F, 2.0667F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(2.0667F, -0.6827F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.6827F, -3.432F, -1.632F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(16.5711F, 2.9412F, -2.0F, 0.0F, 0.0F, -0.3927F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		poseStack.push();
		poseStack.scale(1.4f, 1.4f, 1.4f);
		poseStack.translate(8 / 16.0, -24 / 16.0, 0 / 16.0);
		poseStack.multiply(new Quaternion(Vec3f.POSITIVE_Y, 270, true));
		poseStack.multiply(new Quaternion(Vec3f.POSITIVE_Z, 0, true));
		wheel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		poseStack.pop();
	}
}














