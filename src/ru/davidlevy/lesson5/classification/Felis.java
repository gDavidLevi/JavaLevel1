package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Кошачии
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Felis extends Carnivora {
    /* Может мурчать? */
    private Boolean canHum;

    /**
     * Конструктор Felis
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Felis(String name, int age, String color) {
        super(name, age, color);

        this.canHum = false;  // допустим все Кошачии НЕ могут мурчать
    }

    public Boolean isCanHum() {
        return this.canHum;
    }

    protected void setCanHum(Boolean can) {
        this.canHum = can;
    }
}