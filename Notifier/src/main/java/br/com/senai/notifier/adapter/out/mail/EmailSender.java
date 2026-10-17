package br.com.senai.notifier.adapter.out.mail;

import br.com.senai.notifier.application.core.domain.Notification;
import br.com.senai.notifier.application.core.enumeration.NotificationChannel;
import br.com.senai.notifier.application.port.out.NotificationSender;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSender implements NotificationSender {
    private final JavaMailSender mailSender;
    private final EmailTemplateProcessor processor;

    private String sender = "cemoliveir@gmail.com";

    @Override
    public boolean supports(NotificationChannel channel) {
        return NotificationChannel.EMAIL.equals(channel);
    }

    @Override
    public void send(Notification notification) {
        String html = processor.process(
                notification.getTemplate(),
                notification.getPayload()
        );
        for (String contact : notification.getContacts()) {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(
                        message,
                        true,
                        "UTF-8"
                );
                helper.setFrom(sender);
                helper.setTo(contact);
                helper.setSubject(notification.getSubject());
                helper.setText(html, true);
                mailSender.send(message);
                System.out.println("Email enviado com sucesso para: " + contact + "!");
            } catch (Exception e) {
                System.err.println("Erro ao enviar email para: " + contact + "!");
            }
        }
    }
}