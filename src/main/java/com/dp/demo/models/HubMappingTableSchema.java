package com.dp.demo.models;

public class HubMappingTableSchema extends MappingTableSchema {

    public HubMappingTableSchema(String id, String proxyId)
    {
        super(id, proxyId);
    }

    @Override
    public String getIdColumnName()
    {
        return "HUB";
    }
}
