package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Pad;

public class BrakeUnbranded implements Brake {

    private final Pad pad;

    public BrakeUnbranded(Pad pad)
    {

        this.pad = pad;
    }
    public String get() {
        return "Unbranded Brake " + "with Pad:" +pad.get();
    }
}
