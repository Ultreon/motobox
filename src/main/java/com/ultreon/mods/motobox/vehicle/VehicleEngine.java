package com.ultreon.mods.motobox.vehicle;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.sound.MotoboxSounds;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class VehicleEngine implements VehicleComponent<VehicleEngine> {
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
    private final Identifier id;
    private final float torque;
    private final float speed;
    private final SoundEvent sound;
    private final EngineModel model;
    private final Supplier<FeatureSet> requiredFeatures;

    public VehicleEngine(
            Identifier id,
            float torque,
            float speed,
            SoundEvent sound,
            EngineModel model
    ) {
        this(id, torque, speed, sound, model, FeatureSet::empty);
    }

    public VehicleEngine(
            Identifier id,
            float torque,
            float speed,
            SoundEvent sound,
            EngineModel model,
            Supplier<FeatureSet> requiredFeatures
    ) {
        this.id = id;
        this.torque = torque;
        this.speed = speed;
        this.sound = sound;
        this.model = model;
        this.requiredFeatures = requiredFeatures;
    }

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

    public Identifier id() {
        return id;
    }

    public float torque() {
        return torque;
    }

    public float speed() {
        return speed;
    }

    public SoundEvent sound() {
        return sound;
    }

    public EngineModel model() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (VehicleEngine) obj;
        return Objects.equals(this.id, that.id) &&
                Float.floatToIntBits(this.torque) == Float.floatToIntBits(that.torque) &&
                Float.floatToIntBits(this.speed) == Float.floatToIntBits(that.speed) &&
                Objects.equals(this.sound, that.sound) &&
                Objects.equals(this.model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, torque, speed, sound, model);
    }

    @Override
    public String toString() {
        return "VehicleEngine[" +
                "id=" + id + ", " +
                "torque=" + torque + ", " +
                "speed=" + speed + ", " +
                "sound=" + sound + ", " +
                "model=" + model + ']';
    }

    @Override
    public FeatureSet getRequiredFeatures() {
        return requiredFeatures.get();
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
