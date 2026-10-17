package br.com.senai.notifier.adapter.in.controller.mapper;

import br.com.senai.notifier.adapter.in.controller.request.NotificationRequest;
import br.com.senai.notifier.adapter.in.controller.response.NotificationDetail;
import br.com.senai.notifier.application.core.domain.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public Notification toDomain(NotificationRequest request) {
        return new Notification(
                null,
                request.type(),
                request.channel(),
                request.contacts(),
                request.requestedAt(),
                request.subject(),
                request.template(),
                request.payload(),
                request.author(),
                null,
                null
        );
    }

    public NotificationDetail toDetail(Notification notification) {
        return new NotificationDetail(
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