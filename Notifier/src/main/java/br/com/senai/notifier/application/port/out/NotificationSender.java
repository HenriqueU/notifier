package br.com.senai.notifier.application.port.out;

import br.com.senai.notifier.application.core.domain.Notification;
import br.com.senai.notifier.application.core.enumeration.NotificationChannel;

public interface NotificationSender {
    boolean supports(NotificationChannel channel);

    void send(Notification notification);
}