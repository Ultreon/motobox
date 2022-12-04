package com.ultreon.mods.motobox.vehicle.attachment;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.common.FloatSupplier;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import com.ultreon.mods.motobox.vehicle.DisplayStat;
import com.ultreon.mods.motobox.vehicle.VehicleComponent;
import com.ultreon.mods.motobox.vehicle.attachment.rear.*;
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
            Motobox.id("empty"), EmptyRearAttachment::new, new RearAttachmentModel(new Identifier("empty"), Motobox.id("empty"), 0)
    ));

    public static final RearAttachmentType<PassengerSeatRearAttachment> PASSENGER_SEAT = register(new RearAttachmentType<>(
            Motobox.id("passenger_seat"), PassengerSeatRearAttachment::new,
            new RearAttachmentModel(Motobox.id("textures/entity/vehicle/rear_attachment/passenger_seat.png"), Motobox.id("rearatt_passenger_seat"), 11)
    ));

    public static final RearAttachmentType<BlockRearAttachment> CRAFTING_TABLE = register(block("crafting_table", BlockRearAttachment::craftingTable));
    public static final RearAttachmentType<BlockRearAttachment> LOOM = register(block("loom", BlockRearAttachment::loom));
    public static final RearAttachmentType<BlockRearAttachment> CARTOGRAPHY_TABLE = register(block("cartography_table", BlockRearAttachment::cartographyTable));
    public static final RearAttachmentType<BlockRearAttachment> SMITHING_TABLE = register(block("smithing_table", BlockRearAttachment::smithingTable));
    public static final RearAttachmentType<BlockRearAttachment> GRINDSTONE = register(block("grindstone", Motobox.id("rearatt_grindstone"), BlockRearAttachment::grindstone));
    public static final RearAttachmentType<BlockRearAttachment> STONECUTTER = register(block("stonecutter", Motobox.id("rearatt_stonecutter"), BlockRearAttachment::stonecutter));
    public static final RearAttachmentType<BlockRearAttachment> AUTO_MECHANIC_TABLE = register(block("auto_mechanic_table", BlockRearAttachment::autoMechanicTable));

    public static final RearAttachmentType<BlockRearAttachment> CHEST = register(chest("chest", BaseChestRearAttachment::chest));
    public static final RearAttachmentType<BlockRearAttachment> ENDER_CHEST = register(chest("ender_chest", BaseChestRearAttachment::enderChest));
    public static final RearAttachmentType<BlockRearAttachment> SADDLED_BARREL = register(block("saddled_barrel", BaseChestRearAttachment::saddledBarrel));
    public static final RearAttachmentType<TrailerRearAttachment> TRAILER = register(new RearAttachmentType<>(Motobox.id("rearatt_trailer"),
            TrailerRearAttachment::new, new RearAttachmentModel(Motobox.id("textures/entity/vehicle/rear_attachment/trailer.png"), Motobox.id("rearatt_trailer"), () -> 3)));

    public static final RearAttachmentType<BannerPostRearAttachment> BANNER_POST = register(new RearAttachmentType<>(
            Motobox.id("banner_post"), BannerPostRearAttachment::new,
            new RearAttachmentModel(Motobox.id("textures/entity/vehicle/rear_attachment/banner_post.png"), Motobox.id("rearatt_banner_post"), 10)
    ));

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

    private static RearAttachmentType<BlockRearAttachment> chest(String name, BiFunction<RearAttachmentType<BlockRearAttachment>, VehicleEntity, BlockRearAttachment> constructor) {
        return block(name, Motobox.id("rearatt_chest"), constructor);
    }

    private static RearAttachmentType<BlockRearAttachment> block(String name, BiFunction<RearAttachmentType<BlockRearAttachment>, VehicleEntity, BlockRearAttachment> constructor) {
        return block(name, Motobox.id("rearatt_block"), constructor);
    }

    private static RearAttachmentType<BlockRearAttachment> block(String name, Identifier model, BiFunction<RearAttachmentType<BlockRearAttachment>, VehicleEntity, BlockRearAttachment> constructor) {
        return new RearAttachmentType<>(
                Motobox.id(name), constructor,
                new RearAttachmentModel(Motobox.id("textures/entity/vehicle/rear_attachment/" + name + ".png"), model, 11)
        );
    }

    private static <T extends RearAttachment> RearAttachmentType<T> register(RearAttachmentType<T> entry) {
        REGISTRY.register(entry);
        return entry;
    }

    public static final class RearAttachmentModel {
        private final Identifier texture;
        private final Identifier modelId;
        private final FloatSupplier pivotDistPx;

        public RearAttachmentModel(Identifier texture, Identifier modelId, float pivotDistPx) {
            this.texture = texture;
            this.modelId = modelId;
            this.pivotDistPx = () -> pivotDistPx;
        }

        public RearAttachmentModel(Identifier texture, Identifier modelId, FloatSupplier pivotDistPx) {
            this.texture = texture;
            this.modelId = modelId;
            this.pivotDistPx = pivotDistPx;
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
