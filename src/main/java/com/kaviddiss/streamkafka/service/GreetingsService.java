package com.kaviddiss.streamkafka.service;

import com.kaviddiss.streamkafka.model.Greetings;

public interface GreetingsService {
    void sendGreeting(final Greetings greetings);
}
