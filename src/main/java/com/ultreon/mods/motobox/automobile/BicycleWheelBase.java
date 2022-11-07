package com.ultreon.mods.motobox.automobile;

public class BicycleWheelBase extends WheelBase {
    public BicycleWheelBase(float sepLong, float sepWide) {
        super(
                new WheelPos(sepLong / 2, sepWide, 1, 0, WheelEnd.FRONT, WheelSide.LEFT),
                new WheelPos(sepLong / -2, sepWide, 1, 0, WheelEnd.BACK, WheelSide.LEFT)
        );
    }
}
