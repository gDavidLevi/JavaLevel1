package ru.davidlevy.lesson7.hw.homework;

import javax.swing.*;
import java.awt.*;

/**
 * Игровое поле *
 * @author David A. Lévy
 * @version 1.00 14.02.2017
 */
public class GamePanel extends JPanel {
    static final int GAME_MODE_H_V_A = 0;
    static final int GAME_MODE_H_V_H = 1;

    public GamePanel() {
        setBackground(Color.PINK);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("режим %d %d %d %d \n", mode, fieldSizeX, fieldSizeY, winLength);
    }
}