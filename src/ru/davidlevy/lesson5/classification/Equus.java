package ru.davidlevy.lesson5.classification;

/**
 * Класс:  Лошади
 *
 * @author David A. Levy
 * @version 1.00 06.02.2017
 */
public class Equus extends Perissodactyla {
    private Boolean wilderness;
    private Boolean canNeighs; // ржот

    /**
     * Конструктор Equus
     *
     * @param name       String имя
     * @param age        int возраст
     * @param color      String цвет
     * @param wilderness Boolean дикое животное?
     * @param canNeighs  Boolean может ржать?
     */
    public Equus(String name, int age, String color, Boolean wilderness, Boolean canNeighs) {
        super(name, age, color);
        this.wilderness = wilderness;
        this.canNeighs = canNeighs;
    }

    public Boolean isSavagery() {
        return this.wilderness;
    }

    protected void setSavagery(Boolean wilderness) {
        this.wilderness = wilderness;
    }

    public Boolean isCanNeighs() {
        return this.canNeighs;
    }

    protected void setCanNeighs(Boolean canNeighs) {
        this.canNeighs = canNeighs;
    }
}