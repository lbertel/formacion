package com.ps.formacion.application.queries;

import com.ps.formacion.shared.domain.bus.query.Query;

public class FindMasterQuery implements Query {

    private final String name;

    public FindMasterQuery(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
