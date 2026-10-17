package br.com.senai.notifier.adapter.out.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailTemplateProcessor {
    private final TemplateEngine templateEngine;

    public String process(String template, Map<String, Object> variables) {
        Context context = new Context();
        variables.forEach(context::setVariable);
        return templateEngine.process(template, context);
    }
}