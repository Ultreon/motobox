package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.automobile.attachment.RearAttachmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class RearAttachmentItem extends AutomobileComponentItem<RearAttachmentType<?>> implements AutomobileInteractable {
    public RearAttachmentItem(Settings settings) {
        super(settings, "attachment", "attachment.rear", RearAttachmentType.REGISTRY);
    }

    @Override
    public ActionResult interactAutomobile(ItemStack stack, PlayerEntity player, Hand hand, AutomobileEntity automobile) {
        if (automobile.getRearAttachment().type.isEmpty()) {
            if (player.world.isClient()) {
                return ActionResult.SUCCESS;
            }

            automobile.setRearAttachment(getComponent(stack));
            automobile.playHitSound();
            if (!player.isCreative()) {
                stack.decrement(1);
            }
        }

        return ActionResult.PASS;
    }
}
