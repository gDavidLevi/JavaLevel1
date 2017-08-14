package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Млекопитающие
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Mammalia extends Chordata {
    private boolean fedOnMilks;

    /**
     * Конструктор Mammalia
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Mammalia(String name, int age, String color) {
        super(name, age, color);
        super.setCanCrawl(true); // Да будут ползать!
        super.setCanRun(true); // Да будут бегать!
        super.setCanSwim(true); // Да будут плавать!
        super.setCanJump(true); // Да будут прыгать!
        super.setCanWalk(true); // Да будут ходить!
        this.fedOnMilks = true;  // все вскормлены молоком!
    }

    public boolean isFedOnMilks() {
        return this.fedOnMilks;
    }
}