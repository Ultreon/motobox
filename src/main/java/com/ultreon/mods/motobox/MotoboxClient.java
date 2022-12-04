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
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

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
    }
}
