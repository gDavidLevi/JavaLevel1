package ru.davidlevy.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Главное окно
 *
 * @author David A. Lévy
 * @version 2.00 18.02.2017
 */
public class MainWindow extends JFrame {
    private static final String TITLE = "Крестики-нолики";
    private static GamePanel gamePanel;
    private static SettingsFrame settingsFrame;

    public MainWindow() {
        /* Параметры окна */
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(507, 552);
        setLocationRelativeTo(null);
        setResizable(false);

        /* Игровая панель */
        gamePanel = new GamePanel();
        add(gamePanel);

        /* Нижняя панель управления */
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new GridLayout(1, 2));

        /* Кнопки на нижней панели */
        JButton btnNewGame = new JButton("Новая игра");
        buttomPanel.add(btnNewGame);
        JButton btnQuit = new JButton("Выход");
        buttomPanel.add(btnQuit);
        add(buttomPanel, BorderLayout.SOUTH);

        /* Подключаем окно настроек */
        settingsFrame = new SettingsFrame(this);

        /* Слушатель кнопки "Новая игра" */
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.setVisible(true);
            }
        });

        /* Слушатель кнопки "Выход" */
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /* Показать окно */
        setVisible(true);
    }

    /* Запуск игры */
    public void start(int mode, int fieldSize, int winLength, int fieldPlaySize) {
        /* Передача параметров для игры */
        gamePanel.runGame(mode, fieldSize, winLength, fieldPlaySize);
    }
}