package com.ultreon.mods.motobox.util.network.packets;

import com.ultreon.mods.lib.network.api.packet.PacketToClient;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.attachment.FrontAttachmentType;
import com.ultreon.mods.motobox.vehicle.attachment.RearAttachmentType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class VehicleAttachmentsChangedPacket extends PacketToClient<VehicleAttachmentsChangedPacket> {
    private final int entityId;
    private final Identifier rearAttachmentTypeId;
    private final Identifier frontAttachmentTypeId;

    public VehicleAttachmentsChangedPacket(PacketByteBuf buf) {
        entityId = buf.readInt();
        rearAttachmentTypeId = buf.readIdentifier();
        frontAttachmentTypeId = buf.readIdentifier();
    }

    public VehicleAttachmentsChangedPacket(VehicleEntity vehicle) {
        this(vehicle, vehicle.getRearAttachmentType(), vehicle.getFrontAttachmentType());
    }

    public VehicleAttachmentsChangedPacket(VehicleEntity vehicle, RearAttachmentType<?> rearAttachment, FrontAttachmentType<?> frontAttachment) {
        this(vehicle.getId(), rearAttachment.id(), frontAttachment.id());
    }

    private VehicleAttachmentsChangedPacket(int entityId, Identifier rearAttachmentTypeId, Identifier frontAttachmentTypeId) {
        this.entityId = entityId;
        this.rearAttachmentTypeId = rearAttachmentTypeId;
        this.frontAttachmentTypeId = frontAttachmentTypeId;
    }

    @Override
    @Environment(EnvType.CLIENT)
    protected void handle() {
        var client = MinecraftClient.getInstance();
        var player = client.player;
        var rearAtt = RearAttachmentType.REGISTRY.getOrDefault(rearAttachmentTypeId);
        var frontAtt = FrontAttachmentType.REGISTRY.getOrDefault(frontAttachmentTypeId);
        assert player != null;
        if (player.world.getEntityById(entityId) instanceof VehicleEntity vehicle) {
            vehicle.setRearAttachment(rearAtt);
            vehicle.setFrontAttachment(frontAtt);
        }
    }

    @Override
    public void toBytes(PacketByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeIdentifier(rearAttachmentTypeId);
        buf.writeIdentifier(frontAttachmentTypeId);
    }
}
