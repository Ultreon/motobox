package com.ultreon.mods.motobox.util.network.packets;

import com.ultreon.mods.lib.network.api.packet.PacketToServer;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.util.network.MotoboxNet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class UpdateVehicleComponentsPacket extends PacketToServer<UpdateVehicleComponentsPacket> {
    private final int entityId;

    public UpdateVehicleComponentsPacket(PacketByteBuf buf) {
        entityId = buf.readInt();
    }

    public UpdateVehicleComponentsPacket(VehicleEntity vehicle) {
        this(vehicle.getId());
    }

    public UpdateVehicleComponentsPacket(int entityId) {
        this.entityId = entityId;
    }

    @Override
    protected void handle(ServerPlayerEntity sender) {
        if (sender.world.getEntityById(entityId) instanceof VehicleEntity vehicle) {
            MotoboxNet.get().sendToClient(new VehicleComponentsChangedPacket(vehicle), sender);
            MotoboxNet.get().sendToClient(new VehicleAttachmentsChangedPacket(vehicle), sender);

            var fAtt = vehicle.getFrontAttachment();
            if (fAtt != null) fAtt.updatePacketRequested(sender);

            var rAtt = vehicle.getRearAttachment();
            if (rAtt != null) rAtt.updatePacketRequested(sender);
        }
    }

    @Override
    public void toBytes(PacketByteBuf buf) {
        buf.writeInt(entityId);
    }
}
