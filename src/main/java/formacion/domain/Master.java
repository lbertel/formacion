package formacion.domain;

import formacion.domain.valueobjects.MasterId;
import formacion.domain.valueobjects.MasterName;
import shared.domain.AggregateRoot;

public final class Master extends AggregateRoot {

    private final MasterId id;
    private final MasterName name;

    public Master(MasterId id, MasterName name) {
        this.id = id;
        this.name = name;
    }

    public Master() {
        id = null;
        name = null;
    }

    public MasterId getId() {
        return id;
    }

    public MasterName getName() {
        return name;
    }
}
