package br.com.senai.notifier.adapter.in.controller.response;

import br.com.senai.notifier.application.core.enumeration.EventStatus;
import br.com.senai.notifier.application.core.enumeration.EventType;
import br.com.senai.notifier.application.core.enumeration.NotificationChannel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record NotificationDetail(
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
}