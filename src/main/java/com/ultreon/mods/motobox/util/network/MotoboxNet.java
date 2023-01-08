package com.ultreon.mods.motobox.util.network;

import com.ultreon.mods.lib.network.api.Network;
import com.ultreon.mods.lib.network.api.PacketRegisterContext;
import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.util.network.packets.*;

public class MotoboxNet extends Network {
    static MotoboxNet instance;

    public static MotoboxNet get() {
        return instance;
    }

    protected MotoboxNet() {
        super(Motobox.MOD_ID, "main");
    }

    @Override
    protected void registerPackets(PacketRegisterContext ctx) {
        ctx.register(UpdateVehicleMovementPacket::new);
        ctx.register(UpdateVehicleComponentsPacket::new);
        ctx.register(VehicleDataChangedPacket::new);
        ctx.register(VehicleComponentsChangedPacket::new);
        ctx.register(VehicleAttachmentsChangedPacket::new);
        ctx.register(BannerPostAttachmentUpdatePacket::new);
    }
}
