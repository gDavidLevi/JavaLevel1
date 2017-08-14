package ru.davidlevy.lesson4;

/**
 * Created on 02.02.2017
 */
public class Cat {
    /* Поля класса Cat */
    private String name;
    private int age;
    private String color;

    /* static. Всем котам (все копии Cat имеют доступ к одной переменной) раздать 4 лапы */
    private static int paws = 4; //

    /* Конструктор по умолчанию */
    Cat() {
        this.name = "";
        this.age = 0;
        this.color = "";
    }

    /**
     * Перегруженный конструктор
     *
     * @param name  String
     * @param age   int
     * @param color String
     */
    Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * Перегруженный конструктор
     *
     * @param obj Cat
     */
    Cat(Cat obj) {
        this.name = obj.name;
        this.age = obj.age;
        this.color = obj.color;
    }

    /**
     * Получить имя
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Прыгнуть!
     */
    public void jump() {
        System.out.println(this.name + " прыгнул.");
    }
}