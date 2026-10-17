package br.com.senai.notifier.adapter.out.repository.persistence;

import br.com.senai.notifier.adapter.out.repository.document.NotificationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMongoRepository extends MongoRepository<NotificationDocument, String> {
}