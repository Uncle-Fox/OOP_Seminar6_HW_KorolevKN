package org.example.view;

import org.example.model.*;

import java.util.Scanner;

public class View {
    public static void displayWelcomeMessage() {
        System.out.println("<---Это Игра Коровы и БЫКИ!--->");
        System.out.println("Доступные режимы игры:\n1. Числа\n2. Русский алфавит\n3. Английский алфавит");
    }

    public static int promptGameMode(Scanner scanner) {
        System.out.print("Введи число: ");
        return scanner.nextInt();
    }

    public static void displayInvalidInputMessage() {
        System.out.println("Неверный ввод! Попробуй еще раз.");
    }

    public static int promptSizeWordChoice(Scanner scanner) {
        System.out.println("Отлично! Теперь выбери размер загаданного слова!");
        System.out.print("Введи значение: ");
        return scanner.nextInt();
    }

    public static int promptCountLifeChoice(Scanner scanner) {
        System.out.print("А теперь укажи свое кол-во попыток: ");
        return scanner.nextInt();
    }

    public static String promptUserInput(Scanner scanner) {
        System.out.print("Введи значение: ");
        return scanner.next().toLowerCase();
    }

    public static void displayAnswer(Answer answer) {
        System.out.println(answer);
    }

    public static void displayWinMessage() {
        System.out.println("Ты победил! УРА!");
    }

    public static void displayLoseMessage(String word) {
        System.out.println("Ты проиграл!");
        System.out.println("Было загадано: " + word);
    }

    public static boolean promptShowHistory(Scanner scanner) {
        System.out.print("Хочешь посмотреть историю своей игры? (yes/no) ");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("yes");
    }

    public static void displayHistory(History history) {
        System.out.println("История игры:");
        for (String action : history.getActions()) {
            System.out.println(action);
        }
    }

    public static boolean promptPlayAgain(Scanner scanner) {
        System.out.print("Сыграем еще? (yes/no) ");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("yes");
    }
}
