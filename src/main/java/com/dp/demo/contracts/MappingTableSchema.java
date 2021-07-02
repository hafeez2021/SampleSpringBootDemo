package com.dp.demo.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public abstract class MappingTableSchema {

    @Getter
    private String id;
    @Getter
    private String proxyId;

    public abstract String getIdColumnName();
}
