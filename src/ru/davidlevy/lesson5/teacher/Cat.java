package ru.davidlevy.lesson5.teacher;

public class Cat extends Animal {
    /**
     * @param canSwim    boolean
     * @param runSpeed   int
     * @param jumpHeight int
     */
    Cat(boolean canSwim, int runSpeed, int jumpHeight) {
        super(canSwim, runSpeed, jumpHeight);
        this.animalType = "Cat";
    }
}