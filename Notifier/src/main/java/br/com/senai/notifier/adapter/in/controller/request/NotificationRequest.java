package br.com.senai.notifier.adapter.in.controller.request;

import br.com.senai.notifier.application.core.enumeration.EventType;
import br.com.senai.notifier.application.core.enumeration.NotificationChannel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record NotificationRequest(
        EventType type,
        NotificationChannel channel,
        List<String> contacts,
        LocalDateTime requestedAt,
        String subject,
        String template,
        Map<String, Object> payload,
        String author) {
}