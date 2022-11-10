package com.ultreon.mods.motobox.sound;

import com.ultreon.mods.motobox.Motobox;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class AutomobilitySounds {
    public static final SoundEvent COLLISION = register("entity.automobile.collision");
    public static final SoundEvent LANDING = register("entity.automobile.landing");
    public static final SoundEvent SKID = register("entity.automobile.skid");

    public static final SoundEvent STONE_ENGINE = register("entity.automobile.stone_engine");
    public static final SoundEvent COPPER_ENGINE = register("entity.automobile.copper_engine");
    public static final SoundEvent IRON_ENGINE = register("entity.automobile.iron_engine");
    public static final SoundEvent GOLD_ENGINE = register("entity.automobile.gold_engine");
    public static final SoundEvent DIAMOND_ENGINE = register("entity.automobile.diamond_engine");
    public static final SoundEvent CREATIVE_ENGINE = register("entity.automobile.creative_engine");

    private static SoundEvent register(String path) {
        var id = Motobox.id(path);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void init() {
    }
}
