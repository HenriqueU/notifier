package br.com.senai.notifier.application.port.out;

import br.com.senai.notifier.application.core.domain.Notification;

import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification notification);

    Optional<Notification> findById(String id);
}