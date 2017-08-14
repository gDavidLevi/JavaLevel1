package ru.davidlevy.lesson5.teacher;

abstract class Animal {
    String animalType;
    boolean canSwim;
    int swimSpeed;
    int runSpeed;
    int jumpHeight;

    /**
     * @param canSwim    boolean
     * @param runSpeed   int
     * @param jumpHeight int
     */
    Animal(boolean canSwim, int runSpeed, int jumpHeight) {
        this.canSwim = canSwim;
        this.runSpeed = runSpeed;
        this.jumpHeight = jumpHeight;
    }

    /**
     * @param canSwim    boolean
     * @param swimSpeed  int
     * @param runSpeed   int
     * @param jumpHeight int
     */
    Animal(boolean canSwim, int swimSpeed, int runSpeed, int jumpHeight) {
        this.canSwim = canSwim;
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.jumpHeight = jumpHeight;
    }

    /**
     * @param distance int
     * @return float
     */
    float run(int distance) {
        return distance / this.runSpeed;
    }

    /**
     * @param height int
     * @return boolean
     */
    boolean jump(int height) {
        return height < this.jumpHeight;
    }

    /**
     * @param distance int
     * @return float
     */
    float swim(int distance) {
        return (this.canSwim) ? distance / this.swimSpeed : 65535;
    }

    /**
     * @return String
     */
    String getType() {
        return this.animalType;
    }
}