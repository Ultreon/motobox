package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.common.ToFloatFunctionImpl;
import com.ultreon.mods.motobox.util.EntityRenderHelper;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import com.ultreon.mods.motobox.vehicle.*;
import com.ultreon.mods.motobox.vehicle.attachment.FrontAttachmentType;
import com.ultreon.mods.motobox.vehicle.attachment.RearAttachmentType;
import com.ultreon.mods.motobox.vehicle.render.VehicleRenderer;
import com.ultreon.mods.motobox.vehicle.render.item.ItemRenderableVehicle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum MotoboxItems {
    ;
    public static final Item HAMMER = register("hammer", new TooltipItem(Text.translatable("tooltip.item.motobox.hammer").formatted(Formatting.BLUE), new Item.Settings().maxCount(1)));
    public static final Item AUTOMOBILE = register("vehicle", new VehicleItem(new Item.Settings().maxCount(1)));
    public static final VehicleFrameItem AUTOMOBILE_FRAME = register("vehicle_frame", new VehicleFrameItem(new Item.Settings().maxCount(16)));
    public static final VehicleWheelItem AUTOMOBILE_WHEEL = register("vehicle_wheel", new VehicleWheelItem(new Item.Settings()));
    public static final VehicleEngineItem AUTOMOBILE_ENGINE = register("vehicle_engine", new VehicleEngineItem(new Item.Settings().maxCount(16)));
    public static final FrontAttachmentItem FRONT_ATTACHMENT = register("front_attachment", new FrontAttachmentItem(new Item.Settings().maxCount(1)));
    public static final RearAttachmentItem REAR_ATTACHMENT = register("rear_attachment", new RearAttachmentItem(new Item.Settings().maxCount(1)));

    public static void init() {
        VehicleItem.addPrefabs(
                new VehiclePrefab(Motobox.id("truck"), VehicleFrame.TRUCK, VehicleWheel.TRUCK, VehicleEngine.TRUCK_ENGINE),
                new VehiclePrefab(Motobox.id("motorbike"), VehicleFrame.MOTORBIKE, VehicleWheel.MOTORBIKE, VehicleEngine.MOTORBIKE_ENGINE),
                new VehiclePrefab(Motobox.id("rusty_car"), VehicleFrame.RUSTY_CAR, VehicleWheel.RUSTY_CAR, VehicleEngine.RUSTY_CAR_ENGINE)
        );
    }

    @Environment(EnvType.CLIENT)
    private static EntityRendererFactory.Context cachedCtx;
    @Environment(EnvType.CLIENT)
    private static final Map<VehicleFrame, Model> frameModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT)
    private static final Map<VehicleWheel, Model> wheelModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT)
    private static final Map<VehicleEngine, Model> engineModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT)
    private static final Map<RearAttachmentType<?>, Model> rearAttModelPool = new HashMap<>();
    @Environment(EnvType.CLIENT)
    private static final Map<FrontAttachmentType<?>, Model> frontAttModelPool = new HashMap<>();

    private static final VehicleData reader = new VehicleData();

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        var itemVehicle = new ItemRenderableVehicle(reader);
        EntityRenderHelper.registerContextListener(ctx -> {
            cachedCtx = ctx;
            rearAttModelPool.clear();
        });

        BuiltinItemRendererRegistry.INSTANCE.register(AUTOMOBILE, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            if (cachedCtx != null) {
                reader.read(stack.getOrCreateSubNbt("Vehicle"));
                float wheelDist = reader.getFrame().model().lengthPx().getFloat() / 16;
                float scale = 1;
                scale /= wheelDist * 0.77f;
                matrices.scale(scale, scale, scale);
                VehicleRenderer.render(matrices, vertexConsumers, light, overlay, MinecraftClient.getInstance().getTickDelta(), cachedCtx, itemVehicle);
            }
        });
        AUTOMOBILE_FRAME.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), frameModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<VehicleFrame>) (t) -> 1 / ((t.model().lengthPx().getFloat() / 16) * 0.77f)
        );
        AUTOMOBILE_WHEEL.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), wheelModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<VehicleWheel>) t -> 6 / t.model().radius()
        );
        AUTOMOBILE_ENGINE.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), engineModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<VehicleEngine>) t -> 1
        );
        REAR_ATTACHMENT.registerItemRenderer(
                pooledModelProvider(t -> t.model().model().apply(cachedCtx), rearAttModelPool),
                t -> t.model().texture(), (ToFloatFunctionImpl<RearAttachmentType<?>>) t -> t.model().scale().getFloat()
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
        return Registry.register(Registries.ITEM, Motobox.id(name), item);
    }
}
