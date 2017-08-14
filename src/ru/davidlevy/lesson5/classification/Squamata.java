package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Чешуйчатые
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Squamata extends Reptilia {
    private Boolean hasScales;

    /**
     * Конструктор Squamata
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Squamata(String name, int age, String color) {
        super(name, age, color);

        /* все тела покрыты сверху роговыми чешуями, щитками или зёрнышками */
        this.hasScales = true;
    }

    public Boolean isHasScales() {
        return this.hasScales;
    }
}