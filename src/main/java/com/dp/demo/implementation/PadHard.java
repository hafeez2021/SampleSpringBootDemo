package com.dp.demo.implementation;

import com.dp.demo.contracts.Pad;

public class PadHard implements Pad {
    @Override
    public String get() {
        return "Pad: Hard Pad";
    }
}
