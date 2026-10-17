package br.com.senai.notifier.application.service;

import br.com.senai.notifier.adapter.in.controller.mapper.NotificationMapper;
import br.com.senai.notifier.adapter.in.controller.request.NotificationRequest;
import br.com.senai.notifier.adapter.in.controller.response.NotificationDetail;
import br.com.senai.notifier.adapter.out.rabbitmq.EventPublisherImpl;
import br.com.senai.notifier.adapter.out.rabbitmq.event.NotificationEvent;
import br.com.senai.notifier.adapter.out.rabbitmq.mapper.NotificationEventMapper;
import br.com.senai.notifier.application.core.domain.Notification;
import br.com.senai.notifier.application.port.out.EventPublisher;
import br.com.senai.notifier.application.port.out.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationMapper mapper;
    private final NotificationRepository repository;
    private final NotificationEventMapper eventMapper;
    private final EventPublisher publisher;

    public NotificationDetail notify(NotificationRequest request) {
        Notification notification = mapper.toDomain(request);
        notification.request();
        Notification saved = repository.save(notification);
        NotificationEvent event = eventMapper.toPub(saved);
        publisher.publish(event);
        return mapper.toDetail(saved);
    }
}