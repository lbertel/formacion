package formacion.application.queries;

import formacion.application.results.MasterResponse;
import formacion.domain.exception.MasterNotExist;
import formacion.domain.valueobjects.MasterName;
import org.springframework.stereotype.Service;
import shared.domain.bus.query.QueryHandler;

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
