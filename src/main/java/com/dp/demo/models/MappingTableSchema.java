package com.dp.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class MappingTableSchema {

    @Getter
    private String id;
    @Getter
    private String proxyId;

    public abstract String getIdColumnName();
}
