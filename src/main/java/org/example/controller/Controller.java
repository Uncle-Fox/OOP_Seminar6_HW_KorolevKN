package org.example.controller;

import org.example.model.AbstractGame;
import org.example.model.EngGame;
import org.example.model.GameStatus;
import org.example.model.NumberGame;
import org.example.model.RussianGame;
import org.example.view.View;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new View();

        view.displayWelcomeMessage();

        while (true) {
            int gameMode = view.promptGameMode(scanner);
            AbstractGame ag;

            switch (gameMode) {
                case 1:
                    ag = new NumberGame();
                    break;
                case 2:
                    ag = new RussianGame();
                    break;
                case 3:
                    ag = new EngGame();
                    break;
                default:
                    view.displayInvalidInputMessage();
                    continue;
            }

            int sizeWordChoice = view.promptSizeWordChoice(scanner);
            int countLifeChoice = view.promptCountLifeChoice(scanner);
            ag.start(sizeWordChoice, countLifeChoice);

            while (ag.getGameStatus().equals(GameStatus.START)) {
                String userInput = view.promptUserInput(scanner);
                view.displayAnswer(ag.inputValue(userInput));
            }

            if (ag.getGameStatus().equals(GameStatus.WIN)) {
                view.displayWinMessage();
            } else if (ag.getGameStatus().equals(GameStatus.LOOSE)) {
                view.displayLoseMessage(ag.getWord());
            }

            if (view.promptShowHistory(scanner)) {
                view.displayHistory(ag.getHistory());
            }

            if (!view.promptPlayAgain(scanner)) {
                break;
            }
        }
    }
}
