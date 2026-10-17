package br.com.senai.notifier.application.port.out;

import br.com.senai.notifier.adapter.out.rabbitmq.event.NotificationEvent;

public interface EventPublisher {
    void publish(NotificationEvent event);
}