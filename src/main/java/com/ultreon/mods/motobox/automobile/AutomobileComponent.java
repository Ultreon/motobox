package com.ultreon.mods.motobox.automobile;

import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;

public interface AutomobileComponent<T extends AutomobileComponent<T>> extends SimpleMapContentRegistry.Identifiable, StatContainer<T> {
    boolean isEmpty();
}
