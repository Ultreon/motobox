package com.ultreon.mods.motobox.particle;

import com.ultreon.mods.motobox.Motobox;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;

public class AutomobilityParticles {
    public static final DefaultParticleType DRIFT_SMOKE = Registry.register(Registry.PARTICLE_TYPE, Motobox.id("drift_smoke"), FabricParticleTypes.simple(true));

    public static void init() {
    }

    public static void initClient() {
        ParticleFactoryRegistry.getInstance().register(DRIFT_SMOKE, DriftSmokeParticle.Factory::new);
    }
}
