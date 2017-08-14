package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Лошадь
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public final class Horse extends Equus {
    /**
     * Конструктор Horse
     *
     * @param name       String имя
     * @param age        int возраст
     * @param color      String цвет
     * @param wilderness Boolean дикая?
     * @param canNeighs  Boolean может ржать?
     */
    public Horse(String name, int age, String color, Boolean wilderness, Boolean canNeighs) {
        super(name, age, color, wilderness, canNeighs);
    }
}