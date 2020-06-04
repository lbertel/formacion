package com.ps.formacion.shared.domain.bus.event;

import com.ps.formacion.shared.domain.Utils;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class DomainEvent {

    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.occurredOn = occurredOn;
    }

    public DomainEvent() {
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getOccurredOn() {
        return occurredOn;
    }
}
