package formacion.application.results;

import formacion.domain.Master;
import shared.domain.bus.query.Response;

public class MasterResponse implements Response {

    private final String   uuid;
    private final String name;

    public MasterResponse(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public static MasterResponse fromAggregate(Master master){
        return new MasterResponse(master.getId().getValue(), master.getName().getValue());
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
