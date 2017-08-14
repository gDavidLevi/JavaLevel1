package ru.davidlevy.lesson5.teacher;

public class Dog extends Animal {
    /**
     * @param canSwim    boolean
     * @param swimSpeed  int
     * @param runSpeed   int
     * @param jumpHeight int
     */
    Dog(boolean canSwim, int swimSpeed, int runSpeed, int jumpHeight) {
        super(canSwim, swimSpeed, runSpeed, jumpHeight);
        this.animalType = "Dog";
    }
}