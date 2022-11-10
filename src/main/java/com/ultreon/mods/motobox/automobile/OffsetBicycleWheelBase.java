package com.ultreon.mods.motobox.automobile;

public class OffsetBicycleWheelBase extends WheelBase {
    public OffsetBicycleWheelBase(float sepLong, float offset) {
        super(
                new WheelPos(offset + sepLong / 2, 0, 1, 0, WheelEnd.FRONT, WheelSide.LEFT),
                new WheelPos(offset + sepLong / -2, 0, 1, 0, WheelEnd.BACK, WheelSide.LEFT)
        );
    }
}
