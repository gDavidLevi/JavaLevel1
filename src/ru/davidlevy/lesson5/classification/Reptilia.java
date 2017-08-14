package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Пресмыкающиеся
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Reptilia extends Chordata {
    private Boolean coldBlooded;

    /**
     * Конструктор Reptilia
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Reptilia(String name, int age, String color) {
        super(name, age, color);
        super.setCanCrawl(true); // Да будут ползать!
        super.setCanSwim(true); // Да будут плавать!
        super.setCanWalk(true); // Да будут ходить!
        this.coldBlooded = true; // все холоднокровные!
    }

    public Boolean isColdBlooded() {
        return this.coldBlooded;
    }
}