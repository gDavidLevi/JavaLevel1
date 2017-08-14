package ru.davidlevy.lesson5.classification;

/**
 * Абстрактный класс: Животные
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public abstract class Animalia {
    /* Поля класса */
    protected String name;
    protected int age;
    protected String color;
    protected Boolean canCrawl;
    protected Boolean canRun;
    protected Boolean canSwim;
    protected Boolean canJump;
    protected Boolean canFly;
    protected Boolean canWalk;

    /**
     * Конструктор Animalia
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Animalia(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.canCrawl = false; // пока не умеет ползать
        this.canRun = false; // пока не умеет бежать
        this.canSwim = false; // пока не умеет плыть
        this.canJump = false; // пока не умеет прыгать
        this.canFly = false; // пока не умеет летать
        this.canWalk = false; // пока не умеет ходить
    }

    public abstract String getName();

    public abstract int getAge();

    public abstract String getColor();

    public abstract Boolean isCanCrawl();

    public abstract Boolean isCanRun();

    public abstract Boolean isCanSwim();

    public abstract Boolean isCanJump();

    public abstract Boolean isCanFly();

    public abstract Boolean isCanWalk();
}
