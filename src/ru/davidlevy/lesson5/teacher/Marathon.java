package ru.davidlevy.lesson5.teacher;

/**
 * Марафон
 */
public class Marathon {
    /**
     * @param animals  Animal[]
     * @param distance int
     * @return String
     */
    private static String track(Animal[] animals, int distance) {
        float result = 0.0f;
        String winner = "";
        for (int i = 0, q = animals.length; i < q; i++) {
            if (i == 0) {
                winner = animals[i].getType();
                result = animals[i].run(distance);
            } else if (animals[i].run(distance) < result) {
                winner = animals[i].getType();
                result = animals[i].run(distance);
            }
            System.out.println(animals[i].getType() + " бежит по времени: " + (animals[i].run(distance)));
        }
        return winner;
    }

    /**
     * @param animal Animal
     * @param height int
     * @return boolean
     */
    private static boolean barrier(Animal animal, int height) {
        if (animal.jumpHeight < height && animal.jump(height))
            System.out.println(animal.getType() + " мошенничает!");
        return animal.jump(height);
    }

    /**
     * @param animals  Animal[]
     * @param distance int
     * @return String
     */
    private static String pool(Animal[] animals, int distance) {
        float result = 0.0f;
        String winner = "";
        for (int i = 0, q = animals.length; i < q; i++) {
            float time = animals[i].swim(distance);
            if (i == 0) {
                winner = animals[i].getType();
                result = time;
            } else if (time < result) {
                winner = animals[i].getType();
                result = time;
            }
            if (!animals[i].canSwim && time < 65535)
                System.out.println(animals[i].getType() + " мошенничает! Как-то достиг цели за время = " + time);
            else if (time == 65535)
                System.out.println(animals[i].getType() + " не умеет влавать...");
            else
                System.out.println(animals[i].getType() + " плавает за время = " + time);
        }
        return winner;
    }

    /* Point of entry */
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat(false, 14, 13),
                new Dog(true, 5, 16, 9),
                new Horse(true, 2, 30, 7),
                new Bird(false, 3, 1)
        };

        System.out.println(track(animals, 10000) + " побеждает в соревнованиях!");
        System.out.println(pool(animals, 500) + " побеждает в соревнованиях по плаванию!");

        for (int i = 0, q = animals.length; i < q; i++) {
            if (barrier(animals[i], 10))
                System.out.println("Хороший прыжок, " + animals[i].getType());
            else
                System.out.println(animals[i].getType() + " Не смог...");
        }
    }
}