package com.ultreon.mods.motobox.automobile.render;

import com.ultreon.mods.motobox.automobile.AutomobileEngine;
import com.ultreon.mods.motobox.automobile.AutomobileFrame;
import com.ultreon.mods.motobox.automobile.AutomobileWheel;
import com.ultreon.mods.motobox.automobile.attachment.FrontAttachmentType;
import com.ultreon.mods.motobox.automobile.attachment.RearAttachmentType;
import com.ultreon.mods.motobox.automobile.attachment.front.FrontAttachment;
import com.ultreon.mods.motobox.automobile.attachment.rear.RearAttachment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;

public interface RenderableAutomobile {
    AutomobileFrame getFrame();

    AutomobileEngine getEngine();

    AutomobileWheel getWheels();

    @Nullable RearAttachment getRearAttachment();

    @Nullable FrontAttachment getFrontAttachment();

    default RearAttachmentType<?> getRearAttachmentType() {
        if (this.getRearAttachment() == null) {
            return RearAttachmentType.EMPTY;
        }
        return this.getRearAttachment().type;
    }

    default FrontAttachmentType<?> getFrontAttachmentType() {
        if (this.getFrontAttachment() == null) {
            return FrontAttachmentType.EMPTY;
        }
        return this.getFrontAttachment().type;
    }

    Model getFrameModel(EntityRendererFactory.Context ctx);

    Model getWheelModel(EntityRendererFactory.Context ctx);

    Model getEngineModel(EntityRendererFactory.Context ctx);

    Model getRearAttachmentModel(EntityRendererFactory.Context ctx);

    Model getFrontAttachmentModel(EntityRendererFactory.Context ctx);

    float getAutomobileYaw(float tickDelta);

    float getRearAttachmentYaw(float tickDelta);

    float getWheelAngle(float tickDelta);

    float getSteering(float tickDelta);

    float getSuspensionBounce(float tickDelta);

    boolean engineRunning();

    default int getWheelCount() {
        return this.getFrame().model().wheelBase().wheelCount;
    }

    int getBoostTimer();

    int getTurboCharge();

    long getTime();

    boolean automobileOnGround();

    boolean debris();

    Vec3f debrisColor();
}
