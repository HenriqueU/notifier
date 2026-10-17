package br.com.senai.notifier.adapter.out.repository.document;

import br.com.senai.notifier.application.core.enumeration.EventStatus;
import br.com.senai.notifier.application.core.enumeration.EventType;
import br.com.senai.notifier.application.core.enumeration.NotificationChannel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "notifications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class NotificationDocument {
    @Id
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
}