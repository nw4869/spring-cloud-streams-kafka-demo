package com.kaviddiss.streamkafka.service;

import com.kaviddiss.streamkafka.model.Greetings;
import com.kaviddiss.streamkafka.stream.GreetingsStreams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;


@EnableBinding(GreetingsStreams.class)
public class GreetingsSource {
    @Value("${format}")
    private String format;

//    @Bean
//    @InboundChannelAdapter(value = GreetingsStreams.OUTPUT, poller = @Poller(fixedDelay = "${fixedDelay}", maxMessagesPerPoll = "1"))
//    public MessageSource<Greetings> timerMessageSource() {
//        return () -> new GenericMessage<>(Greetings.builder()
//                .message("timerMessageSource")
//                .timestamp(System.currentTimeMillis())
//                .build());
//    }

    @Bean
    @InboundChannelAdapter(value = GreetingsStreams.OUTPUT, poller = @Poller(fixedDelay = "${fixedDelay}", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource1() {
//        return () -> new GenericMessage<>(Greetings.builder()
//                .message("timerMessageSource")
//                .timestamp(System.currentTimeMillis())
//                .build());

//        Map<String, Object> headers = new HashMap<>();
//        headers.put(MessageHeaders.CONTENT_TYPE, "application/greetings");

        return () -> new GenericMessage<>(String.valueOf(System.currentTimeMillis()) + "||" + "eeeee");
    }
}
