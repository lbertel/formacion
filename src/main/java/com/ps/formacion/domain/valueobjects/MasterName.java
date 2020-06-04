package com.ps.formacion.domain.valueobjects;

import com.ps.formacion.shared.domain.StringValueObject;

public final class MasterName extends StringValueObject {

    public MasterName(String value) {
        super(value);
    }

    public MasterName(){
        super("");
    }
}
