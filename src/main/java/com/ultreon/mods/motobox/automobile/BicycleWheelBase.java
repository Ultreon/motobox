package com.ultreon.mods.motobox.automobile;

public class BicycleWheelBase extends WheelBase {
    public BicycleWheelBase(float sepLong) {
        super(
                new WheelPos(sepLong / 2, 0, 1, 0, WheelEnd.FRONT, WheelSide.LEFT),
                new WheelPos(sepLong / -2, 0, 1, 0, WheelEnd.BACK, WheelSide.LEFT)
        );
    }
}
