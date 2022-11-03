package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.entity.AutomobileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public interface AutomobileInteractable {
    ActionResult interactAutomobile(ItemStack stack, PlayerEntity player, Hand hand, AutomobileEntity automobile);
}
