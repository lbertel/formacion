package com.ps.formacion.domain.exception;

import com.ps.formacion.domain.valueobjects.MasterName;
import com.ps.formacion.shared.domain.DomainError;

public final class MasterNotExist extends DomainError {

    public MasterNotExist(MasterName name){
        super("master_not_exist", String.format("The master <%s> doesn't exist", name.getValue()));
    }

}
