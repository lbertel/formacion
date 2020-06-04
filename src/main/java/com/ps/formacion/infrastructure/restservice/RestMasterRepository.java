package com.ps.formacion.infrastructure.restservice;

import com.ps.formacion.domain.Master;
import com.ps.formacion.domain.repositories.MasterRepository;
import com.ps.formacion.domain.valueobjects.MasterName;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestMasterRepository implements MasterRepository {

    private MasterFeignClient feignClient;

    public RestMasterRepository(MasterFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public Optional<Master> search(MasterName name) {
        return Optional.empty();
    }
}
