package com.ultreon.mods.motobox.block;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.block.entity.VehicleAssemblerBlockEntity;
import com.ultreon.mods.motobox.item.SlopeBlockItem;
import com.ultreon.mods.motobox.item.SteepSlopeBlockItem;
import com.ultreon.mods.motobox.item.TooltipBlockItem;
import com.ultreon.mods.motobox.resource.MotoboxAssets;
import com.ultreon.mods.motobox.resource.MotoboxData;
import com.ultreon.mods.motobox.util.AUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public enum MotoboxBlocks {
    ;
    public static final Block AUTO_MECHANIC_TABLE = register("auto_mechanic_table", new AutoMechanicTableBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Motobox.GROUP);
    public static final Block AUTOMOBILE_ASSEMBLER = register("vehicle_assembler", new VehicleAssemblerBlock(FabricBlockSettings.copyOf(Blocks.ANVIL)), Motobox.GROUP);

    public static final Block LAUNCH_GEL = register("launch_gel", new LaunchGelBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).sounds(BlockSoundGroup.HONEY).noCollision()), Motobox.COURSE_ELEMENTS);
    public static final Block ALLOW = register("allow", new Block(FabricBlockSettings.copyOf(Blocks.BARRIER).sounds(BlockSoundGroup.METAL)),
            b -> new TooltipBlockItem(b, Text.translatable("tooltip.block.motobox.allow").formatted(Formatting.AQUA), new Item.Settings().group(Motobox.COURSE_ELEMENTS)));

    public static final Block GRASS_OFF_ROAD = register("grass_off_road", new OffRoadBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).noCollision(), AUtils.colorFromInt(0x406918)), Motobox.COURSE_ELEMENTS);
    public static final Block DIRT_OFF_ROAD = register("dirt_off_road", new OffRoadBlock(FabricBlockSettings.copyOf(Blocks.DIRT).noCollision(), AUtils.colorFromInt(0x594227)), Motobox.COURSE_ELEMENTS);
    public static final Block SAND_OFF_ROAD = register("sand_off_road", new OffRoadBlock(FabricBlockSettings.copyOf(Blocks.SAND).noCollision(), AUtils.colorFromInt(0xC2B185)), Motobox.COURSE_ELEMENTS);
    public static final Block SNOW_OFF_ROAD = register("snow_off_road", new OffRoadBlock(FabricBlockSettings.copyOf(Blocks.SNOW).noCollision(), AUtils.colorFromInt(0xD0E7ED)), Motobox.COURSE_ELEMENTS);

    public static final Block ASPHALT = register("asphalt", new RoadBlock(FabricBlockSettings.of(Material.STONE, MapColor.BLACK)), Motobox.COURSE_ELEMENTS);

    public static final Block DASH_PANEL = register("dash_panel", new DashPanelBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).luminance(1).emissiveLighting((state, world, pos) -> true).noCollision()), Motobox.COURSE_ELEMENTS);
    public static final Block SLOPED_DASH_PANEL = register("sloped_dash_panel", new SlopedDashPanelBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).luminance(1).emissiveLighting((state, world, pos) -> true)));
    public static final Block STEEP_SLOPED_DASH_PANEL = register("steep_sloped_dash_panel", new SteepSlopedDashPanelBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).luminance(1).emissiveLighting((state, world, pos) -> true)));

    public static final BlockEntityType<VehicleAssemblerBlockEntity> AUTOMOBILE_ASSEMBLER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
            Motobox.id("vehicle_assembler"), FabricBlockEntityTypeBuilder.create(VehicleAssemblerBlockEntity::new, AUTOMOBILE_ASSEMBLER).build());

    public static void init() {
        Registry.register(Registry.ITEM, Motobox.id("sloped_dash_panel"), new SlopeBlockItem(null, SLOPED_DASH_PANEL, new Item.Settings().group(Motobox.COURSE_ELEMENTS)));
        Registry.register(Registry.ITEM, Motobox.id("steep_sloped_dash_panel"), new SteepSlopeBlockItem(null, STEEP_SLOPED_DASH_PANEL, new Item.Settings().group(Motobox.COURSE_ELEMENTS)));
        registerSlopes("minecraft");
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getColor(0.5D, 1.0D), GRASS_OFF_ROAD);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), GRASS_OFF_ROAD.asItem());

        BlockRenderLayerMap.INSTANCE.putBlock(LAUNCH_GEL, RenderLayer.getTranslucent());
    }

    public static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, Motobox.id(name), block);
    }

    public static Block register(String name, Block block, ItemGroup group) {
        return register(name, block, b -> new BlockItem(b, new Item.Settings().group(group)));
    }

    public static Block register(String name, Block block, Function<Block, BlockItem> item) {
        Registry.register(Registry.ITEM, Motobox.id(name), item.apply(block));
        return register(name, block);
    }

    private static void makeStairsSticky(Block candidate, Identifier id) {
        if (candidate instanceof StairsBlock) {
            MotoboxData.STICKY_SLOPE_TAG_CANDIDATES.add(id);
            MotoboxData.STICKY_SLOPE_TAG_CANDIDATES.add(id);
        }
    }

    public static void registerSlopes(String namespace) {
        MotoboxData.NON_STEEP_SLOPE_TAG_CANDIDATES.add(Motobox.id("sloped_dash_panel"));
        MotoboxData.STEEP_SLOPE_TAG_CANDIDATES.add(Motobox.id("steep_sloped_dash_panel"));
        for (var base : Registry.BLOCK) {
            if (base.getClass().equals(Block.class)) {
                var id = Registry.BLOCK.getId(base);
                if (id.getNamespace().equals(namespace)) {
                    var path = id.getPath() + "_slope";
                    var steepPath = "steep_" + path;
                    var block = register(path, new SlopeBlock(FabricBlockSettings.copyOf(base)));
                    var normalId = Motobox.id(path);
                    var steepId = Motobox.id(steepPath);
                    Registry.register(Registry.ITEM, normalId, new SlopeBlockItem(base, block, new Item.Settings().group(Motobox.COURSE_ELEMENTS)));
                    block = register(steepPath, new SteepSlopeBlock(FabricBlockSettings.copyOf(base)));
                    Registry.register(Registry.ITEM, steepId, new SteepSlopeBlockItem(base, block, new Item.Settings().group(Motobox.COURSE_ELEMENTS)));
                    MotoboxAssets.addProcessor(pack -> MotoboxAssets.addMinecraftSlope(path, id.getPath()));
                    MotoboxData.NON_STEEP_SLOPE_TAG_CANDIDATES.add(normalId);
                    MotoboxData.STEEP_SLOPE_TAG_CANDIDATES.add(steepId);
                }
            }

            makeStairsSticky(base, Registry.BLOCK.getId(base));
        }

        RegistryEntryAddedCallback.event(Registry.BLOCK).register((raw, id, block) -> {
            makeStairsSticky(block, id);
        });
    }
}
