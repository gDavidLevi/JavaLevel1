package ru.davidlevy.lesson8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Окно настроек
 *
 * @author David A. Lévy
 * @version 2.00 18.02.2017
 */
public class SettingsFrame extends JFrame {
    /* Ссылка на главный контекст */
    private MainWindow mainWindow;

    /* Константы */
    private static final String TITLE = "Новая игра";
    private static final int MIN_WIN_LENGHT = 4;
    private static final int MIN_FIELD_SIZE = 5;
    private static final int MAX_FIELD_SIZE = 9;
    private static final int fieldPlaySize = 500;

    /* Виджеты */
    private JRadioButton jrbHumVsAI;
    private JRadioButton jrbHumVsHum;
    private JSlider jsliderFieldSize;
    private JSlider jsliderWinLenght;

    /**
     * Конструктор принимает ссылку на контекст его вызвавший
     *
     * @param mainWindow MainWindow
     */
    public SettingsFrame(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        /* Параметры окна */
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(8, 1));

        /* Настройка виджетов и добавление их на панель */
        JLabel label = new JLabel("Выбери режим игры:");
        add(label);
        jrbHumVsAI = new JRadioButton("Человек против машины");
        jrbHumVsAI.setSelected(true);
        add(jrbHumVsAI);
        jrbHumVsHum = new JRadioButton("Человек против человека");
        add(jrbHumVsHum);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jrbHumVsAI);
        buttonGroup.add(jrbHumVsHum);
        JLabel lblWinLwn = new JLabel("Выигрышная длина: " + MIN_WIN_LENGHT);
        add(lblWinLwn);
        jsliderWinLenght = new JSlider(MIN_WIN_LENGHT, MIN_FIELD_SIZE, MIN_WIN_LENGHT);
        add(jsliderWinLenght);
        JLabel lblFieldSize = new JLabel("Размер поля: " + MIN_FIELD_SIZE);
        add(lblFieldSize);
        jsliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(jsliderFieldSize);
        JButton btnStart = new JButton("Старт");
        add(btnStart);

        /* Слушатель слайдера "Длина выигрышной длины" */
        jsliderWinLenght.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLwn.setText("Минимальная выигрышная длина: " + jsliderWinLenght.getValue());
            }
        });

        /* Слушатель слайдера "Размер игравого поля" */
        jsliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = jsliderFieldSize.getValue();
                lblFieldSize.setText("Размер поля: " + currentFieldSize);
                jsliderWinLenght.setMaximum(currentFieldSize);
            }
        });

        /* Слушатель кнопки "Старт" */
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonPressed();
            }
        });
    }

    /**
     * Обработчик нажатия на кнопку "Старт"
     */
    private void startButtonPressed() {
        int mode = 0;
        if (jrbHumVsAI.isSelected()) {
            mode = GamePanel.GAME_MODE_H_V_A;
        }
        if (jrbHumVsHum.isSelected()) {
            mode = GamePanel.GAME_MODE_H_V_H;
        }

        /* Закрыть окно настроек */
        setVisible(false);

        /* Запуск игры */
        mainWindow.start(mode, jsliderFieldSize.getValue(), jsliderWinLenght.getValue(), fieldPlaySize);
    }
}