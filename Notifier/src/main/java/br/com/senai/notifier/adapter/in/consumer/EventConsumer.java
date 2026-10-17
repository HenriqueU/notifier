package br.com.senai.notifier.adapter.in.consumer;

import br.com.senai.notifier.adapter.out.rabbitmq.event.NotificationEvent;
import br.com.senai.notifier.application.core.domain.Notification;
import br.com.senai.notifier.application.port.out.NotificationRepository;
import br.com.senai.notifier.application.service.NotificationDispatcher;
import br.com.senai.notifier.exception.EventNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EventConsumer {
    private final NotificationRepository repository;
    private final NotificationDispatcher dispatcher;

    @RabbitListener(queues = "notifications")
    @Transactional
    public void receive(NotificationEvent event) {
        Notification notification = repository
                .findById(event.id())
                .orElseThrow(() ->
                        new EventNotFoundException("ID do evento informado não existe!")
                );
        try {
            dispatcher.dispatch(notification);
            notification.confirm();
        } catch (Exception e) {
            notification.cancel();
        }
        repository.save(notification);
    }
}