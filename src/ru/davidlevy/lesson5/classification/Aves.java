package ru.davidlevy.lesson5.classification;

/**
 * Класс: Птицы
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Aves extends Ornithurae {
    /* Поля класса: перья, крылья, откладывает яйца */
    private Boolean hasFeathers;
    private Boolean hasWings;
    private Boolean laysEggs;

    /**
     * Конструктор Aves
     *
     * @param name  String
     * @param age   int
     * @param color String
     */
    public Aves(String name, int age, String color) {
        super(name, age, color);
        this.hasFeathers = true;
        this.hasWings = true;
        this.laysEggs = true;
    }

    public Boolean isHasFeathers() {
        return this.hasFeathers;
    }

    public Boolean isHasWings() {
        return this.hasWings;
    }

    public Boolean isLaysEggs() {
        return this.laysEggs;
    }
}