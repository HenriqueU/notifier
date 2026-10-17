package br.com.senai.notifier.application.core.domain;

import br.com.senai.notifier.application.core.enumeration.EventStatus;
import br.com.senai.notifier.application.core.enumeration.EventType;
import br.com.senai.notifier.application.core.enumeration.NotificationChannel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Notification {
    private String id;
    private EventType type;
    private NotificationChannel channel;
    private List<String> contacts;
    private LocalDateTime requestedAt;
    private String subject;
    private String template;
    private Map<String, Object> payload;
    private String author;
    private EventStatus status;
    private LocalDateTime updatedAt;

    public Notification() {
    }

    public Notification(
            String id,
            EventType type,
            NotificationChannel channel,
            List<String> contacts,
            LocalDateTime requestedAt,
            String subject,
            String template,
            Map<String, Object> payload,
            String author,
            EventStatus status,
            LocalDateTime updatedAt) {
        this.id = id;
        this.type = type;
        this.channel = channel;
        this.contacts = contacts;
        this.requestedAt = requestedAt;
        this.subject = subject;
        this.template = template;
        this.payload = payload;
        this.author = author;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public EventType getType() {
        return type;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public String getSubject() {
        return subject;
    }

    public String getTemplate() {
        return template;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public String getAuthor() {
        return author;
    }

    public EventStatus getStatus() {
        return status;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void request() {
        this.status = EventStatus.REQUESTED;
        this.updatedAt = LocalDateTime.now();
    }

    public void confirm() {
        this.status = EventStatus.CONFIRMED;
        this.updatedAt = LocalDateTime.now();
    }

    public void cancel() {
        this.status = EventStatus.CANCELLED;
        this.updatedAt = LocalDateTime.now();
    }
}