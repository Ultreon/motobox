package com.ultreon.mods.motobox.util.network.packets;

import com.ultreon.data.DataIo;
import com.ultreon.data.types.MapType;
import com.ultreon.mods.lib.network.api.packet.PacketToClient;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class VehicleDataChangedPacket extends PacketToClient<VehicleDataChangedPacket> {
    private final int entityId;
    private final byte[] data;

    public VehicleDataChangedPacket(PacketByteBuf buf) {
        entityId = buf.readInt();
        data = buf.readByteArray();
    }

    public VehicleDataChangedPacket(VehicleEntity vehicle) {
        this(vehicle.getId(), serialize(vehicle));
    }

    public VehicleDataChangedPacket(int entityId, byte[] data) {
        this.entityId = entityId;
        this.data = data;
    }

    private static byte[] serialize(VehicleEntity vehicle) {
        MapType mapType = new MapType();
        vehicle.writeSyncToClientData(mapType);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataIo.write(mapType, byteArrayOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void deserialize(VehicleEntity vehicle, byte[] data) {
        ByteArrayInputStream byteArrayOutputStream = new ByteArrayInputStream(data);
        MapType mapType;
        try {
            mapType = DataIo.read(byteArrayOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        vehicle.readSyncToClientData(mapType);
    }

    @Override
    protected void handle() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        assert player != null;
        if (player.world.getEntityById(entityId) instanceof VehicleEntity vehicle) {
            deserialize(vehicle, data);
        }
    }

    @Override
    public void toBytes(PacketByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeByteArray(data);
    }
}
