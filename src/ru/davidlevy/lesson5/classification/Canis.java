package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Волкообразные
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Canis extends Carnivora {
    /* Поддается тренировке? */
    private Boolean possibleTraining;

    /**
     * Конструктор Canis
     *
     * @param name  String
     * @param age   int
     * @param color String
     */
    public Canis(String name, int age, String color) {
        super(name, age, color);

        /* Все Волкообразные поддаются дрессировке */
        this.possibleTraining = true;
    }

    public Boolean isPossibleTraining() {
        return this.possibleTraining;
    }

    protected void setPossibleTraining(Boolean can) {
        this.possibleTraining = can;
    }
}