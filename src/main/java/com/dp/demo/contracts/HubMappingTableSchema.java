package com.dp.demo.contracts;

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
