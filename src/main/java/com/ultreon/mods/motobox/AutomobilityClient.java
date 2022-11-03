package com.ultreon.mods.motobox;

import com.ultreon.mods.motobox.block.AutomobilityBlocks;
import com.ultreon.mods.motobox.block.entity.render.AutomobileAssemblerBlockEntityRenderer;
import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.entity.AutomobilityEntities;
import com.ultreon.mods.motobox.item.AutomobilityItems;
import com.ultreon.mods.motobox.particle.AutomobilityParticles;
import com.ultreon.mods.motobox.render.AutomobilityModels;
import com.ultreon.mods.motobox.resource.AutomobilityAssets;
import com.ultreon.mods.motobox.screen.AutoMechanicTableScreen;
import com.ultreon.mods.motobox.screen.AutomobileHud;
import com.ultreon.mods.motobox.screen.SingleSlotScreen;
import com.ultreon.mods.motobox.util.network.PayloadPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class AutomobilityClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutomobilityModels.init();
        AutomobilityBlocks.initClient();
        AutomobilityItems.initClient();
        AutomobilityEntities.initClient();
        AutomobilityParticles.initClient();
        PayloadPackets.initClient();

        AutomobilityAssets.setup();

        HandledScreens.register(Automobility.AUTO_MECHANIC_SCREEN, AutoMechanicTableScreen::new);
        HandledScreens.register(Automobility.SINGLE_SLOT_SCREEN, SingleSlotScreen::new);

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            var player = MinecraftClient.getInstance().player;
            if (player.getVehicle() instanceof AutomobileEntity auto) {
                AutomobileHud.render(matrices, player, auto, delta);
            }
        });

        BlockRenderLayerMap.INSTANCE.putBlock(AutomobilityBlocks.AUTOMOBILE_ASSEMBLER, RenderLayer.getCutout());

        BlockEntityRendererRegistry.register(AutomobilityBlocks.AUTOMOBILE_ASSEMBLER_ENTITY, AutomobileAssemblerBlockEntityRenderer::new);
    }
}
