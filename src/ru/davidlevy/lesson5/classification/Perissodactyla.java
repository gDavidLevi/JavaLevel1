package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Непарнокопытные
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Perissodactyla extends Mammalia {
    private Boolean hasOddToedUngulates;

    /**
     * Конструктор Perissodactyla
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Perissodactyla(String name, int age, String color) {
        super(name, age, color);

        /* Все имеют нечётное число пальцев, образующих копыта */
        this.hasOddToedUngulates = true;
    }

    public Boolean isHasOddToedUngulates() {
        return this.hasOddToedUngulates;
    }
}