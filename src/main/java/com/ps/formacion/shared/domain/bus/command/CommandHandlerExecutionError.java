package com.ps.formacion.shared.domain.bus.command;

public final class CommandHandlerExecutionError extends RuntimeException {

    public CommandHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}