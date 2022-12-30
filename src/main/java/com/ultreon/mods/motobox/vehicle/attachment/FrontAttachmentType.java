package com.ultreon.mods.motobox.vehicle.attachment;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.render.MotoboxModels;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import com.ultreon.mods.motobox.vehicle.DisplayStat;
import com.ultreon.mods.motobox.vehicle.VehicleComponent;
import com.ultreon.mods.motobox.vehicle.attachment.front.EmptyFrontAttachment;
import com.ultreon.mods.motobox.vehicle.attachment.front.FrontAttachment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public record FrontAttachmentType<T extends FrontAttachment>(
        Identifier id, BiFunction<FrontAttachmentType<T>, VehicleEntity, T> constructor, FrontAttachmentModel model
) implements VehicleComponent<FrontAttachmentType<?>> {
    public static final Identifier ID = Motobox.id("front_attachment");
    public static final SimpleMapContentRegistry<FrontAttachmentType<?>> REGISTRY = new SimpleMapContentRegistry<>();

    public static final FrontAttachmentType<EmptyFrontAttachment> EMPTY = register(new FrontAttachmentType<>(
            Motobox.id("empty"), EmptyFrontAttachment::new, new FrontAttachmentModel(new Identifier("empty"), Motobox.id("empty"), 1)
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
    public void forEachStat(Consumer<DisplayStat<FrontAttachmentType<?>>> action) {
    }

    @Override
    public Identifier getId() {
        return this.id();
    }

    private static <T extends FrontAttachment> FrontAttachmentType<T> register(FrontAttachmentType<T> entry) {
        REGISTRY.register(entry);
        return entry;
    }

    public record FrontAttachmentModel(Identifier texture, Identifier modelId, float scale) {
        @Environment(EnvType.CLIENT)
        public Function<EntityRendererFactory.Context, Model> model() {
            return MotoboxModels.MODELS.get(modelId);
        }
    }
}
