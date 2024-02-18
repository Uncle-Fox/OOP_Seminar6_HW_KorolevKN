package org.example.Controller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.example.Model.*;

import java.util.Scanner;

public class Main {
    //TODO Дописать игру быки-коровы
    //- на русском и английском алфавите
    //- сделать логирование действий и по запросу пользователя посмотреть всю историю игры
    //- * реализовать перезапуск игры
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("<---Это Игра Коровы и БЫКИ!--->");
            System.out.println("Доступные режимы игры:\n1. Числа\n2. Русский алфавит\n3. Английский алфавит\nВведи" +
                    " число: ");
            int gameMode = scanner.nextInt();
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
                    System.out.println("Неверный ввод! Попробуй еще раз.");
                    continue;
            }
            System.out.println("Отлично! Теперь выбери размер загаданного слова!");
            System.out.println("Введи значение: ");
            int sizeWordChoice = scanner.nextInt();
            System.out.println("А теперь укажи свое кол-во попыток: ");
            int countLifeChoice = scanner.nextInt();
            ag.start(sizeWordChoice, countLifeChoice);
            System.out.println("Введи значение: ");
            Scanner value = new Scanner(System.in);

            while (ag.getGameStatus().equals(GameStatus.START)) {
                Answer answer = ag.inputValue(value.nextLine().toLowerCase());
                System.out.println(answer);
            }

            if (ag.getGameStatus().equals(GameStatus.WIN)) {
                System.out.println("Ты победил! УРА!");
            }

            if (ag.getGameStatus().equals(GameStatus.LOOSE)) {
                System.out.println("Ты проиграл!");
                System.out.println("Было загадано: " + ag.getWord());
            }

            System.out.println("Хочешь посмотреть историю своей игры? (yes/no)");
            String showHistoryChoice = scanner.next();
            if(showHistoryChoice.equalsIgnoreCase("yes")){
                History history = ag.getHistory();
                for (String action: history.getActions()) {
                    System.out.println(action);
                }
            }

            System.out.println("Сыграем еще? (yes/no)");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}