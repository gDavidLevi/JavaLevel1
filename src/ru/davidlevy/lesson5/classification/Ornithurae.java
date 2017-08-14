package ru.davidlevy.lesson5.classification;

/**
 * Класс: Веерохвостые (веерохвостые птицы)
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Ornithurae extends Chordata {
    private Boolean hasTail; // хвост

    /**
     * Конструктор Ornithurae
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Ornithurae(String name, int age, String color) {
        super(name, age, color);
        super.setCanRun(true); // Да будут бегать!
        super.setCanSwim(true); // Да будут плавать!
        super.setCanJump(true); // Да будут прыгать!
        super.setCanFly(true); // Да будут летать!
        super.setCanWalk(true); // Да будут ходить!
        this.hasTail = true;  // все имеют хвост!
    }

    public Boolean isHasTail() {
        return this.hasTail;
    }
}