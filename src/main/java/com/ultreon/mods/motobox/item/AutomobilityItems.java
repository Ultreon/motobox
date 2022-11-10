package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.*;
import com.ultreon.mods.motobox.automobile.attachment.FrontAttachmentType;
import com.ultreon.mods.motobox.automobile.attachment.RearAttachmentType;
import com.ultreon.mods.motobox.automobile.render.AutomobileRenderer;
import com.ultreon.mods.motobox.automobile.render.item.ItemRenderableAutomobile;
import com.ultreon.mods.motobox.common.ToFloatFunctionImpl;
import com.ultreon.mods.motobox.util.EntityRenderHelper;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum AutomobilityItems {;
    public static final Item CROWBAR = register("crowbar", new TooltipItem(Text.translatable("tooltip.item.motobox.crowbar").formatted(Formatting.BLUE), new Item.Settings().maxCount(1).group(Motobox.GROUP)));
    public static final Item AUTOMOBILE = register("automobile", new AutomobileItem(new Item.Settings().maxCount(1).group(Motobox.PREFABS)));
    public static final AutomobileFrameItem AUTOMOBILE_FRAME = register("automobile_frame", new AutomobileFrameItem(new Item.Settings().maxCount(16).group(Motobox.GROUP)));
    public static final AutomobileWheelItem AUTOMOBILE_WHEEL = register("automobile_wheel", new AutomobileWheelItem(new Item.Settings().group(Motobox.GROUP)));
    public static final AutomobileEngineItem AUTOMOBILE_ENGINE = register("automobile_engine", new AutomobileEngineItem(new Item.Settings().maxCount(16).group(Motobox.GROUP)));
    public static final FrontAttachmentItem FRONT_ATTACHMENT = register("front_attachment", new FrontAttachmentItem(new Item.Settings().maxCount(1).group(Motobox.GROUP)));
    public static final RearAttachmentItem REAR_ATTACHMENT = register("rear_attachment", new RearAttachmentItem(new Item.Settings().maxCount(1).group(Motobox.GROUP)));

    public static void init() {
        AutomobileItem.addPrefabs(
                new AutomobilePrefab(Motobox.id("wooden_motorcar"), AutomobileFrame.WOODEN_MOTORCAR, AutomobileWheel.CARRIAGE, AutomobileEngine.STONE),
                new AutomobilePrefab(Motobox.id("copper_motorcar"), AutomobileFrame.COPPER_MOTORCAR, AutomobileWheel.PLATED, AutomobileEngine.COPPER),
                new AutomobilePrefab(Motobox.id("steel_motorcar"), AutomobileFrame.STEEL_MOTORCAR, AutomobileWheel.STREET, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("golden_motorcar"), AutomobileFrame.GOLDEN_MOTORCAR, AutomobileWheel.GILDED, AutomobileEngine.GOLD),
                new AutomobilePrefab(Motobox.id("bejeweled_motorcar"), AutomobileFrame.BEJEWELED_MOTORCAR, AutomobileWheel.BEJEWELED, AutomobileEngine.DIAMOND),
                new AutomobilePrefab(Motobox.id("truck"), AutomobileFrame.TRUCK, AutomobileWheel.OFF_ROAD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_white"), AutomobileFrame.STANDARD_WHITE, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_orange"), AutomobileFrame.STANDARD_ORANGE, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_magenta"), AutomobileFrame.STANDARD_MAGENTA, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_light_blue"), AutomobileFrame.STANDARD_LIGHT_BLUE, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_yellow"), AutomobileFrame.STANDARD_YELLOW, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_lime"), AutomobileFrame.STANDARD_LIME, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_pink"), AutomobileFrame.STANDARD_PINK, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_gray"), AutomobileFrame.STANDARD_GRAY, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_light_gray"), AutomobileFrame.STANDARD_LIGHT_GRAY, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_cyan"), AutomobileFrame.STANDARD_CYAN, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_purple"), AutomobileFrame.STANDARD_PURPLE, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_blue"), AutomobileFrame.STANDARD_BLUE, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_brown"), AutomobileFrame.STANDARD_BROWN, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_green"), AutomobileFrame.STANDARD_GREEN, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_red"), AutomobileFrame.STANDARD_RED, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("standard_black"), AutomobileFrame.STANDARD_BLACK, AutomobileWheel.STANDARD, AutomobileEngine.IRON),
                new AutomobilePrefab(Motobox.id("red_tractor"), AutomobileFrame.RED_TRACTOR, AutomobileWheel.TRACTOR, AutomobileEngine.COPPER),
                new AutomobilePrefab(Motobox.id("yellow_tractor"), AutomobileFrame.YELLOW_TRACTOR, AutomobileWheel.TRACTOR, AutomobileEngine.COPPER),
                new AutomobilePrefab(Motobox.id("green_tractor"), AutomobileFrame.GREEN_TRACTOR, AutomobileWheel.TRACTOR, AutomobileEngine.COPPER),
                new AutomobilePrefab(Motobox.id("blue_tractor"), AutomobileFrame.BLUE_TRACTOR, AutomobileWheel.TRACTOR, AutomobileEngine.COPPER),
                new AutomobilePrefab(Motobox.id("shopping_cart"), AutomobileFrame.SHOPPING_CART, AutomobileWheel.STEEL, AutomobileEngine.STONE),
                new AutomobilePrefab(Motobox.id("c_arr"), AutomobileFrame.C_ARR, AutomobileWheel.OFF_ROAD, AutomobileEngine.DIAMOND),
                new AutomobilePrefab(Motobox.id("pineapple"), AutomobileFrame.PINEAPPLE, AutomobileWheel.TRACTOR, AutomobileEngine.GOLD)
        );
    }

    @Environment(EnvType.CLIENT) private static EntityRendererFactory.Context cachedCtx;
    @Environment(EnvType.CLIENT) private static final Map<AutomobileFrame, Model> frameModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT) private static final Map<AutomobileWheel, Model> wheelModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT) private static final Map<AutomobileEngine, Model> engineModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT) private static final Map<RearAttachmentType<?>, Model> rearAttModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT) private static final Map<FrontAttachmentType<?>, Model> frontAttModelPool = new HashMap<>();

    private static final AutomobileData reader = new AutomobileData();

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        var itemAutomobile = new ItemRenderableAutomobile(reader);
        EntityRenderHelper.registerContextListener(ctx -> {
            cachedCtx = ctx;
            rearAttModelPool.clear();
        });

        BuiltinItemRendererRegistry.INSTANCE.register(AUTOMOBILE, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            if (cachedCtx != null) {
                reader.read(stack.getOrCreateSubNbt("Automobile"));
                float wheelDist = reader.getFrame().model().lengthPx() / 16;
                float scale = 1;
                scale /= wheelDist * 0.77f;
                matrices.scale(scale, scale, scale);
                AutomobileRenderer.render(matrices, vertexConsumers, light, overlay, MinecraftClient.getInstance().getTickDelta(), cachedCtx, itemAutomobile);
            }
        });
        AUTOMOBILE_FRAME.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), frameModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<AutomobileFrame>) (t) -> 1 / ((t.model().lengthPx() / 16) * 0.77f)
        );
        AUTOMOBILE_WHEEL.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), wheelModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<AutomobileWheel>) t -> 6 / t.model().radius()
        );
        AUTOMOBILE_ENGINE.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), engineModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<AutomobileEngine>) t -> 1
        );
        REAR_ATTACHMENT.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), rearAttModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<RearAttachmentType<?>>) t -> 1
        );
        FRONT_ATTACHMENT.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), frontAttModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<FrontAttachmentType<?>>) t -> t.model().scale()
        );
    }

    private static <T extends SimpleMapContentRegistry.Identifiable> Function<T, Model> pooledModelProvider(Function<T, Model> provider, Map<T, Model> pool) {
        return t -> {
            if (!pool.containsKey(t)) {
                var model = provider.apply(t);
                pool.put(t, model);
                return model;
            }
            return pool.get(t);
        };
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, Motobox.id(name), item);
    }
}
