package com.ultreon.mods.motobox.vehicle.attachment.front;

import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.attachment.FrontAttachmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;

public class MobControllerFrontAttachment extends FrontAttachment {
    public MobControllerFrontAttachment(FrontAttachmentType<?> type, VehicleEntity vehicle) {
        super(type, vehicle);
    }

    @Override
    public boolean canDrive(Entity entity) {
        return super.canDrive(entity) || (entity instanceof MobEntity);
    }
}
