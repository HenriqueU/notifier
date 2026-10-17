package br.com.senai.notifier.adapter.out.repository.mapper;

import br.com.senai.notifier.adapter.out.repository.document.NotificationDocument;
import br.com.senai.notifier.application.core.domain.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationDocumentMapper {
    public NotificationDocument toDocument(Notification domain) {
        return new NotificationDocument(
                domain.getId(),
                domain.getType(),
                domain.getChannel(),
                domain.getContacts(),
                domain.getRequestedAt(),
                domain.getSubject(),
                domain.getTemplate(),
                domain.getPayload(),
                domain.getAuthor(),
                domain.getStatus(),
                domain.getUpdatedAt()
        );
    }

    public Notification toDomain(NotificationDocument document) {
        return new Notification(
                document.getId(),
                document.getType(),
                document.getChannel(),
                document.getContacts(),
                document.getRequestedAt(),
                document.getSubject(),
                document.getTemplate(),
                document.getPayload(),
                document.getAuthor(),
                document.getStatus(),
                document.getUpdatedAt()
        );
    }
}