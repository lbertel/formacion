package com.ps.formacion.domain.repositories;

import com.ps.formacion.domain.Master;
import com.ps.formacion.domain.valueobjects.MasterName;

import java.util.Optional;

public interface MasterRepository {
    Optional<Master> search(MasterName name);
}
