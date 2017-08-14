package ru.davidlevy.lesson8;

import javax.swing.*;

/**
 * Игра TicTacToe
 *
 * @author David A. Lévy
 * @version 2.00 18.02.2017
 */
public class TicTacToe {
    /* Точка входа */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}