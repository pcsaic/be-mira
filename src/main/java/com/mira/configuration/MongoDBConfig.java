package com.mira.configuration;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;
import com.mira.document.User;
import com.mira.repository.EventRepository;
import com.mira.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;


@Component
@EnableMongoRepositories(basePackageClasses = {UserRepository.class, EventRepository.class})
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, EventRepository eventRepository) {
        User user = new User(
                UUID.randomUUID(),
                "Test",
                "Testov",
                "test@mail.com"
        );

        Event event = new Event(
                UUID.randomUUID(),
                "Title",
                LocalDateTime.now(),
                LocalDateTime.now(),
                UUID.randomUUID(),
                EventType.STORY,
                EventStatus.DONE,
                UUID.randomUUID()
        );

        return string -> {
            userRepository.save(user);
            eventRepository.save(event);
        };
    }
}
