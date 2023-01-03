package com.ultreon.mods.motobox;

import com.ultreon.mods.motobox.featuretoggle.FeatureFlagRegistration;
import com.ultreon.mods.motobox.featuretoggle.MotoboxFeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureManager;

public class MotoboxFeatureFlagsRegister implements FeatureFlagRegistration {
    @Override
    public void registerFeatureFlags(FeatureManager.Builder builder) {
        MotoboxFeatureFlags.init(builder);
    }
}
