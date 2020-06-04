package com.ps.formacion.application.queries;

import com.ps.formacion.application.results.MasterResponse;
import com.ps.formacion.domain.exception.MasterNotExist;
import com.ps.formacion.domain.repositories.MasterRepository;
import com.ps.formacion.domain.valueobjects.MasterName;
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
