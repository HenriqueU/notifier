package br.com.senai.notifier.adapter.out.rabbitmq.mapper;

import br.com.senai.notifier.adapter.out.rabbitmq.event.NotificationEvent;
import br.com.senai.notifier.application.core.domain.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventMapper {
    public NotificationEvent toPub(Notification notification) {
        return new NotificationEvent(
                notification.getId(),
                notification.getType(),
                notification.getChannel(),
                notification.getContacts(),
                notification.getRequestedAt(),
                notification.getSubject(),
                notification.getTemplate(),
                notification.getPayload(),
                notification.getAuthor(),
                notification.getStatus(),
                notification.getUpdatedAt()
        );
    }
}