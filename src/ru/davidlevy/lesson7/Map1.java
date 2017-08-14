package ru.davidlevy.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map1 extends JPanel {
    /* значки */
    private static final char EMPTY_CELL = ' ';
    private static final char CROSS_SIGN = '+';
    private static final char ZERO_SIGN = 'O';

    /* поля */
    private int panelSize = 500;
    private int padding = 5;
    private int matrixSize;
    private int cellSize;
    private char[][] field;

    /**
     * @param matrixSize int
     */
    public Map1(int matrixSize) {
        this.matrixSize = matrixSize;
        this.panelSize = this.panelSize - (this.panelSize % matrixSize); // сделаем сетку ровной
        this.cellSize = this.panelSize / this.matrixSize;
        setBackground(Color.white);

        /* создадим матрицу для хранения состояния игравого поля */
        this.field = new char[matrixSize][matrixSize];

        /* инициализируем матрицу */
        initField();

        /* Слушатель событий мыши. Отпустили кнопку мыши. */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                btnMouse_onClick(e);
            }
        });
    }

    /**
     * Обрабатываем событие клик в ячейку
     *
     * @param e MouseEvent
     */
    private void btnMouse_onClick(MouseEvent e) {
        /* живые координаты положения мыши */
        int pointerOfMouseX = e.getX();
        int pointerOfMouseY = e.getY();
        System.out.println("Координаты клика (х/у): " + pointerOfMouseX + " " + pointerOfMouseY);

        /* создадим координаты ячеек массива field[][] */
        int x = pointerOfMouseX / cellSize;
        int y = pointerOfMouseY / cellSize;
        System.out.println("Координаты по матрице (строка/колонка): " + x + " " + y);

        /* запишем координаты в массив field[][] */
        if (isCellEmpty(x, y)) {
            System.out.println("Записали в матрицу координаты символа " + CROSS_SIGN);
            setInCell(x, y, CROSS_SIGN);
        } else {
            System.out.println("Ячейка не пуста!");
        }

        /* переписовка */
        repaint();
    }

    /* заполняем поле пустыми значениями */
    private void initField() {
        for (int i = 0, qi = field.length; i < qi; i++) {
            for (int j = 0, qj = field[i].length; j < qj; j++)
                field[i][j] = EMPTY_CELL;
        }
    }

    /* установить фишку по координатам */
    private void setInCell(int x, int y, char symbol) {
        field[x][y] = symbol;
    }

    /**
     * Можно ли ставить фишку в координаты?
     *
     * @param x int
     * @param y int
     * @return boolean
     */
    private boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > this.matrixSize - 1 || y > this.matrixSize - 1)
            return false;
        return field[x][y] == EMPTY_CELL;
    }

    /**
     * Отрисовка всех графических примитивов
     *
     * @param g Graphics
     */
    private void renderAllGraphics(Graphics g) {
        /* рисуем сетку */
        for (int i = 0; i <= this.matrixSize; i++) {
            g.setColor(Color.BLACK);
            g.drawLine(0, i * this.cellSize, this.panelSize, i * this.cellSize);
            g.drawLine(i * this.cellSize, 0, i * this.cellSize, this.panelSize);
        }

        /* рисуем фишки, если таковы есть в массиве field[][] */
        for (int y = 0, qy = field.length; y < qy; y++) {
            for (int x = 0, qx = field[y].length; x < qx; x++) {
                if (field[x][y] == CROSS_SIGN) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * this.cellSize + padding, y * this.cellSize + padding, cellSize - 2 * padding, cellSize - 2 * padding);
                } else if (field[x][y] == ZERO_SIGN) {
                    g.setColor(Color.RED);
                    g.fillOval(x * this.cellSize + padding, y * this.cellSize + padding, cellSize - 2 * padding, cellSize - 2 * padding);
                }
            }
        }

        /* переписовка */
        repaint();
    }

    /**
     * Сообщение "Игра завершена"
     *
     * @param g Graphics
     */
    void showGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Roboto", 3, 48));
        g.drawString("Игра завершена", 100, 100);
        repaint();
    }

    /**
     * Вызывается всегда, когда происходят изменения
     *
     * @param g Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderAllGraphics(g);
    }
}
