package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.automobile.attachment.FrontAttachmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class FrontAttachmentItem extends AutomobileComponentItem<FrontAttachmentType<?>> implements AutomobileInteractable {
    public FrontAttachmentItem(Settings settings) {
        super(settings, "attachment", "attachment.front", FrontAttachmentType.REGISTRY);
    }

    @Override
    public ActionResult interactAutomobile(ItemStack stack, PlayerEntity player, Hand hand, AutomobileEntity automobile) {
        if (automobile.getFrontAttachment().type.isEmpty()) {
            if (player.world.isClient()) {
                return ActionResult.SUCCESS;
            }

            automobile.setFrontAttachment(getComponent(stack));
            automobile.playHitSound();
            if (!player.isCreative()) {
                stack.decrement(1);
            }
        }

        return ActionResult.PASS;
    }
}