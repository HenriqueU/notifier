package br.com.senai.notifier.application.port.in;

import br.com.senai.notifier.adapter.in.controller.request.NotificationRequest;
import br.com.senai.notifier.adapter.in.controller.response.NotificationDetail;
import org.springframework.http.ResponseEntity;

public interface StdNotification {
    ResponseEntity<NotificationDetail> notify(NotificationRequest request);
}