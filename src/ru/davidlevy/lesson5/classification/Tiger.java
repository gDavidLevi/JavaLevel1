package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Тигр
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public final class Tiger extends Felis {
    /**
     * Конструктор Tiger
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Tiger(String name, int age, String color) {
        super(name, age, color);
        super.setCanHum(false);
    }
}