package com.dp.demo.implementation;

import com.dp.demo.DemoRunner;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DemoSchema {

    @Getter
    private String source;
    @Getter
    private String tableName;
}
