package org.example.model;

public interface Game {
    void start(Integer var1, Integer var2);

    Answer inputValue(String var1);

    GameStatus getGameStatus();
    History getHistory();
}
