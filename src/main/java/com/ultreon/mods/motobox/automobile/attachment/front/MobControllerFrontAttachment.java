package com.ultreon.mods.motobox.automobile.attachment.front;

import com.ultreon.mods.motobox.automobile.attachment.FrontAttachmentType;
import com.ultreon.mods.motobox.entity.AutomobileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;

public class MobControllerFrontAttachment extends FrontAttachment {
    public MobControllerFrontAttachment(FrontAttachmentType<?> type, AutomobileEntity automobile) {
        super(type, automobile);
    }

    @Override
    public boolean canDrive(Entity entity) {
        return super.canDrive(entity) || (entity instanceof MobEntity);
    }
}
