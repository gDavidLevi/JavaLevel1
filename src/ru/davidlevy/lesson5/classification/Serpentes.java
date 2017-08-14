package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Змееобразные
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Serpentes extends Squamata {
    private Boolean poisonous;
    private Boolean livesInSerpentarium;

    /**
     * Конструктор Serpentes
     *
     * @param name      String имя
     * @param age       int возраст
     * @param color     String цвет
     * @param poisonous Boolean ядовитая?
     */
    public Serpentes(String name, int age, String color, Boolean poisonous, Boolean livesInSerpentarium) {
        super(name, age, color);
        super.setCanCrawl(true); // Да будут ползать!
        super.setCanSwim(true); // Да будут плавать!
        this.poisonous = poisonous;
        this.livesInSerpentarium = livesInSerpentarium;
    }

    public Boolean isPoisonous() {
        return this.poisonous;
    }

    public Boolean isLivesInSerpentarium() {
        return this.livesInSerpentarium;
    }

    protected void setLivesInSerpentarium(Boolean can) {
        this.livesInSerpentarium = can;
    }
}