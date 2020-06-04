package com.ps.formacion.infrastructure.usecases.queries;

import com.ps.formacion.application.queries.FindMasterQuery;
import com.ps.formacion.application.results.MasterResponse;
import com.ps.formacion.domain.exception.MasterNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ps.formacion.shared.domain.DomainError;
import com.ps.formacion.shared.domain.bus.command.CommandBus;
import com.ps.formacion.shared.domain.bus.query.QueryBus;
import com.ps.formacion.shared.domain.bus.query.QueryHandlerExecutionError;
import com.ps.formacion.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public class MasterGetController extends ApiController {

    public MasterGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/master/{name}")
    public ResponseEntity<HashMap<String, Serializable>> find(@PathVariable String name) throws QueryHandlerExecutionError {

        MasterResponse master = ask(new FindMasterQuery(name));

        return ResponseEntity.ok().body(new HashMap<String, Serializable>() {{
            put("id", master.getUuid());
            put("name", master.getName());
        }});

    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>(){{
           put(MasterNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
