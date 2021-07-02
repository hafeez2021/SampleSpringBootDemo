package com.dp.demo.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class NRICMappingTableSchema extends MappingTableSchema {

    public NRICMappingTableSchema(String id, String proxyId)
    {
        super(id, proxyId);
    }

    @Override
    public String getIdColumnName()
    {
        return "NRIC";
    }
}
