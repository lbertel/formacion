package formacion.infrastructure.usecases.queries;

import formacion.application.queries.FindMasterQuery;
import formacion.application.results.MasterResponse;
import formacion.domain.exception.MasterNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import shared.domain.DomainError;
import shared.domain.bus.command.CommandBus;
import shared.domain.bus.query.QueryBus;
import shared.domain.bus.query.QueryHandlerExecutionError;
import shared.infrastructure.spring.ApiController;

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
