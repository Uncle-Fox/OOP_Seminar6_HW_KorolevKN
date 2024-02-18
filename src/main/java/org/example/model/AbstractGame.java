package org.example.model;


import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    private String word;
    Integer tryCount;
    GameStatus gameStatus;
    History history;

    public AbstractGame() {
        this.gameStatus = GameStatus.INIT;
        history = new History();
    }

    abstract List<String> generateCharList();

    public void start(Integer sizeWord, Integer tryCount) {
        this.word = this.generateWord(sizeWord);
        this.tryCount = tryCount;
        this.gameStatus = GameStatus.START;
    }

    private String generateWord(Integer sizeWord) {
        List<String> alphabet = this.generateCharList();
        Random rnd = new Random();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < sizeWord; ++i) {
            int randomIndex = rnd.nextInt(alphabet.size());
            res.append(alphabet.get(randomIndex));
            alphabet.remove(randomIndex);
        }

        return res.toString();
    }

    public Answer inputValue(String value) {
        if (!this.getGameStatus().equals(GameStatus.START)) {
            throw new RuntimeException("Игра не запущена");
        } else {
            int cowCounter = 0;
            int bullCounter = 0;

            for(int i = 0; i < this.word.length(); ++i) {
                if (value.charAt(i) == this.word.charAt(i)) {
                    ++cowCounter;
                    ++bullCounter;
                } else if (this.word.contains(String.valueOf(value.charAt(i)))) {
                    ++cowCounter;
                }
            }

            this.tryCount--;
            if (this.tryCount == 0) {
                this.gameStatus = GameStatus.LOOSE;
            }

            if (bullCounter == this.word.length()) {
                this.gameStatus = GameStatus.WIN;
            }

//            Добавили логирование действий тут
            history.addActions("Попытка: " + value + ", результат: " + cowCounter + " коровы, " + bullCounter + " быка");


            return new Answer(cowCounter, bullCounter, this.tryCount);
        }
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public History getHistory(){
        return history;
    }

    public String getWord() {
        return word;
    }
}
