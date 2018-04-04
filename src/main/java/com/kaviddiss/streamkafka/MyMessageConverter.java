package com.kaviddiss.streamkafka;

import com.kaviddiss.streamkafka.model.Greetings;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.util.Arrays;

@Component
public class MyMessageConverter extends AbstractMessageConverter {

    public MyMessageConverter() {
        super(Arrays.asList(new MimeType("application", "greetings"),
                new MimeType("text", "plain")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return Greetings.class == aClass || String.class == aClass;
    }

    @Override
    protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
        Object payload = message.getPayload();
        String[] items = ((String) payload).split("\\|\\|");
        return Greetings.builder()
                .timestamp(Long.parseLong(items[0]))
                .message(items[1])
                .build();
    }

    @Override
    protected Object convertToInternal(Object payload, MessageHeaders headers, Object conversionHint) {
        String[] items = ((String) payload).split("\\|\\|");
        return Greetings.builder()
                .timestamp(Long.parseLong(items[0]))
                .message(items[1])
                .build();
    }
}
