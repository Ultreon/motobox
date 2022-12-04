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

    public static final VehicleWheel STANDARD = REGISTRY.register(
            new VehicleWheel(Motobox.id("standard"), 0.6f, 0.5f, new WheelModel(3, 3, Motobox.id("textures/entity/vehicle/wheel/standard.png"), Motobox.id("wheel_standard")))
    );

    public static final VehicleWheel OFF_ROAD = REGISTRY.register(
            new VehicleWheel(Motobox.id("off_road"), 1.1f, 0.8f, new WheelModel(8.4f, 5, Motobox.id("textures/entity/vehicle/wheel/off_road.png"), Motobox.id("wheel_off_road")))
    );

    public static final VehicleWheel STEEL = REGISTRY.register(
            new VehicleWheel(Motobox.id("steel"), 0.69f, 0.4f, new WheelModel(3.625f, 3, Motobox.id("textures/entity/vehicle/wheel/steel.png"), Motobox.id("wheel_steel")))
    );

    public static final VehicleWheel TRACTOR = REGISTRY.register(
            new VehicleWheel(Motobox.id("tractor"), 1.05f, 0.69f, new WheelModel(3.625f, 3, Motobox.id("textures/entity/vehicle/wheel/tractor.png"), Motobox.id("wheel_tractor")))
    );

    public static final VehicleWheel CARRIAGE = REGISTRY.register(carriage("carriage", 0.2f));
    public static final VehicleWheel PLATED = REGISTRY.register(carriage("plated", 0.33f));
    public static final VehicleWheel STREET = REGISTRY.register(carriage("street", 0.5f));
    public static final VehicleWheel GILDED = REGISTRY.register(carriage("gilded", 0.45f));
    public static final VehicleWheel BEJEWELED = REGISTRY.register(carriage("bejeweled", 0.475f));

    public static final VehicleWheel CONVERTIBLE = REGISTRY.register(
            new VehicleWheel(Motobox.id("convertible"), 0.75f, 0.45f, new WheelModel(5.2f, 4.1f, Motobox.id("textures/entity/vehicle/frame/dababy.png"), Motobox.id("wheel_convertible")))
    );

    private static VehicleWheel carriage(String name, float grip) {
        return new VehicleWheel(Motobox.id(name), 1.05f, grip, new WheelModel(5, 2, Motobox.id("textures/entity/vehicle/wheel/" + name + ".png"), Motobox.id("wheel_carriage")));
    }

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

    public static record WheelModel(
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
