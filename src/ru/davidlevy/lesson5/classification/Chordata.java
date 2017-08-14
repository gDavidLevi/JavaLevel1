package ru.davidlevy.lesson5.classification;

/**
 * Класс: Хордовые
 * Тип: корневой класс
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Chordata extends Animalia {
    /* Имеют скелет */
    private Boolean axialSkeleton;

    /**
     * Конструктор Chordata
     *
     * @param name  String имя
     * @param age   int возраст
     * @param color String цвет
     */
    public Chordata(String name, int age, String color) {
        super(name, age, color);
        super.canCrawl = false; // пока не ползает
        super.canRun = false; // пока не бегает
        super.canSwim = false; // пока не плавает
        super.canJump = false; // пока не прыгает
        super.canFly = false; // пока не летает
        super.canWalk = false; // пока не ходят
        this.axialSkeleton = true; // у всех хордовых есть осевой скелет
    }

    public Boolean isAxialSkeleton() {
        return axialSkeleton;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public int getAge() {
        return super.age;
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public Boolean isCanCrawl() {
        return super.canCrawl;
    }

    protected void setCanCrawl(Boolean can) {
        super.canCrawl = can;
    }

    @Override
    public Boolean isCanRun() {
        return super.canRun;
    }

    protected void setCanRun(Boolean can) {
        super.canRun = can;
    }

    @Override
    public Boolean isCanSwim() {
        return super.canSwim;
    }

    protected void setCanSwim(Boolean can) {
        super.canSwim = can;
    }

    @Override
    public Boolean isCanJump() {
        return super.canJump;
    }

    protected void setCanJump(Boolean can) {
        super.canJump = can;
    }

    @Override
    public Boolean isCanFly() {
        return super.canFly;
    }

    protected void setCanFly(Boolean can) {
        super.canFly = can;
    }

    @Override
    public Boolean isCanWalk() {
        return super.canWalk;
    }

    protected void setCanWalk(Boolean can) {
        super.canWalk = can;
    }
}