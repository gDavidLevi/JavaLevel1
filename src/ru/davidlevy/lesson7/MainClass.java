package ru.davidlevy.lesson7;

import javax.swing.*;

public class MainClass {
    /* Точка входа */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });
    }
}