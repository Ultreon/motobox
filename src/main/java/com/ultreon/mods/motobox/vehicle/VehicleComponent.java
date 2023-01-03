package com.ultreon.mods.motobox.vehicle;

import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import net.minecraft.resource.featuretoggle.ToggleableFeature;

public interface VehicleComponent<T extends VehicleComponent<T>> extends SimpleMapContentRegistry.Identifiable, StatContainer<T>, ToggleableFeature {
    boolean isEmpty();
}
