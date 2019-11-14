package com.mira.configuration;

import com.mira.document.Event;
import com.mira.document.User;
import com.mira.repository.EventRepository;
import com.mira.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@EnableMongoRepositories(basePackageClasses = {UserRepository.class, EventRepository.class})
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, EventRepository eventRepository) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName("Test");
        user.setSurname("Testov");
        user.setMail("test@mail.com");
        Event event = new Event();
        event.setId(UUID.randomUUID());
        event.setText("text");
        event.setTitle("Title");
        return string -> {
            userRepository.save(user);
            eventRepository.save(event);
        };
    }
}
