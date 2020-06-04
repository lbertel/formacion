package formacion.application.queries;

import formacion.application.results.MasterResponse;
import formacion.domain.exception.MasterNotExist;
import formacion.domain.repositories.MasterRepository;
import formacion.domain.valueobjects.MasterId;
import formacion.domain.valueobjects.MasterName;
import org.springframework.stereotype.Service;

@Service
public final class MasterFinder {
    private final MasterRepository repository;

    public MasterFinder(MasterRepository repository) {
        this.repository = repository;
    }

    public MasterResponse find(MasterName name) throws MasterNotExist{
        return repository.search(name)
                .map(MasterResponse::fromAggregate)
                .orElseThrow(() -> new MasterNotExist(name));
    }
}
