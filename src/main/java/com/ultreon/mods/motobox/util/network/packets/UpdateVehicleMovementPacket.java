package com.ultreon.mods.motobox.util.network.packets;

import com.ultreon.mods.lib.network.api.packet.PacketToServer;
import com.ultreon.mods.motobox.entity.VehicleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.NotNull;

public class UpdateVehicleMovementPacket extends PacketToServer<UpdateVehicleMovementPacket> {
    private final boolean fwd;
    private final boolean back;
    private final boolean left;
    private final boolean right;
    private final boolean space;
    private final int entityId;

    public UpdateVehicleMovementPacket(PacketByteBuf buf) {
        fwd = buf.readBoolean();
        back = buf.readBoolean();
        left = buf.readBoolean();
        right = buf.readBoolean();
        space = buf.readBoolean();
        entityId = buf.readInt();
    }

    public UpdateVehicleMovementPacket(Entity entity, boolean fwd, boolean back, boolean left, boolean right, boolean space) {
        this(entity.getId(), fwd, back, left, right, space);
    }

    public UpdateVehicleMovementPacket(int entityId, boolean fwd, boolean back, boolean left, boolean right, boolean space) {
        this.fwd = fwd;
        this.back = back;
        this.left = left;
        this.right = right;
        this.space = space;
        this.entityId = entityId;
    }

    @Override
    protected void handle(@NotNull ServerPlayerEntity sender) {
        if (sender.world.getEntityById(entityId) instanceof VehicleEntity vehicle) {
            vehicle.setInputs(fwd, back, left, right, space);
            vehicle.markDirty();
        }
    }

    @Override
    public void toBytes(PacketByteBuf buf) {
        buf.writeBoolean(fwd);
        buf.writeBoolean(back);
        buf.writeBoolean(left);
        buf.writeBoolean(right);
        buf.writeBoolean(space);
        buf.writeInt(entityId);
    }
}
