package com.ultreon.mods.motobox.automobile.attachment;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.AutomobileComponent;
import com.ultreon.mods.motobox.automobile.DisplayStat;
import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.render.AutomobilityModels;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import com.ultreon.mods.motobox.automobile.attachment.front.CropHarvesterFrontAttachment;
import com.ultreon.mods.motobox.automobile.attachment.front.EmptyFrontAttachment;
import com.ultreon.mods.motobox.automobile.attachment.front.FrontAttachment;
import com.ultreon.mods.motobox.automobile.attachment.front.GrassCutterFrontAttachment;
import com.ultreon.mods.motobox.automobile.attachment.front.MobControllerFrontAttachment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public record FrontAttachmentType<T extends FrontAttachment>(
        Identifier id, BiFunction<FrontAttachmentType<T>, AutomobileEntity, T> constructor, FrontAttachmentModel model
) implements AutomobileComponent<FrontAttachmentType<?>> {
    public static final Identifier ID = Motobox.id("front_attachment");
    public static final SimpleMapContentRegistry<FrontAttachmentType<?>> REGISTRY = new SimpleMapContentRegistry<>();

    public static final FrontAttachmentType<EmptyFrontAttachment> EMPTY = register(new FrontAttachmentType<>(
            Motobox.id("empty"), EmptyFrontAttachment::new, new FrontAttachmentModel(new Identifier("empty"), Motobox.id("empty"), 1)
    ));

    public static final FrontAttachmentType<MobControllerFrontAttachment> MOB_CONTROLLER = register(new FrontAttachmentType<>(
            Motobox.id("mob_controller"), MobControllerFrontAttachment::new,
            new FrontAttachmentModel(Motobox.id("textures/entity/automobile/front_attachment/mob_controller.png"), Motobox.id("frontatt_mob_controller"), 1.7f)
    ));

    public static final FrontAttachmentType<CropHarvesterFrontAttachment> CROP_HARVESTER = register(new FrontAttachmentType<>(
            Motobox.id("crop_harvester"), CropHarvesterFrontAttachment::new,
            new FrontAttachmentModel(Motobox.id("textures/entity/automobile/front_attachment/crop_harvester.png"), Motobox.id("frontatt_harvester"), 0.83f)
    ));

    public static final FrontAttachmentType<GrassCutterFrontAttachment> GRASS_CUTTER = register(new FrontAttachmentType<>(
            Motobox.id("grass_cutter"), GrassCutterFrontAttachment::new,
            new FrontAttachmentModel(Motobox.id("textures/entity/automobile/front_attachment/grass_cutter.png"), Motobox.id("frontatt_harvester"), 0.83f)
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
            return AutomobilityModels.MODELS.get(modelId);
        }
    }
}
