package ru.davidlevy.lesson5.classification;

/**
 * Класс: Попугай
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public final class Parrot extends Aves {
    private Boolean canSpeak;

    /**
     * Конструктор Parrot
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Parrot(String name, int age, String color, Boolean canFly, Boolean canSpeak) {
        super(name, age, color);
        this.canSpeak = canSpeak;
    }

    public Boolean isCanSpeak() {
        return this.canSpeak;
    }
}