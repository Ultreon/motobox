package com.ultreon.mods.motobox.vehicle.attachment.rear;

import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.attachment.RearAttachmentType;

public class EmptyRearAttachment extends RearAttachment {
    public EmptyRearAttachment(RearAttachmentType<?> type, VehicleEntity entity) {
        super(type, entity);
    }

    @Override
    public void tick() {
    }
}
