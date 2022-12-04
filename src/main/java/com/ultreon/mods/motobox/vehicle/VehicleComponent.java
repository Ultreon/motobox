package com.ultreon.mods.motobox.vehicle;

import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;

public interface VehicleComponent<T extends VehicleComponent<T>> extends SimpleMapContentRegistry.Identifiable, StatContainer<T> {
    boolean isEmpty();
}
