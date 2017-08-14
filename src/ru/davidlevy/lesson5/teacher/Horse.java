package ru.davidlevy.lesson5.teacher;

public class Horse extends Animal {
    /**
     * @param canSwim    boolean
     * @param swimSpeed  int
     * @param runSpeed   int
     * @param jumpHeight int
     */
    Horse(boolean canSwim, int swimSpeed, int runSpeed, int jumpHeight) {
        super(canSwim, swimSpeed, runSpeed, jumpHeight);
        this.animalType = "Horse";
    }
}