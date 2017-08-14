package ru.davidlevy.lesson5.teacher;

public class Bird extends Animal {
    /* Class fields */
    public static int a = 0;
    private int flySpeed;

    /**
     * @param canSwim    boolean
     * @param runSpeed   int
     * @param jumpHeight int
     */
    Bird(boolean canSwim, int runSpeed, int jumpHeight) {
        super(canSwim, runSpeed, jumpHeight);
        this.animalType = "Bird";
        this.flySpeed = runSpeed * 20;
    }

    /**
     * @param distance int
     * @return float
     */
    @Override
    float swim(int distance) {
        return distance / this.flySpeed;
    }

    /**
     * @param height int
     * @return boolean
     */
    @Override
    boolean jump(int height) {
        return true;
    }
}