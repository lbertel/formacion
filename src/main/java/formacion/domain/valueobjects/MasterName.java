package formacion.domain.valueobjects;

import shared.domain.StringValueObject;

public final class MasterName extends StringValueObject {

    public MasterName(String value) {
        super(value);
    }

    public MasterName(){
        super("");
    }
}
