package com.ultreon.mods.motobox.util.network.packets;

import com.ultreon.mods.lib.network.api.packet.PacketToClient;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.VehicleEngine;
import com.ultreon.mods.motobox.vehicle.VehicleFrame;
import com.ultreon.mods.motobox.vehicle.VehicleWheel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class VehicleComponentsChangedPacket extends PacketToClient<VehicleComponentsChangedPacket> {
    private final int entityId;
    private final Identifier frameId;
    private final Identifier wheelsId;
    private final Identifier engineId;

    public VehicleComponentsChangedPacket(PacketByteBuf buf) {
        entityId = buf.readInt();
        frameId = buf.readIdentifier();
        wheelsId = buf.readIdentifier();
        engineId = buf.readIdentifier();
    }

    public VehicleComponentsChangedPacket(VehicleEntity vehicle) {
        this(vehicle, vehicle.getFrame(), vehicle.getWheels(), vehicle.getEngine());
    }

    public VehicleComponentsChangedPacket(VehicleEntity vehicle, VehicleFrame frame, VehicleWheel wheels, VehicleEngine engine) {
        this(vehicle.getId(), frame.id(), wheels.id(), engine.id());
    }

    public VehicleComponentsChangedPacket(int entityId, Identifier frameId, Identifier wheelsId, Identifier engineId) {
        this.entityId = entityId;
        this.frameId = frameId;
        this.wheelsId = wheelsId;
        this.engineId = engineId;
    }

    @Override
    protected void handle() {
        var frame = VehicleFrame.REGISTRY.getOrDefault(frameId);
        var wheel = VehicleWheel.REGISTRY.getOrDefault(wheelsId);
        var engine = VehicleEngine.REGISTRY.getOrDefault(engineId);
        var client = MinecraftClient.getInstance();
        var player = client.player;
        assert player != null;
        if (player.world.getEntityById(entityId) instanceof VehicleEntity vehicle) {
            vehicle.setComponents(frame, wheel, engine);
        }
    }

    @Override
    public void toBytes(PacketByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeIdentifier(frameId);
        buf.writeIdentifier(wheelsId);
        buf.writeIdentifier(engineId);
    }
}
