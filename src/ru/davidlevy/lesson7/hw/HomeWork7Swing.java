package ru.davidlevy.lesson7.hw;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Изучаем Swing-компоненты *
 *
 * @author David A. Lévy
 * @version 1.00 13.02.2017
 */
public class HomeWork7Swing {
    /* Точка входа */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UsingSwingComponents::new);
    }
}

class UsingSwingComponents {
    UsingSwingComponents() {
        JFrame frGeneral = new JFrame();
        frGeneral.setTitle("Компоненты Swing");
        frGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //
        JMenuBar menuBar = new JMenuBar();
        //
        JMenu mMenu = new JMenu("Меню");
        menuBar.add(mMenu);
        JMenu menuQuit = new JMenu("Выход");
        menuBar.add(menuQuit);
        //
        JMenuItem mMenuItmFirst = new JMenuItem("Первый");
        mMenuItmFirst.setIcon(new ImageIcon("src/ru/davidlevy/lesson7/images/sun.png"));
        mMenu.add(mMenuItmFirst);
        JMenuItem mMenuItmSecond = new JMenuItem("Второй");
        mMenuItmSecond.setIcon(new ImageIcon("src/ru/davidlevy/lesson7/images/phone.png"));
        mMenu.add(mMenuItmSecond);
        mMenu.addSeparator();
        JMenuItem mMenuItmThird = new JMenuItem("Третий");
        mMenuItmThird.setIcon(new ImageIcon("src/ru/davidlevy/lesson7/images/lamp.png"));
        mMenu.add(mMenuItmThird);
        mMenu.addSeparator();
        //
        ButtonGroup btnGroup = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("Кнопка 1");
        radioButton1.setSelected(true);
        JRadioButton radioButton2 = new JRadioButton("Кнопка 2");
        btnGroup.add(radioButton1);
        btnGroup.add(radioButton2);
        mMenu.add(radioButton1);
        mMenu.add(radioButton2);
        mMenu.addSeparator();
        //
        JCheckBoxMenuItem checkBoxMenuItem1 = new JCheckBoxMenuItem("checkBoxMenuItem1");
        mMenu.add(checkBoxMenuItem1);
        JCheckBoxMenuItem checkBoxMenuItem2 = new JCheckBoxMenuItem("checkBoxMenuItem2");
        mMenu.add(checkBoxMenuItem2);
        mMenu.addSeparator();
        //
        JMenuItem subMenu = new JMenu("Подменю");
        subMenu.setIcon(new ImageIcon("src/ru/davidlevy/lesson7/images/lamp.png"));
        JMenuItem subMenuItmFirst = new JMenuItem("подПервый");
        subMenuItmFirst.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
        subMenu.add(subMenuItmFirst);
        JMenuItem subMenuItmSecond = new JMenuItem("подВторой");
        subMenu.add(subMenuItmSecond);
        mMenu.add(subMenu);
        //
        frGeneral.add(menuBar, BorderLayout.NORTH);
        //
        JTabbedPane tabbedPane = new JTabbedPane();
        //
        JPanel p1 = new JPanel();
        tabbedPane.addTab("Панель 1", p1);
        JButton btnButton1 = new JButton("Кнопка на панели");
        btnButton1.setIcon(new ImageIcon("src/ru.davidlevy.lesson7/images/cloud.png"));
        p1.add(btnButton1);
        //
        JPanel p2 = new JPanel();
        tabbedPane.add("Панель 2", p2);
        JLabel lblPicture = new JLabel();
        lblPicture.setIcon(new ImageIcon("src/ru.davidlevy.lesson7/images/view.gif"));
        p2.add(lblPicture);
        //
        JPanel p3 = new JPanel();
        tabbedPane.add("Панель 3", p3);
        //
        JPanel pnlBorder = new JPanel();
        Border solidLine = BorderFactory.createLineBorder(Color.GRAY);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(solidLine, "Заголовок", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        JLabel textInBorder = new JLabel("Текст текст текст текст текст текст текст текст какой-то текст");
        pnlBorder.add(textInBorder);
        pnlBorder.setBorder(titledBorder);
        p3.add(pnlBorder);
        //
        frGeneral.add(tabbedPane);
        //
        frGeneral.setSize(600, 650);
        frGeneral.setLocationRelativeTo(null);
        frGeneral.setVisible(true);
        //
        menuQuit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("нажата menuQuit");
                System.exit(0);
            }
        });
    }
}