package ru.davidlevy.lesson7.hw.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Главное окно программы *
 *
 * @author David A. Lévy
 * @version 1.00 14.02.2017
 */
public class MainWindow extends JFrame {
    private static final String TITLE = "Крестики-нолики";
    private static GamePanel gamePanel;
    private static CreateNewGame createNewGame;

    public MainWindow() {
        /* Параметры окна */
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        /* Панель для кнопок*/
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        add(panel, BorderLayout.SOUTH);

        /* Кнопки */
        JButton btnNewGame = new JButton("Новая игра");
        JButton btnQuit = new JButton("Выход");
        panel.add(btnNewGame);
        panel.add(btnQuit);

        /* Игровя панель */
        gamePanel = new GamePanel();
        add(gamePanel);

        /* Для передачи контекста */
        createNewGame = new CreateNewGame(this);

        /* Слушатель событий книпки "Новая игра" */
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewGame.setVisible(true);
            }
        });

        /* Слушатель событий книпки "Выход" */
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // действие: ВЫХОД ИЗ ПРОГРАММЫ
                System.exit(0);
            }
        });

        /* Показать окно*/
        setVisible(true);
    }

    /**
     * Запуск игры
     *
     * @param mode       int
     * @param fieldSizeX int
     * @param fieldSizeY int
     * @param winLength  int
     */
    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gamePanel.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}