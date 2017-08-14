package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Змея
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public final class Snake extends Serpentes {
    /**
     * Конструктор Snake
     *
     * @param name                String имя
     * @param age                 int возраст
     * @param color               String цвет
     * @param poisonous           Boolean ядовитая?
     * @param livesInSerpentarium Boolean живет вневоле?
     */
    public Snake(String name, int age, String color, Boolean poisonous, Boolean livesInSerpentarium) {
        super(name, age, color, poisonous, livesInSerpentarium);
    }

    public Boolean isPoisonous() {
        return super.isPoisonous();
    }
}