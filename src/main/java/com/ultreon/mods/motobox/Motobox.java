package com.ultreon.mods.motobox;

import com.ultreon.mods.motobox.block.MotoboxBlocks;
import com.ultreon.mods.motobox.entity.MotoboxEntities;
import com.ultreon.mods.motobox.item.*;
import com.ultreon.mods.motobox.particle.MotoboxParticles;
import com.ultreon.mods.motobox.recipe.AutoMechanicTableRecipe;
import com.ultreon.mods.motobox.recipe.AutoMechanicTableRecipeSerializer;
import com.ultreon.mods.motobox.resource.MotoboxData;
import com.ultreon.mods.motobox.screen.AutoMechanicTableScreenHandler;
import com.ultreon.mods.motobox.screen.SingleSlotScreenHandler;
import com.ultreon.mods.motobox.sound.MotoboxSounds;
import com.ultreon.mods.motobox.util.AUtils;
import com.ultreon.mods.motobox.util.midnightcontrols.ControllerUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

public class Motobox implements ModInitializer {
    public static final String MOD_ID = "motobox";

    public static final ItemGroup GROUP = FabricItemGroup.builder(id("motobox")).icon(AUtils::createGroupIcon).entries((enabledFeatures, entries, operatorEnabled) -> {
        for (Item item : Registries.ITEM) {
            if (item instanceof GenericMotoboxItem) {
                entries.add(item);
            }
            if (item instanceof BlockItem blockItem && blockItem.getBlock() instanceof GenericMotoboxItem) {
                entries.add(item);
            }
            if (item instanceof VehicleComponentItem<?> vehicleComponentItem) {
                vehicleComponentItem.appendStacks(entries);
            }
        }
    }).build();
    public static final ItemGroup COURSE_ELEMENTS = FabricItemGroup.builder(id("motobox_course_elements")).icon(AUtils::createCourseElementsIcon).entries((enabledFeatures, entries, operatorEnabled) -> {
        for (Item item : Registries.ITEM) {
            if (item instanceof CourseElementItem) {
                entries.add(item);
            }
            if (item instanceof BlockItem blockItem) {
                if (blockItem.getBlock() instanceof CourseElementItem) {
                    entries.add(item);
                }
            }
        }
    }).build();
    public static final ItemGroup PREFABS = FabricItemGroup.builder(id("motobox_prefabs")).icon(AUtils::createPrefabsIcon).entries((enabledFeatures, entries, operatorEnabled) -> {
        for (var prefab : VehicleItem.PREFABS) {
            entries.add(prefab.toStack());
        }
    }).build();

    public static final TagKey<Block> SLOPES = TagKey.of(Registries.BLOCK.getKey(), id("slopes"));
    public static final TagKey<Block> STEEP_SLOPES = TagKey.of(Registries.BLOCK.getKey(), id("steep_slopes"));
    public static final TagKey<Block> NON_STEEP_SLOPES = TagKey.of(Registries.BLOCK.getKey(), id("non_steep_slopes"));
    public static final TagKey<Block> STICKY_SLOPES = TagKey.of(Registries.BLOCK.getKey(), id("sticky_slopes"));

    public static final ScreenHandlerType<AutoMechanicTableScreenHandler> AUTO_MECHANIC_SCREEN =
            Registry.register(Registries.SCREEN_HANDLER, Motobox.id("auto_mechanic_table"), new ScreenHandlerType<>(AutoMechanicTableScreenHandler::new));
    public static final ScreenHandlerType<SingleSlotScreenHandler> SINGLE_SLOT_SCREEN =
            Registry.register(Registries.SCREEN_HANDLER, Motobox.id("single_slot"), new ScreenHandlerType<>(SingleSlotScreenHandler::new));
    private static MinecraftServer server;

    public static MinecraftServer server() {
        return server;
    }

    @Override
    public void onInitialize() {
        MotoboxBlocks.init();
        MotoboxItems.init();
        MotoboxEntities.init();
        MotoboxParticles.init();
        MotoboxSounds.init();
        initOther();

        MotoboxData.setup();
        ControllerUtils.initMidnightControlsHandler();

        ServerLifecycleEvents.SERVER_STARTING.register(server -> Motobox.server = server);

        ServerLifecycleEvents.SERVER_STOPPED.register(server -> Motobox.server = null);
    }

    public static void initOther() {
        Registry.register(Registries.RECIPE_TYPE, AutoMechanicTableRecipe.ID, AutoMechanicTableRecipe.TYPE);
        Registry.register(Registries.RECIPE_SERIALIZER, AutoMechanicTableRecipe.ID, AutoMechanicTableRecipeSerializer.INSTANCE);
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
