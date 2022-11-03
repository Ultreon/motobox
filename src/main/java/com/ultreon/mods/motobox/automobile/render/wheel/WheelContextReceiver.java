package com.ultreon.mods.motobox.automobile.render.wheel;

import com.ultreon.mods.motobox.automobile.WheelBase;

public interface WheelContextReceiver {
    void provideContext(WheelBase.WheelPos pos);
}
