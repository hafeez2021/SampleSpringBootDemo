package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Pad;
import com.dp.demo.contracts.Persistence;

public class BrakeBrembo implements Brake {

    private final Pad pad;
    private final Persistence persistence;

    public BrakeBrembo(Pad pad, Persistence persistence)
    {

        this.pad = pad;
        this.persistence = persistence;
    }
    public String get() {
        return "Brembo " + "with Pad:" +pad.get() + " From Persistence:" + persistence.get();
    }
}
