package com.ultreon.mods.motobox;

import com.ultreon.mods.motobox.block.AutomobilityBlocks;
import com.ultreon.mods.motobox.entity.AutomobilityEntities;
import com.ultreon.mods.motobox.item.AutomobilityItems;
import com.ultreon.mods.motobox.particle.AutomobilityParticles;
import com.ultreon.mods.motobox.recipe.AutoMechanicTableRecipe;
import com.ultreon.mods.motobox.recipe.AutoMechanicTableRecipeSerializer;
import com.ultreon.mods.motobox.resource.AutomobilityData;
import com.ultreon.mods.motobox.screen.AutoMechanicTableScreenHandler;
import com.ultreon.mods.motobox.screen.SingleSlotScreenHandler;
import com.ultreon.mods.motobox.sound.AutomobilitySounds;
import com.ultreon.mods.motobox.util.midnightcontrols.ControllerUtils;
import com.ultreon.mods.motobox.util.AUtils;
import com.ultreon.mods.motobox.util.network.PayloadPackets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Motobox implements ModInitializer {
    public static final String MOD_ID = "motobox";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("motobox"), AUtils::createGroupIcon);
    public static final ItemGroup COURSE_ELEMENTS = FabricItemGroupBuilder.build(id("automobility_course_elements"), AUtils::createCourseElementsIcon);
    public static final ItemGroup PREFABS = FabricItemGroupBuilder.build(id("automobility_prefabs"), AUtils::createPrefabsIcon);

    public static final TagKey<Block> SLOPES = TagKey.of(Registry.BLOCK_KEY, id("slopes"));
    public static final TagKey<Block> STEEP_SLOPES = TagKey.of(Registry.BLOCK_KEY, id("steep_slopes"));
    public static final TagKey<Block> NON_STEEP_SLOPES = TagKey.of(Registry.BLOCK_KEY, id("non_steep_slopes"));
    public static final TagKey<Block> STICKY_SLOPES = TagKey.of(Registry.BLOCK_KEY, id("sticky_slopes"));

    public static final ScreenHandlerType<AutoMechanicTableScreenHandler> AUTO_MECHANIC_SCREEN =
            Registry.register(Registry.SCREEN_HANDLER, Motobox.id("auto_mechanic_table"), new ScreenHandlerType<>(AutoMechanicTableScreenHandler::new));
    public static final ScreenHandlerType<SingleSlotScreenHandler> SINGLE_SLOT_SCREEN =
            Registry.register(Registry.SCREEN_HANDLER, Motobox.id("single_slot"), new ScreenHandlerType<>(SingleSlotScreenHandler::new));

    @Override
    public void onInitialize() {
        AutomobilityBlocks.init();
        AutomobilityItems.init();
        AutomobilityEntities.init();
        AutomobilityParticles.init();
        AutomobilitySounds.init();
        initOther();

        PayloadPackets.init();
        AutomobilityData.setup();
        ControllerUtils.initMidnightControlsHandler();
    }

    public static void initOther() {
        Registry.register(Registry.RECIPE_TYPE, AutoMechanicTableRecipe.ID, AutoMechanicTableRecipe.TYPE);
        Registry.register(Registry.RECIPE_SERIALIZER, AutoMechanicTableRecipe.ID, AutoMechanicTableRecipeSerializer.INSTANCE);
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
