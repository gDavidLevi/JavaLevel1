package ru.davidlevy.lesson7.hw.homework;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Окно с настройками для игры *
 *
 * @author David A. Lévy
 * @version 1.00 14.02.2017
 */
public class CreateNewGame extends JFrame {
    /* Педеча контекста */
    private MainWindow mainWindow;

    /* Константы */
    private static final String TITLE = "Новая игра";
    private static final int MIN_WIN_LENGHT = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    /* Виджеты */
    private JRadioButton jrbHumVsAI;
    private JRadioButton jrbHumVsHum;
    private JSlider jsliderFieldSize;
    private JSlider jsliderWinLenght;

    /**
     * Конструктор инициируется контекстом класса MainWindow
     *
     * @param mainWindow MainWindow
     */
    CreateNewGame(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        /* Параметры окна */
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(230, 230);
        setLocationRelativeTo(null);
        setResizable(false);

        /* Слой на базе сетки для виджетов */
        setLayout(new GridLayout(8, 1));

        /* Виджеты */
        JLabel label = new JLabel("Выбери режим игры:");
        add(label);
        jrbHumVsAI = new JRadioButton("Человек против машины");
        jrbHumVsAI.setSelected(false);
        add(jrbHumVsAI);
        jrbHumVsHum = new JRadioButton("Человек против человека");
        jrbHumVsHum.setSelected(true);
        add(jrbHumVsHum);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jrbHumVsAI);
        buttonGroup.add(jrbHumVsHum);
        JLabel lblWinLwn = new JLabel("Минимальная выигрышная длина: " + MIN_WIN_LENGHT);
        add(lblWinLwn);
        jsliderWinLenght = new JSlider(MIN_WIN_LENGHT, MIN_FIELD_SIZE, MIN_WIN_LENGHT); // начало, максимум, положение
        add(jsliderWinLenght);
        JLabel lblFieldSize = new JLabel("Размер поля: " + MIN_FIELD_SIZE);
        add(lblFieldSize);
        jsliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(jsliderFieldSize);
        JButton btnStart = new JButton("Старт");
        add(btnStart);

        /* Слушатель лайдера "Выигрышная длинна" */
        jsliderWinLenght.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLwn.setText("*Минимальная выигрышная длина: " + jsliderWinLenght.getValue());
            }
        });

        /* Слушатель лайдера "Размер поля" */
        jsliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //
                int currentFieldSize = jsliderFieldSize.getValue();
                lblFieldSize.setText("*Размер поля: " + currentFieldSize);
                jsliderWinLenght.setMaximum(currentFieldSize);
            }
        });

        /* Слушатель кнопки "Запуск" */
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart_onClick();
            }
        });
    }

    /**
     * Обработчик клика на кнопку
     */
    private void btnStart_onClick() {
        int mode = 0;
        if (jrbHumVsAI.isSelected()) {
            mode = GamePanel.GAME_MODE_H_V_A;
        }
        if (jrbHumVsHum.isSelected()) {
            mode = GamePanel.GAME_MODE_H_V_H;
        }

        /* Запуск игры */
        mainWindow.startNewGame(mode, jsliderFieldSize.getValue(), jsliderFieldSize.getValue(), jsliderWinLenght.getValue());

        /* Закрыть данное окно */
        setVisible(false);
    }
}