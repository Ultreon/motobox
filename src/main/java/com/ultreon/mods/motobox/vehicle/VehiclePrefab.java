package com.ultreon.mods.motobox.vehicle;

import com.ultreon.mods.motobox.item.MotoboxItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public record VehiclePrefab(Identifier id, VehicleFrame frame, VehicleWheel wheel, VehicleEngine engine) {
    public ItemStack toStack() {
        var stack = new ItemStack(MotoboxItems.AUTOMOBILE);
        var vehicle = stack.getOrCreateSubNbt("Vehicle");
        vehicle.putString("frame", frame().getId().toString());
        vehicle.putString("wheels", wheel().getId().toString());
        vehicle.putString("engine", engine().getId().toString());
        vehicle.putBoolean("isPrefab", true);
        var display = stack.getOrCreateSubNbt("display");
        display.putString("Name", String.format("{\"translate\":\"prefab.%s.%s\",\"italic\":\"false\"}", id().getNamespace(), id().getPath()));
        return stack;
    }
}
