package br.com.senai.notifier.adapter.out.rabbitmq;

import br.com.senai.notifier.adapter.out.rabbitmq.event.NotificationEvent;
import br.com.senai.notifier.application.port.out.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherImpl implements EventPublisher {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(NotificationEvent event) {
        rabbitTemplate.convertAndSend("notifications", event);
    }
}