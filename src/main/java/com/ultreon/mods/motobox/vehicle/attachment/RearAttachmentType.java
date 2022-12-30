package com.ultreon.mods.motobox.vehicle.attachment;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.common.FloatSupplier;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import com.ultreon.mods.motobox.vehicle.DisplayStat;
import com.ultreon.mods.motobox.vehicle.VehicleComponent;
import com.ultreon.mods.motobox.vehicle.attachment.rear.BaseChestRearAttachment;
import com.ultreon.mods.motobox.vehicle.attachment.rear.EmptyRearAttachment;
import com.ultreon.mods.motobox.vehicle.attachment.rear.RearAttachment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public record RearAttachmentType<T extends RearAttachment>(
        Identifier id, BiFunction<RearAttachmentType<T>, VehicleEntity, T> constructor, RearAttachmentModel model
) implements VehicleComponent<RearAttachmentType<?>> {
    public static final Identifier ID = Motobox.id("rear_attachment");
    public static final SimpleMapContentRegistry<RearAttachmentType<?>> REGISTRY = new SimpleMapContentRegistry<>();

    public static final RearAttachmentType<EmptyRearAttachment> EMPTY = register(new RearAttachmentType<>(
            Motobox.id("empty"), EmptyRearAttachment::new, new RearAttachmentModel(new Identifier("empty"), Motobox.id("empty"), 0, 0)
    ));

    public static final RearAttachmentType<BaseChestRearAttachment> TRAILER = register(new RearAttachmentType<>(Motobox.id("trailer"),
            BaseChestRearAttachment::chest, new RearAttachmentModel(Motobox.id("textures/entity/vehicle/rear_attachment/trailer.png"), Motobox.id("rearatt_trailer"), () -> 3, () -> 1 / 2f)));

    public static final RearAttachmentType<BaseChestRearAttachment> CARAVAN = register(new RearAttachmentType<>(Motobox.id("caravan"),
            BaseChestRearAttachment::saddledBarrel, new RearAttachmentModel(Motobox.id("textures/entity/vehicle/rear_attachment/caravan.png"), Motobox.id("rearatt_caravan"), () -> 3, () -> 1 / 4f)));

    @Override
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public Identifier containerId() {
        return ID;
    }

    @Override
    public void forEachStat(Consumer<DisplayStat<RearAttachmentType<?>>> action) {
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    private static <T extends RearAttachment> RearAttachmentType<T> register(RearAttachmentType<T> entry) {
        REGISTRY.register(entry);
        return entry;
    }

    public static final class RearAttachmentModel {
        private final Identifier texture;
        private final Identifier modelId;
        private final FloatSupplier pivotDistPx;
        private final FloatSupplier scale;

        public RearAttachmentModel(Identifier texture, Identifier modelId, float pivotDistPx, float scale) {
            this.texture = texture;
            this.modelId = modelId;
            this.pivotDistPx = () -> pivotDistPx;
            this.scale = () -> scale;
        }

        public RearAttachmentModel(Identifier texture, Identifier modelId, FloatSupplier pivotDistPx, FloatSupplier scale) {
            this.texture = texture;
            this.modelId = modelId;
            this.pivotDistPx = pivotDistPx;
            this.scale = scale;
        }

        @Environment(EnvType.CLIENT)
        public Function<EntityRendererFactory.Context, Model> model() {
            return MotoboxModels.MODELS.get(modelId);
        }

        public Identifier texture() {
            return texture;
        }

        public Identifier modelId() {
            return modelId;
        }

        public FloatSupplier pivotDistPx() {
            return pivotDistPx;
        }

        public FloatSupplier scale() {
            return scale;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (RearAttachmentModel) obj;
            return Objects.equals(this.texture, that.texture) &&
                    Objects.equals(this.modelId, that.modelId) &&
                    Float.floatToIntBits(this.pivotDistPx.getFloat()) == Float.floatToIntBits(that.pivotDistPx.getFloat());
        }

        @Override
        public int hashCode() {
            return Objects.hash(texture, modelId, pivotDistPx);
        }

        @Override
        public String toString() {
            return "RearAttachmentModel[" +
                    "texture=" + texture + ", " +
                    "modelId=" + modelId + ", " +
                    "pivotDistPx=" + pivotDistPx + ']';
        }

    }
}
