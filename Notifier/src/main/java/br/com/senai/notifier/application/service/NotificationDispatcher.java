package br.com.senai.notifier.application.service;

import br.com.senai.notifier.application.core.domain.Notification;
import br.com.senai.notifier.application.port.out.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationDispatcher {
    private final List<NotificationSender> senders;

    public void dispatch(Notification notification) {
        NotificationSender sender = senders
                .stream()
                .filter(s -> s.supports(notification.getChannel()))
                .findFirst()
                .orElseThrow();
        sender.send(notification);
    }
}