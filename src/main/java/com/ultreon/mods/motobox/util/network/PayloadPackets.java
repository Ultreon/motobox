package com.ultreon.mods.motobox.util.network;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.automobile.AutomobileEngine;
import com.ultreon.mods.motobox.automobile.AutomobileFrame;
import com.ultreon.mods.motobox.automobile.AutomobileWheel;
import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.automobile.attachment.FrontAttachmentType;
import com.ultreon.mods.motobox.automobile.attachment.RearAttachmentType;
import com.ultreon.mods.motobox.automobile.attachment.rear.BannerPostRearAttachment;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public enum PayloadPackets {;
    @Environment(EnvType.CLIENT)
    public static void sendSyncAutomobileInputPacket(AutomobileEntity entity, boolean fwd, boolean back, boolean left, boolean right, boolean space) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeBoolean(fwd);
        buf.writeBoolean(back);
        buf.writeBoolean(left);
        buf.writeBoolean(right);
        buf.writeBoolean(space);
        buf.writeInt(entity.getId());
        ClientPlayNetworking.send(Motobox.id("sync_automobile_inputs"), buf);
    }

    @Environment(EnvType.CLIENT)
    public static void requestSyncAutomobileComponentsPacket(AutomobileEntity entity) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(entity.getId());
        ClientPlayNetworking.send(Motobox.id("request_sync_automobile_components"), buf);
    }

    public static void sendSyncAutomobileDataPacket(AutomobileEntity entity, ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(entity.getId());
        entity.writeSyncToClientData(buf);
        ServerPlayNetworking.send(player, Motobox.id("sync_automobile_data"), buf);
    }

    public static void sendSyncAutomobileComponentsPacket(AutomobileEntity entity, ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(entity.getId());
        buf.writeString(entity.getFrame().id().toString());
        buf.writeString(entity.getWheels().id().toString());
        buf.writeString(entity.getEngine().id().toString());
        ServerPlayNetworking.send(player, Motobox.id("sync_automobile_components"), buf);
    }

    public static void sendSyncAutomobileAttachmentsPacket(AutomobileEntity entity, ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(entity.getId());
        buf.writeString(entity.getRearAttachmentType().id().toString());
        buf.writeString(entity.getFrontAttachmentType().id().toString());
        ServerPlayNetworking.send(player, Motobox.id("sync_automobile_attachments"), buf);
    }

    public static void sendBannerPostAttachmentUpdatePacket(AutomobileEntity entity, NbtCompound banner, ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());

        var rearAtt = entity.getRearAttachment();
        if (rearAtt instanceof BannerPostRearAttachment) {
            buf.writeInt(entity.getId());
            buf.writeNbt(banner);
            ServerPlayNetworking.send(player, Motobox.id("update_banner_post"), buf);
        }
    }

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(Motobox.id("sync_automobile_inputs"), (server, player, handler, buf, responseSender) -> {
            boolean fwd = buf.readBoolean();
            boolean back = buf.readBoolean();
            boolean left = buf.readBoolean();
            boolean right = buf.readBoolean();
            boolean space = buf.readBoolean();
            int entityId = buf.readInt();
            server.execute(() -> {
                if (player.world.getEntityById(entityId) instanceof AutomobileEntity automobile) {
                    automobile.setInputs(fwd, back, left, right, space);
                    automobile.markDirty();
                }
            });
        });
        ServerPlayNetworking.registerGlobalReceiver(Motobox.id("request_sync_automobile_components"), (server, player, handler, buf, responseSender) -> {
            int entityId = buf.readInt();
            server.execute(() -> {
                if (player.world.getEntityById(entityId) instanceof AutomobileEntity automobile) {
                    sendSyncAutomobileComponentsPacket(automobile, player);
                    sendSyncAutomobileAttachmentsPacket(automobile, player);

                    var fAtt = automobile.getFrontAttachment();
                    if (fAtt != null) fAtt.updatePacketRequested(player);

                    var rAtt = automobile.getRearAttachment();
                    if (rAtt != null) rAtt.updatePacketRequested(player);
                }
            });
        });
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(Motobox.id("sync_automobile_data"), (client, handler, buf, responseSender) -> {
            PacketByteBuf dup = PacketByteBufs.copy(buf);
            int entityId = dup.readInt();
            client.execute(() -> {
                if (client.player.world.getEntityById(entityId) instanceof AutomobileEntity automobile) {
                    automobile.readSyncToClientData(dup);
                }
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(Motobox.id("sync_automobile_components"), (client, handler, buf, responseSender) -> {
            int entityId = buf.readInt();
            var frame = AutomobileFrame.REGISTRY.getOrDefault(Identifier.tryParse(buf.readString()));
            var wheel = AutomobileWheel.REGISTRY.getOrDefault(Identifier.tryParse(buf.readString()));
            var engine = AutomobileEngine.REGISTRY.getOrDefault(Identifier.tryParse(buf.readString()));
            client.execute(() -> {
                if (client.player.world.getEntityById(entityId) instanceof AutomobileEntity automobile) {
                    automobile.setComponents(frame, wheel, engine);
                }
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(Motobox.id("sync_automobile_attachments"), (client, handler, buf, responseSender) -> {
            int entityId = buf.readInt();
            var rearAtt = RearAttachmentType.REGISTRY.getOrDefault(Identifier.tryParse(buf.readString()));
            var frontAtt = FrontAttachmentType.REGISTRY.getOrDefault(Identifier.tryParse(buf.readString()));
            client.execute(() -> {
                if (client.player.world.getEntityById(entityId) instanceof AutomobileEntity automobile) {
                    automobile.setRearAttachment(rearAtt);
                    automobile.setFrontAttachment(frontAtt);
                }
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(Motobox.id("update_banner_post"), (client, handler, buf, responseSender) -> {
            int entityId = buf.readInt();
            var banner = buf.readNbt();
            client.execute(() -> {
                if (client.player.world.getEntityById(entityId) instanceof AutomobileEntity automobile &&
                        automobile.getRearAttachment() instanceof BannerPostRearAttachment bannerPost) {
                    bannerPost.setFromNbt(banner);
                }
            });
        });
    }
}
