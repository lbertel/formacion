package com.ps.formacion.shared.infrastructure.event.rabbitmq;

import com.ps.formacion.shared.domain.bus.event.DomainEvent;
import com.ps.formacion.shared.domain.bus.event.EventBus;
import org.springframework.amqp.AmqpException;

import java.util.List;

public class RabbitMqEventBus implements EventBus {
    private final com.ps.formacion.shared.infrastructure.event.rabbitmq.RabbitMqPublisher publisher;
    //private final MySqlEventBus                                                        failoverPublisher;
    private final String            exchangeName;

    public RabbitMqEventBus(com.ps.formacion.shared.infrastructure.event.rabbitmq.RabbitMqPublisher publisher){
        this.publisher         = publisher;
        // this.failoverPublisher = failoverPublisher;
        this.exchangeName      = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            // failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
