package com.ultreon.mods.motobox.util.network.packets;

import com.ultreon.mods.lib.network.api.packet.PacketToClient;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.attachment.rear.BannerPostRearAttachment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;

public class BannerPostAttachmentUpdatePacket extends PacketToClient<BannerPostAttachmentUpdatePacket> {
    private final int entityId;
    private final NbtCompound banner;

    public BannerPostAttachmentUpdatePacket(PacketByteBuf buf) {
        entityId = buf.readInt();
        banner = buf.readNbt();
    }

    public BannerPostAttachmentUpdatePacket(VehicleEntity vehicle, NbtCompound banner) {
        this(vehicle.getId(), banner);
    }

    public BannerPostAttachmentUpdatePacket(int entityId, NbtCompound banner) {
        this.entityId = entityId;
        this.banner = banner;
    }

    @Override
    protected void handle() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        assert player != null;
        if (player.world.getEntityById(entityId) instanceof VehicleEntity vehicle
                && vehicle.getRearAttachment() instanceof BannerPostRearAttachment bannerPost) {
            bannerPost.setFromNbt(banner);
        }
    }

    @Override
    public void toBytes(PacketByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeNbt(banner);
    }
}
