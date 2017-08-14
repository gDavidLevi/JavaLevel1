package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Кот
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public final class Cat extends Felis {
    /**
     * Конструктор Cat
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Cat(String name, int age, String color) {
        super(name, age, color);

        /* Коты могут мурчать */
        super.setCanHum(true);

        /* Допусти Коты не плавают по умолчанию */
        super.setCanSwim(false);
    }

    /**
     * @return Boolean
     */
    @Override
    public Boolean isCanHum() {
        return super.isCanHum();
    }

    /**
     * Кот может прыгнуть максимум на 3 метра*
     *
     * @param distance расстояние double
     */
    public Boolean isCanJump(double distance) {
        if (distance <= 3)
            return true;
        else return false;
    }
}