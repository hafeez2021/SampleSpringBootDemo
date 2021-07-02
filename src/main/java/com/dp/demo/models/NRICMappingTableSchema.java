package com.dp.demo.models;

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
