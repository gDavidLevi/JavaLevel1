package ru.davidlevy.lesson5;

import ru.davidlevy.lesson5.classification.*;

/**
 * Ключивые слова: extends, abstract class, final class, super(), super.*, @Override (переопределение), полиморфизм, (объект)instanceOf(типа)
 *
 * @author David A. Lévy
 * @version 1.02 08.02.2017
 */
public class HomeWork5 {
    /**
     * Вернуть в консоль имена всех Carnivores
     *
     * @param array Chordata[]
     */
    private static void showNamesAllCarnivores(Chordata[] array) {
        System.out.print("- плотоядные: ");
        for (Chordata chordata : array) {
            if (chordata instanceof Carnivora)
                System.out.print(chordata.getName() + "(" + chordata.getClass().getSimpleName() + "), ");
        }
        System.out.println();
    }

    /**
     * Вернуть в консоль имена всех Mammals и Ornithurae
     *
     * @param array Chordata[]
     */
    private static void showNamesAllMammalsAndOrnithurae(Chordata[] array) {
        System.out.print("- млекопитающие и веерохвостные: ");
        for (Chordata chordata : array) {
            if ((chordata instanceof Mammalia) || (chordata instanceof Ornithurae))
                System.out.print(chordata.getName() + "(" + chordata.getClass().getSimpleName() + "), ");
        }
        System.out.println();
    }

    /**
     * Вернуть в консоль имена всех Felis
     *
     * @param array Chordata[]
     */
    private static void showNamesAllFelis(Chordata[] array) {
        System.out.print("- кошачьи: ");
        for (Chordata chordata : array) {
            if (chordata instanceof Felis)
                System.out.print(chordata.getName() + "(" + chordata.getClass().getSimpleName() + "), ");
        }
        System.out.println();
    }

    /**
     * Показать всех Animalia
     *
     * @param array Chordata[]
     */
    private static void showNamesAllAnimalia(Chordata[] array) {
        System.out.print("- все зверушки: ");
        for (Chordata chordata : array) {
            System.out.print(chordata.getName() + "(" + chordata.getClass().getSimpleName() + "), ");
        }
        System.out.println();
    }

    /**
     * Показать основные свойства
     *
     * @param array Chordata[]
     */
    private static void showGeneralProperties(Chordata[] array) {
        System.out.println("Общие свойства:");
        for (Chordata chordata : array) {
            System.out.println("\nТип: " + chordata.getClass().getSimpleName() + "➤" + chordata.getClass().getSuperclass().getSimpleName());
            System.out.println(" Имя: " + chordata.getName());
            System.out.println(" Возраст: " + chordata.getAge());
            System.out.println(" Цвет: " + chordata.getColor());
            System.out.println(" Может ползать: " + chordata.isCanCrawl());
            System.out.println(" Может бегать: " + chordata.isCanRun());
            System.out.println(" Может плавать: " + chordata.isCanSwim());
            System.out.println(" Может прыгать: " + chordata.isCanJump());
            System.out.println(" Может летать: " + chordata.isCanFly());
            System.out.println(" Может ходить: " + chordata.isCanWalk());
        }
        System.out.println();
    }

    /* Точка входа */
    public static void main(String[] args) {
        /* Создадим объекты (конкретных животных) */
        Snake aSnake = new Snake("Kaa", 10, "коричневый в полоску", false, true);
        Cat aCat = new Cat("Иосеф", 2, "полосатый");
        Cat aCat1 = new Cat("Мурзик", 4, "рыжий");
        Tiger aTiger = new Tiger("Мерлин", 1, "белый");
        Dog aDog = new Dog("Бим", 2, "черный", false);
        Horse aHorse = new Horse("Агат", 5, "рыжий", false, true);
        Horse aHorse1 = new Horse("Тиберия", 7, "черный", true, true);
        Parrot aParrot = new Parrot("Рио", 10, "разноцветный", true, true);

        /* Создадим наш зоопарк */
        Chordata[] myZoo = {aSnake, aCat, aCat1, aTiger, aDog, aHorse, aHorse1, aParrot};

        /* О зоопарке */
        System.out.println("\nВ моём зоопарке:");
        showNamesAllCarnivores(myZoo); // показать имена всех плотоядных
        showNamesAllMammalsAndOrnithurae(myZoo); // показать имена всех млекопитающих и веерохвостых
        showNamesAllFelis(myZoo); // показать имена всех кошачьих
        showNamesAllAnimalia(myZoo); // показать всех животных

        /* Покажем общие свойства животных в зоопарке */
        System.out.println("______________________________________________________________________________________________");
        showGeneralProperties(myZoo);

        /* Также у типов есть свои личные свойства */
        System.out.println("______________________________________________________________________________________________");
        System.out.println("\nУ типа Snake есть наследуемые личные свойства:");
        System.out.println(" Имеет позвоночник: " + aSnake.isAxialSkeleton());
        System.out.println(" Имеет чешуйки: " + aSnake.isHasScales());
        System.out.println(" Холоднокровое: " + aSnake.isColdBlooded());
        System.out.println(" Ядовитая: " + aSnake.isPoisonous());
        System.out.println(" Живет вневоле: " + aSnake.isLivesInSerpentarium());
        System.out.println("\nУ типа Cat есть наследуемые личные свойства:");
        System.out.println(" Плотоядный: " + aCat.isEatTheFlesh());
        System.out.println(" Имеет позвоночник: " + aCat.isAxialSkeleton());
        System.out.println(" Вскормлен молоком: " + aCat.isFedOnMilks());
        System.out.println(" Может мурчать: " + aCat.isCanHum());
        System.out.println("\nУ типа Tiger есть наследуемые личные свойства:");
        System.out.println(" Плотоядный: " + aTiger.isEatTheFlesh());
        System.out.println(" Имеет позвоночник: " + aTiger.isAxialSkeleton());
        System.out.println(" Вскормлен молоком: " + aTiger.isFedOnMilks());
        System.out.println(" Может мурчать: " + aCat.isCanHum());
        System.out.println("\nУ типа Dog есть наследуемые личные свойства:");
        System.out.println(" Плотоядный: " + aDog.isEatTheFlesh());
        System.out.println(" Имеет позвоночник: " + aDog.isAxialSkeleton());
        System.out.println(" Вскормлен молоком: " + aDog.isFedOnMilks());
        System.out.println(" Поддается тренировке: " + aDog.isPossibleTraining());
        System.out.println("\nУ типа Horse есть наследуемые личные свойства:");
        System.out.println(" Имеет позвоночник: " + aHorse.isAxialSkeleton());
        System.out.println(" Вскормлен молоком: " + aHorse.isFedOnMilks());
        System.out.println(" Дикая?: " + aHorse.isSavagery());
        System.out.println(" Имеет нечётное число пальцев, образующих копыта?: " + aHorse.isHasOddToedUngulates());
        System.out.println("\nУ типа Parrot есть наследуемые личные свойства:");
        System.out.println(" Имеет позвоночник: " + aParrot.isAxialSkeleton());
        System.out.println(" Откладывает яйца: " + aParrot.isLaysEggs());
        System.out.println(" Имеет перья: " + aParrot.isHasFeathers());
        System.out.println(" Имеет крылья: " + aParrot.isHasWings());
        System.out.println(" Может говорить: " + aParrot.isCanSpeak());

        /* Методы */
        System.out.println("______________________________________________________________________________________________");
        System.out.println(" Собака может прыгнуть максимум на 3,5 метра? - " + aDog.isCanJump(3.5));
        System.out.println(" Кот может прыгнуть максимум на 3,5 метра? - " + aCat.isCanJump(3.5));
    }
}