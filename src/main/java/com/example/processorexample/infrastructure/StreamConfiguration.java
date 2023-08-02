package com.example.processorexample.infrastructure;

import com.example.processorexample.application.ProcessorEngine;
import com.example.processorexample.domain.Game;
import com.example.processorexample.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.io.Flushable;
import java.util.function.Function;

@Configuration
public class StreamConfiguration {
    @Bean
    public Function<Flux<Game>, Flux<User>> processBinding(final ProcessorEngine processorEngine) {
        return processorEngine::process;
    }
}
