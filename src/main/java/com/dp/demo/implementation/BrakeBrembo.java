package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Pad;
import com.dp.demo.contracts.Persistence;
import com.dp.demo.contracts.QueryableRepository;

public class BrakeBrembo implements Brake {

    private final Pad pad;
    private final QueryableRepository queryableRepository;

    public BrakeBrembo(Pad pad, QueryableRepository queryableRepository)
    {
        this.pad = pad;
        this.queryableRepository = queryableRepository;
    }

    public String get() {
        return "Brembo " + "with Pad:" +pad.get() + " From Persistence:" + queryableRepository.select();
    }
}
