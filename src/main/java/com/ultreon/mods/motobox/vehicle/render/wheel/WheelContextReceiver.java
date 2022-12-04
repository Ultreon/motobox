package com.ultreon.mods.motobox.vehicle.render.wheel;

import com.ultreon.mods.motobox.vehicle.WheelBase;

public interface WheelContextReceiver {
    void provideContext(WheelBase.WheelPos pos);
}
