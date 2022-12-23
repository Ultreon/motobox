package com.ultreon.mods.motobox;

import com.ultreon.mods.motobox.block.MotoboxBlocks;
import com.ultreon.mods.motobox.block.entity.render.VehicleAssemblerBlockEntityRenderer;
import com.ultreon.mods.motobox.entity.MotoboxEntities;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.item.MotoboxItems;
import com.ultreon.mods.motobox.particle.MotoboxParticles;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.resource.MotoboxAssets;
import com.ultreon.mods.motobox.screen.AutoMechanicTableScreen;
import com.ultreon.mods.motobox.screen.SingleSlotScreen;
import com.ultreon.mods.motobox.screen.VehicleHud;
import com.ultreon.mods.motobox.util.network.PayloadPackets;
import com.ultreon.mods.motobox.vehicle.VehicleEngine;
import com.ultreon.mods.motobox.vehicle.VehicleFrame;
import com.ultreon.mods.motobox.vehicle.VehicleWheel;
import com.ultreon.mods.motobox.vehicle.render.VehicleRenderer;
import com.ultreon.mods.motobox.vehicle.render.engine.TruckEngineModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

public class MotoboxClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MotoboxModels.init();
        MotoboxBlocks.initClient();
        MotoboxItems.initClient();
        MotoboxEntities.initClient();
        MotoboxParticles.initClient();
        PayloadPackets.initClient();

        MotoboxAssets.setup();

        HandledScreens.register(Motobox.AUTO_MECHANIC_SCREEN, AutoMechanicTableScreen::new);
        HandledScreens.register(Motobox.SINGLE_SLOT_SCREEN, SingleSlotScreen::new);

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            var player = MinecraftClient.getInstance().player;
            if (player.getVehicle() instanceof VehicleEntity auto) {
                VehicleHud.render(matrices, player, auto, delta);
            }
        });

        BlockRenderLayerMap.INSTANCE.putBlock(MotoboxBlocks.AUTOMOBILE_ASSEMBLER, RenderLayer.getCutout());

        BlockEntityRendererRegistry.register(MotoboxBlocks.AUTOMOBILE_ASSEMBLER_ENTITY, VehicleAssemblerBlockEntityRenderer::new);

        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
//            MatrixStack matrixStack = context.matrixStack();
//            @Nullable VertexConsumerProvider consumers = context.consumers();
//            MinecraftClient client = context.gameRenderer().getClient();
//            VehicleEntity vehicleEntity = new VehicleEntity(client.world);
//            vehicleEntity.setComponents(VehicleFrame.TRUCK, VehicleWheel.TRUCK, VehicleEngine.TRUCK_ENGINE);
//            vehicleEntity.updateModels = true;
//            VehicleRenderer.render(matrixStack, consumers, 1, 1, 0f, new EntityRendererFactory.Context(client.getEntityRenderDispatcher(), client.getItemRenderer(), client.getBlockRenderManager(), client.getEntityRenderDispatcher().getHeldItemRenderer(), client.getResourceManager(), client.getEntityModelLoader(), client.textRenderer), vehicleEntity);
//
//            matrixStack.multiply(new Quaternionf(0, 1, 0, Math.toRadians(180)));
//            TruckEngineModel.getTexturedModelData().createModel().render(matrixStack, consumers.getBuffer(RenderLayer.getEntityTranslucent(new Identifier("textures/block/dirt.png"))), 1, 1);
        });
    }
}
