package com.ultreon.mods.motobox.automobile.render.attachment.rear;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.attachment.rear.RearAttachment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import org.jetbrains.annotations.Nullable;

public class StonecutterRearAttachmentModel extends RearAttachmentRenderModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("automobile/rear_attachment/stonecutter"), "main");

    private final ModelPart blade;

    public StonecutterRearAttachmentModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityCutoutNoCull, ctx, MODEL_LAYER);
        this.blade = this.root.getChild("blade");
    }

    @Override
    public void setRenderState(@Nullable RearAttachment attachment, float wheelAngle, float tickDelta) {
        super.setRenderState(attachment, wheelAngle, tickDelta);

        if (this.blade != null) {
            this.blade.setAngles(wheelAngle * 0.45f, 0, 0);
        }
    }
}
