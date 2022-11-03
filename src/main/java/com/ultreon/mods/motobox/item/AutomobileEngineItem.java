package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.automobile.AutomobileEngine;

public class AutomobileEngineItem extends AutomobileComponentItem<AutomobileEngine> {
    public AutomobileEngineItem(Settings settings) {
        super(settings, "engine", "engine", AutomobileEngine.REGISTRY);
    }
}
