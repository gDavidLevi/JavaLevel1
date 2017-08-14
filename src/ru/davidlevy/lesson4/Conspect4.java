package ru.davidlevy.lesson4;

/**
 * Created on 02.02.2017
 */
public class Conspect4 {
    public static void main(String[] args) {
        Cat exemplar1 = new Cat("Iosef", 2, "striped");
        Cat exemplar2 = new Cat();

        /* копировать ссылку на объект exemplar1, а не клонирование */
        Cat clone = exemplar1;

        /* тут клонируем объект */
        Cat clone1 = new Cat(exemplar1);
    }
}