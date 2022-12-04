package com.ultreon.mods.motobox.vehicle;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.sound.MotoboxSounds;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;
import java.util.function.Function;

public record VehicleEngine(
        Identifier id,
        float torque,
        float speed,
        SoundEvent sound,
        EngineModel model
) implements VehicleComponent<VehicleEngine> {
    public static final Identifier ID = Motobox.id("engine");
    public static final SimpleMapContentRegistry<VehicleEngine> REGISTRY = new SimpleMapContentRegistry<>();

    public static final VehicleEngine EMPTY = REGISTRY.register(
            new VehicleEngine(Motobox.id("empty"), 0.01f, 0.01f,
                    SoundEvents.ENTITY_MINECART_INSIDE,
                    new EngineModel(new Identifier("empty"), Motobox.id("empty"))
            )
    );

    public static final VehicleEngine STONE = REGISTRY.register(
            new VehicleEngine(Motobox.id("stone"), 0.3f, 0.58f,
                    MotoboxSounds.STONE_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/stone.png"), Motobox.id("engine_stone"),
                            new VehicleEngine.ExhaustPos(0, 7f, -8.3f, 50, 0)
                    )
            )
    );

    public static final VehicleEngine IRON = REGISTRY.register(
            new VehicleEngine(Motobox.id("iron"), 0.5f, 0.75f,
                    MotoboxSounds.IRON_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/iron.png"), Motobox.id("engine_iron"),
                            new VehicleEngine.ExhaustPos(-3.5f, 5.4f, -8, 26, 0),
                            new VehicleEngine.ExhaustPos(3.5f, 5.4f, -8, 26, 0)
                    )
            )
    );

    public static final VehicleEngine COPPER = REGISTRY.register(
            new VehicleEngine(Motobox.id("copper"), 0.375f, 0.68f,
                    MotoboxSounds.COPPER_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/copper.png"), Motobox.id("engine_copper"),
                            new VehicleEngine.ExhaustPos(2, 1.625f, -8.95f, 26, 0)
                    )
            )
    );

    public static final VehicleEngine GOLD = REGISTRY.register(
            new VehicleEngine(Motobox.id("gold"), 0.8f, 0.75f,
                    MotoboxSounds.GOLD_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/gold.png"), Motobox.id("engine_gold"),
                            new VehicleEngine.ExhaustPos(4, 9.3f, -7.75f, 26, 0),
                            new VehicleEngine.ExhaustPos(-4, 9.3f, -7.75f, 26, 0)
                    )
            )
    );

    public static final VehicleEngine DIAMOND = REGISTRY.register(
            new VehicleEngine(Motobox.id("diamond"), 0.95f, 0.85f,
                    MotoboxSounds.DIAMOND_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/diamond.png"), Motobox.id("engine_diamond"),
                            new VehicleEngine.ExhaustPos(3, 3.8f, -7.6f, 40, 0),
                            new VehicleEngine.ExhaustPos(-3, 3.8f, -7.6f, 40, 0),
                            new VehicleEngine.ExhaustPos(4, 7.075f, -4.95f, 40, 0),
                            new VehicleEngine.ExhaustPos(-4, 7.075f, -4.95f, 40, 0)
                    )
            )
    );

    public static final VehicleEngine CREATIVE = REGISTRY.register(
            new VehicleEngine(Motobox.id("creative"), 1f, 1f,
                    MotoboxSounds.CREATIVE_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/creative.png"), Motobox.id("engine_creative"),
                            new VehicleEngine.ExhaustPos(0, 7, -7, 90, 0)
                    )
            )
    );

    public static final DisplayStat<VehicleEngine> STAT_TORQUE = new DisplayStat<>("torque", VehicleEngine::torque);
    public static final DisplayStat<VehicleEngine> STAT_SPEED = new DisplayStat<>("speed", VehicleEngine::speed);

    @Override
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public Identifier containerId() {
        return ID;
    }

    @Override
    public void forEachStat(Consumer<DisplayStat<VehicleEngine>> action) {
        action.accept(STAT_TORQUE);
        action.accept(STAT_SPEED);
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public String getTranslationKey() {
        return "engine." + id.getNamespace() + "." + id.getPath();
    }

    public static record EngineModel(
            Identifier texture,
            Identifier modelId,
            ExhaustPos... exhausts
    ) {
        @Environment(EnvType.CLIENT)
        public Function<EntityRendererFactory.Context, Model> model() {
            return MotoboxModels.MODELS.get(modelId);
        }
    }

    public static record ExhaustPos(
            float x, float y, float z,
            float pitch, float yaw
    ) {
    }
}
