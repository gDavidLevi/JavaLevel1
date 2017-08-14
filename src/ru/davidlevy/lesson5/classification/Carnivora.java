package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Плотоядные
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Carnivora extends Mammalia {
    /* Едят плоть? */
    private boolean eatTheFlesh;

    /**
     * Конструктор Carnivora
     *
     * @param name  String
     * @param age   int
     * @param color String
     */
    public Carnivora(String name, int age, String color) {
        super(name, age, color);

        /* Все едят плоть! */
        this.eatTheFlesh = true;
    }

    public boolean isEatTheFlesh() {
        return this.eatTheFlesh;
    }
}