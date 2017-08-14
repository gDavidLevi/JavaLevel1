package ru.davidlevy.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private static final int MATRIX_SIZE = 9;

    public MyWindow() {
        /* Параметры окна */
        setSize(507, 552);
        setResizable(false);
        setLocationRelativeTo(null);  // взамен setLocation(800, 200);
        setTitle("Simple Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        /* Параметры матрицы */
        Map1 jpMap = new Map1(MATRIX_SIZE);
        add(jpMap, BorderLayout.CENTER);

        /* Панель для кнопок */
        JPanel bottomPanel = new JPanel(new GridLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        /* Книпки управления */
        JButton jbStart = new JButton("Start New Game");
        JButton jbExit = new JButton("Exit Game");
        bottomPanel.add(jbStart);
        bottomPanel.add(jbExit);
        
        /* Слушатель событий кнопки Выход */
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        /* Показать окно */
        setVisible(true);
    }
}