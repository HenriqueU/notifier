package br.com.senai.notifier.adapter.in.controller;

import br.com.senai.notifier.adapter.in.controller.request.NotificationRequest;
import br.com.senai.notifier.adapter.in.controller.response.NotificationDetail;
import br.com.senai.notifier.application.port.in.StdNotification;
import br.com.senai.notifier.application.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifier/notifications")
@RequiredArgsConstructor
public class NotificationController implements StdNotification {
    private final NotificationService service;

    @Override
    @PostMapping
    public ResponseEntity<NotificationDetail> notify(
            @RequestBody NotificationRequest request) {
        return ResponseEntity.ok(service.notify(request));
    }
}