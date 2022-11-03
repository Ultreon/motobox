package com.ultreon.mods.motobox.automobile.attachment.rear;

import com.ultreon.mods.motobox.automobile.attachment.RearAttachmentType;
import com.ultreon.mods.motobox.entity.AutomobileEntity;

public class EmptyRearAttachment extends RearAttachment {
    public EmptyRearAttachment(RearAttachmentType<?> type, AutomobileEntity entity) {
        super(type, entity);
    }

    @Override
    public void tick() {
    }
}
