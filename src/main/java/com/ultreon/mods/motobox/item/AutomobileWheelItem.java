package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.automobile.AutomobileWheel;

public class AutomobileWheelItem extends AutomobileComponentItem<AutomobileWheel> {
    public AutomobileWheelItem(Settings settings) {
        super(settings, "wheel", "wheel", AutomobileWheel.REGISTRY);
    }

    @Override
    protected boolean addToCreative(AutomobileWheel component) {
        return super.addToCreative(component) && component != AutomobileWheel.CONVERTIBLE;
    }
}
