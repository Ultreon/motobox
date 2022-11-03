package com.ultreon.mods.motobox.util.duck;

import com.ultreon.mods.motobox.automobile.attachment.rear.BaseChestRearAttachment;
import net.minecraft.inventory.EnderChestInventory;

public interface EnderChestInventoryDuck {
    void automobility$setActiveAttachment(BaseChestRearAttachment attachment);

    static EnderChestInventoryDuck of(EnderChestInventory inv) {
        return (EnderChestInventoryDuck) inv;
    }
}
