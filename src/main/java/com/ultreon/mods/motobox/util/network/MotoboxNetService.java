package com.ultreon.mods.motobox.util.network;

import com.ultreon.mods.lib.network.api.Network;
import com.ultreon.mods.lib.network.api.NetworkManager;
import com.ultreon.mods.lib.network.api.service.NetworkService;

public class MotoboxNetService implements NetworkService {
    @Override
    public void setup() {
        MotoboxNet.instance = new MotoboxNet();
    }
}
