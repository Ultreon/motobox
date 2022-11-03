package com.ultreon.mods.motobox.automobile.attachment.rear;

import com.ultreon.mods.motobox.automobile.attachment.RearAttachmentType;
import com.ultreon.mods.motobox.entity.AutomobileEntity;

public class PassengerSeatRearAttachment extends RearAttachment {
    public PassengerSeatRearAttachment(RearAttachmentType<?> type, AutomobileEntity entity) {
        super(type, entity);
    }

    @Override
    public boolean isRideable() {
        return true;
    }

    @Override
    public double getPassengerHeightOffset() {
        return 0.69;
    }
}
