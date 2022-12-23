package com.ultreon.mods.motobox.vehicle;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;
import java.util.function.Function;

public record VehicleWheel(
        Identifier id,
        float size,
        float grip,
        WheelModel model,
        Ability... abilities
) implements VehicleComponent<VehicleWheel> {
    public static final Identifier ID = Motobox.id("wheel");
    public static final SimpleMapContentRegistry<VehicleWheel> REGISTRY = new SimpleMapContentRegistry<>();

    public static final VehicleWheel EMPTY = REGISTRY.register(
            new VehicleWheel(Motobox.id("empty"), 0.01f, 0.01f, new WheelModel(1, 1, new Identifier("empty"), Motobox.id("empty")))
    );

    public static final VehicleWheel TRUCK = REGISTRY.register(
            new VehicleWheel(Motobox.id("truck"), 1.1f, 0.8f, new WheelModel(8.4f, 5, Motobox.id("textures/entity/vehicle/wheel/truck.png"), Motobox.id("wheel_truck")))
    );

    public static final VehicleWheel CONVERTIBLE = REGISTRY.register(
            new VehicleWheel(Motobox.id("convertible"), 0.75f, 0.45f, new WheelModel(5.2f, 4.1f, Motobox.id("textures/entity/vehicle/frame/dababy.png"), Motobox.id("wheel_convertible")))
    );

    public static final DisplayStat<VehicleWheel> STAT_SIZE = new DisplayStat<>("size", VehicleWheel::size);
    public static final DisplayStat<VehicleWheel> STAT_GRIP = new DisplayStat<>("grip", VehicleWheel::grip);

    @Override
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public Identifier containerId() {
        return ID;
    }

    @Override
    public void forEachStat(Consumer<DisplayStat<VehicleWheel>> action) {
        action.accept(STAT_SIZE);
        action.accept(STAT_GRIP);
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public String getTranslationKey() {
        return "wheel." + id.getNamespace() + "." + id.getPath();
    }

    public enum Ability {
    }

    public record WheelModel(
            float radius,
            float width,
            Identifier texture,
            Identifier modelId
    ) {
        @Environment(EnvType.CLIENT)
        public Function<EntityRendererFactory.Context, Model> model() {
            return MotoboxModels.MODELS.get(modelId);
        }
    }
}
