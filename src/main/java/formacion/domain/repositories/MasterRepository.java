package formacion.domain.repositories;

import formacion.domain.Master;
import formacion.domain.valueobjects.MasterName;

import java.util.Optional;

public interface MasterRepository {
    Optional<Master> search(MasterName name);
}
