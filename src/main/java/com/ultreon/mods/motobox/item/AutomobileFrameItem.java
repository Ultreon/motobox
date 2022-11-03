package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.automobile.AutomobileFrame;

public class AutomobileFrameItem extends AutomobileComponentItem<AutomobileFrame> {
    public AutomobileFrameItem(Settings settings) {
        super(settings, "frame", "frame", AutomobileFrame.REGISTRY);
    }

    @Override
    protected boolean addToCreative(AutomobileFrame component) {
        return super.addToCreative(component) && component != AutomobileFrame.DABABY;
    }
}
