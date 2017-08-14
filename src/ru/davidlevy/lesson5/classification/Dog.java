package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Собака
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public final class Dog extends Canis {
    /* Бездомное */
    private Boolean homeless;

    /**
     * Конструктор Dog
     *
     * @param name     String имя
     * @param age      int возраст
     * @param color    String цвет
     * @param homeless Boolean бездомный пёс?
     */
    public Dog(String name, int age, String color, Boolean homeless) {
        super(name, age, color);
        this.homeless = homeless;
    }

    private Boolean isHomeless() {
        return this.homeless;
    }

    private void setHomeless(Boolean can) {
        this.homeless = can;
    }

    /**
     * Собака может прыгнуть максимум на 4 метра*
     *
     * @param distance расстояние double
     */
    public Boolean isCanJump(double distance) {
        if (distance <= 4)
            return true;
        else return false;
    }
}