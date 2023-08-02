package com.example.processorexample.application;

import com.example.processorexample.domain.Game;
import com.example.processorexample.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@Component
@Slf4j
public class ProcessorEngine {
    public Flux<User> process(Flux<Game> inbound) {
        return inbound
                .doOnNext(game -> log.info("game -> {}", game.toString()))
                .flatMap(game -> {
                    var user = new User();
                    user.setName("holasa");
                    user.setGames(new ArrayList<>());
                    user.addGame(game);

                    return Flux.just(user);
                })
                .onErrorContinue(this::handleError);
    }

    private void handleError(Throwable throwable, Object object) {
        log.error("Unable to process event throwable {} and {}", throwable, object);
    }
}
