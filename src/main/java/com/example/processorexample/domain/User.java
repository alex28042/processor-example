package com.example.processorexample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class User {
    private String name;
    private ArrayList<Game> games;

    public void addGame(Game game) {
        this.games.add(game);
    }
}
