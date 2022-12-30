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

    public static final VehicleEngine TRUCK_ENGINE = REGISTRY.register(
            new VehicleEngine(Motobox.id("truck"), 0.55f, 1.2f,
                    MotoboxSounds.TRUCK_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/truck_engine.png"), Motobox.id("truck_engine")
                    )
            )
    );

    public static final VehicleEngine MOTORBIKE_ENGINE = REGISTRY.register(
            new VehicleEngine(Motobox.id("motorbike"), 0.6f, 0.8f,
                    MotoboxSounds.MOTORBIKE_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/motorbike_engine.png"), Motobox.id("motorbike_engine")
                    )
            )
    );

    public static final VehicleEngine RUSTY_CAR_ENGINE = REGISTRY.register(
            new VehicleEngine(Motobox.id("rusty_car"), 0.4f, 0.7f,
                    MotoboxSounds.STONE_ENGINE,
                    new EngineModel(
                            Motobox.id("textures/entity/vehicle/engine/rusty_car_engine.png"), Motobox.id("rusty_car_engine")
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

    public record EngineModel(
            Identifier texture,
            Identifier modelId,
            ExhaustPos... exhausts
    ) {
        @Environment(EnvType.CLIENT)
        public Function<EntityRendererFactory.Context, Model> model() {
            return MotoboxModels.MODELS.get(modelId);
        }
    }

    public record ExhaustPos(
            float x, float y, float z,
            float pitch, float yaw
    ) {
    }
}
