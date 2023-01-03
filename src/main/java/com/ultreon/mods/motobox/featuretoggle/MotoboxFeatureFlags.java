package com.ultreon.mods.motobox.featuretoggle;

import com.ultreon.mods.motobox.Motobox;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureManager;

public class MotoboxFeatureFlags {
    public static FeatureFlag CARAVAN;

    public static void init(FeatureManager.Builder builder) {
        CARAVAN = builder.addFlag(Motobox.id("caravan"));
    }
}
