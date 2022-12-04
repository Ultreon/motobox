package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.vehicle.VehicleEngine;

public class VehicleEngineItem extends VehicleComponentItem<VehicleEngine> {
    public VehicleEngineItem(Settings settings) {
        super(settings, "engine", "engine", VehicleEngine.REGISTRY);
    }
}
