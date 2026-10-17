package br.com.senai.notifier.adapter.out.repository;

import br.com.senai.notifier.adapter.out.repository.document.NotificationDocument;
import br.com.senai.notifier.adapter.out.repository.mapper.NotificationDocumentMapper;
import br.com.senai.notifier.adapter.out.repository.persistence.NotificationMongoRepository;
import br.com.senai.notifier.application.core.domain.Notification;
import br.com.senai.notifier.application.port.out.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationMongoRepository mongoRepository;
    private final NotificationDocumentMapper documentMapper;

    @Override
    public Notification save(Notification notification) {
        NotificationDocument document = documentMapper.toDocument(notification);
        NotificationDocument saved = mongoRepository.save(document);
        return documentMapper.toDomain(saved);
    }

    @Override
    public Optional<Notification> findById(String id) {
        return mongoRepository.findById(id).map(documentMapper::toDomain);
    }
}