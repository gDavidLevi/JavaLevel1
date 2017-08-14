package ru.davidlevy.lesson7.hw;

import ru.davidlevy.lesson7.hw.homework.MainWindow;

import javax.swing.*;

/**
 * В данной программе изучаем Swing *
 * Ключивые слова: javax.swing.*,
 * javax.swing.event.ChangeListener - для JRadioButton и др. чекеров
 * java.awt.event.ActionListener - для JButton и др. кнопкоподобных объектов
 * JFrame - окно/фрэйм
 * JButton - кнопки
 * JPanel - панель
 * JLabel - метка
 * GridLayout - компоновщие сеточный
 * BorderLayout - компоновщик рамочный
 * JRadioButton - радио-кнопки
 * ButtonGroup - группировка JRadioButton
 * JSlider - бегунок
 *
 * @author David A. Lévy
 * @version 1.00 13.02.2017
 */
public class HomeWork7 {
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