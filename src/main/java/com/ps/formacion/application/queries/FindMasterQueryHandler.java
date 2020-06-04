package com.ps.formacion.application.queries;

import com.ps.formacion.application.results.MasterResponse;
import com.ps.formacion.domain.exception.MasterNotExist;
import com.ps.formacion.domain.valueobjects.MasterName;
import org.springframework.stereotype.Service;
import com.ps.formacion.shared.domain.bus.query.QueryHandler;

@Service
public final class FindMasterQueryHandler implements QueryHandler<FindMasterQuery, MasterResponse> {

    private final MasterFinder finder;

    public FindMasterQueryHandler(MasterFinder finder){
        this.finder = finder;
    }

    @Override
    public MasterResponse handle(FindMasterQuery query) throws MasterNotExist {
        return finder.find(new MasterName(query.getName()));
    }
}
