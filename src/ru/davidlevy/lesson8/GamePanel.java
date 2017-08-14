package ru.davidlevy.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Игровая панель
 *
 * @author David A. Lévy
 * @version 2.00 18.02.2017
 */
public class GamePanel extends JPanel {
    /* Режимы игры */
    static final int GAME_MODE_H_V_A = 0;
    static final int GAME_MODE_H_V_H = 1;

    /* Константы */
    private static final Random RANDOM = new Random();
    private static final char EMPTY_CELL = ' ';
    private static final char CROSS_SIGN = '+';
    private static final char ZERO_SIGN = 'O';
    private static final String USER_WIN = " Пользователь выиграл!";
    private static final String USER2_WIN = "  Второй игрок выиграл!";
    private static final String PC_WIN = "  Компьютер выиграл!";
    private static final String DRAW = "                НИЧЬЯ!";
    private static final int PADDING = 5;

    /* Поля */
    private char[][] field;
    private int matrixSize;
    private int panelSize;
    private int cellPanelSize;
    private int winLength;
    private int ColNextX = 0;
    private int ColNextY = 0;
    private int RowNextX = 0;
    private int RowNextY = 0;
    private int StraightDiagonalNextX = 0;
    private int StraightDiagonalNextY = 0;
    private int ReverseDiagonalNextX = 0;
    private int ReverseDiagonalNextY = 0;
    private boolean isTheEnd;
    private boolean isCanDraw;
    private boolean isUserFirstTurn;
    private int modeGame;
    private String winnerName;

    public GamePanel() {
        /* Настройки игры */
        setBackground(Color.WHITE);
        this.isCanDraw = false;
        this.isTheEnd = false;

        /* Перехватчик события нажатия кнопки мыши на игровой панели */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent eMouse) {
                super.mousePressed(eMouse);
                /* Игра закончена! */
                if (isTheEnd)
                    return;

                /* Можно рисовать. Обработать события от мыши. */
                if (isCanDraw)
                    onMousePressed(eMouse);
            }
        });
    }

    /**
     * Запуск игры
     *
     * @param mode          режим
     * @param fieldSize     размер поля
     * @param winLength     выигрышная длинна
     * @param fieldPlaySize физический размер поля
     */
    public void runGame(int mode, int fieldSize, int winLength, int fieldPlaySize) {
        /* Установка параметров */
        this.winLength = winLength;
        this.matrixSize = fieldSize;
        this.panelSize = fieldPlaySize - (fieldPlaySize % fieldSize);
        this.cellPanelSize = this.panelSize / this.matrixSize;
        this.field = new char[this.matrixSize][this.matrixSize];

        /* Инициализация сетки */
        initField();

        /* Определение режима игры */
        if (mode == GAME_MODE_H_V_A) {
            this.modeGame = GAME_MODE_H_V_A;
        }
        if (mode == GAME_MODE_H_V_H) {
            this.modeGame = GAME_MODE_H_V_H;
            this.isUserFirstTurn = false;
        }

        /* Разрешить рисовать! */
        this.isTheEnd = false;
        this.isCanDraw = true;

        /* Рисовать! */
        repaint();
    }

    /* Рисовать! */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Если можно рисовать, отрисовывать примитивы */
        if (this.isCanDraw)
            paintMyComponent(g);
    }

    /**
     * Обработка событий мыши
     *
     * @param eMouse MouseEvent
     */
    private void onMousePressed(MouseEvent eMouse) {
        int x = 0, y = 0;
        try {
            /* Координаты ячейки, в которую клинкули */
            x = eMouse.getX() / this.cellPanelSize;
            y = eMouse.getY() / this.cellPanelSize;
        } catch (ArithmeticException e) {
            // Подавление вывода ArithmeticException
        }

        /* Режим игры "Человек vs. Компьютер */
        if (this.modeGame == GAME_MODE_H_V_A)
            modeHVA(x, y);

        /* Режим игры "Человек vs. Человека" */
        if (this.modeGame == GAME_MODE_H_V_H)
            modeHVH(x, y);
    }

    /**
     * Метод отрисовывает графические примитивы
     *
     * @param g Graphics
     */
    private void paintMyComponent(Graphics g) {
        /* Отрисовка сетки */
        for (int i = 0; i <= this.matrixSize; i++) {
            g.setColor(Color.BLACK);
            g.drawLine(0, i * this.cellPanelSize, this.panelSize, i * this.cellPanelSize);
            g.drawLine(i * this.cellPanelSize, 0, i * this.cellPanelSize, this.panelSize);
        }

        /* Отрисовка КРЕСТИКа и НОЛИКа */
        for (int y = 0; y < this.matrixSize; y++) {
            for (int x = 0; x < this.matrixSize; x++) {
                /* если это КРЕСТИК, то... */
                if (field[x][y] == CROSS_SIGN) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * this.cellPanelSize + PADDING, y * this.cellPanelSize + PADDING, cellPanelSize - 2 * PADDING, cellPanelSize - 2 * PADDING);
                }
                /* если это НОЛИК, то... */
                if (field[x][y] == ZERO_SIGN) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x * this.cellPanelSize + PADDING, y * this.cellPanelSize + PADDING, cellPanelSize - 2 * PADDING, cellPanelSize - 2 * PADDING);
                }
            }
        }

        /* Если игра завершена, то... */
        if (this.isTheEnd) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 210, this.panelSize, 55);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", 1, 40));
            g.drawString(this.winnerName, 0, this.panelSize / 2);
        }

        /* Перерисовать */
        repaint();
    }

    /**
     * Найти индекс элемента в массиве с максимальным значением
     *
     * @param array int[][]
     * @return int
     */
    private int indexOfMaxElemInArray(int[][] array) {
        int max = 0;
        for (int y = 0; y < this.matrixSize; y++) {
            if (array[0][max] < array[0][y])
                max = y;
        }
        return max;
    }

    /**
     * Сумма символов в колонке
     *
     * @param sign char
     * @return int
     */
    private int sumSignsInCol(char sign) {
        int[][] array = new int[3][this.matrixSize];
        int counter;
        for (int x = 0; x < this.matrixSize; x++) {
            counter = 0;
            for (int y = 0; y < this.matrixSize; y++) {
                if ((field[x][y] == sign)) {
                    ++counter;
                    if (isCellEmpty(x, y + 1)) {
                        array[1][x] = x;
                        array[2][x] = y + 1;
                    }
                }
            }
            array[0][x] = counter;
        }
        int max = indexOfMaxElemInArray(array);
        ColNextX = array[1][max];
        ColNextY = array[2][max];
        return array[0][max];
    }

    /**
     * Сумма символов в строке
     *
     * @param sing char
     * @return int
     */
    private int sumSignsInRow(char sing) {
        int[][] array = new int[3][this.matrixSize];
        int counter;
        for (int y = 0; y < this.matrixSize; y++) {
            counter = 0;
            for (int x = 0; x < this.matrixSize; x++) {
                if ((field[x][y] == sing)) {
                    ++counter;
                    if (isCellEmpty(x + 1, y)) {
                        array[1][y] = x + 1;
                        array[2][y] = y;
                    }
                }
            }
            array[0][y] = counter;
        }
        int max = indexOfMaxElemInArray(array);
        RowNextX = array[1][max];
        RowNextY = array[2][max];
        return array[0][max];
    }

    /**
     * Сумма симполов в главной диагонале
     *
     * @param sing char
     * @return int
     */
    private int sumSignsInStraightDiagonal(char sing) {
        int nextX = 0;
        int nextY = 0;
        int counter = 0;
        for (int i = 0; i < this.matrixSize; i++) {
            if (field[i][i] == sing) {
                ++counter;
                if (isCellEmpty(i + 1, i + 1)) {
                    nextX = i + 1;
                    nextY = i + 1;
                }
            }
        }
        StraightDiagonalNextX = nextX;
        StraightDiagonalNextY = nextY;
        return counter;
    }

    /**
     * Сумма символов в обратной диагонале
     *
     * @param sign char
     * @return int
     */
    private int sumSignsInReverseDiagonal(char sign) {
        int nextX = 0;
        int nextY = 0;
        int counter = 0;
        for (int i = 0; i < this.matrixSize; i++) {
            if (field[this.matrixSize - 1 - i][i] == sign) {
                ++counter;
                if (isCellEmpty(this.matrixSize - 2 - i, i + 1)) {
                    nextX = this.matrixSize - 2 - i;
                    nextY = i + 1;
                }
            }
        }
        ReverseDiagonalNextX = nextX;
        ReverseDiagonalNextY = nextY;
        return counter;
    }

    /**
     * Выиграл в колонке?
     *
     * @param sign char
     * @return boolean
     */
    private boolean isWinInCol(char sign) {
        int counter;
        for (int x = 0; x < this.matrixSize - 1; x++) {
            counter = 1;
            for (int y = 0; y < this.matrixSize - 1; y++) {
                if ((field[x][y] == sign) & (field[x][y] == field[x][y + 1])) {
                    ++counter;
                }
            }
            if (counter == this.winLength) {
                return true;
            }
        }
        return false;
    }

    /**
     * Выиграл в строке?
     *
     * @param sign char
     * @return boolean
     */
    private boolean isWinInRow(char sign) {
        int counter;
        for (int y = 0; y < this.matrixSize - 1; y++) {
            counter = 1;
            for (int x = 0; x < this.matrixSize - 1; x++) {
                if ((field[x][y] == sign) & (field[x][y] == field[x + 1][y])) {
                    ++counter;
                }
            }
            if (counter == this.winLength) {
                return true;
            }
        }
        return false;
    }

    /**
     * Выиграл в прямой диагонале?
     *
     * @param sign char
     * @return boolean
     */
    private boolean isWinInDiagonalStraight(char sign) {
        int counter = 0;
        for (int i = 0; i < this.matrixSize - 1; i++) {
            if ((field[i][i] == field[i + 1][i + 1]) & field[i][i] == sign) {
                ++counter;
            }
        }
        if (counter == this.winLength - 1) {
            return true;
        }
        return false;
    }

    /**
     * Выиграл в обратной диагонале?
     *
     * @param sign char
     * @return boolean
     */
    private boolean isWinInDiagonalReverse(char sign) {
        int counter;
        counter = 0;
        for (int i = 0; i < this.matrixSize - 1; i++) {
            if ((field[this.matrixSize - 1 - i][i] == field[this.matrixSize - i - 2][i + 1]) & field[this.matrixSize - 1 - i][i] == sign) {
                ++counter;
            }
        }
        if (counter == this.winLength - 1) {
            return true;
        }
        return false;
    }

    /**
     * Выиграл?
     *
     * @param sign char
     * @return boolean
     */
    public boolean isWin(char sign) {
        return (isWinInRow(sign) | isWinInCol(sign) | isWinInDiagonalStraight(sign) | isWinInDiagonalReverse(sign));
    }

    /**
     * Вычислить рейтинг, чтобы компьютер вычислил свой следующий ход
     *
     * @param quantitySymbols int cумма символов в колонке, строке, диагонали
     * @param raiting         int
     * @param x               int
     * @param y               int
     * @return boolean
     */
    public boolean raiting(int quantitySymbols, int raiting, int x, int y) {
        if (quantitySymbols == raiting) {
            if (isCellEmpty(x, y)) {
                setInCell(x, y, ZERO_SIGN);
            } else
                aiTurnRandom();
            return true;
        }
        return false;
    }

    /**
     * Компьютер вставляет в случайную ячейку
     */
    private void aiTurnRandom() {
        int x, y;
        do {
            x = RANDOM.nextInt(this.matrixSize);
            y = RANDOM.nextInt(this.matrixSize);
        } while (!isCellEmpty(x, y));
        setInCell(x, y, ZERO_SIGN);
    }

    /* Установить символ по координатам */
    private void setInCell(int x, int y, char symbol) {
        field[x][y] = symbol;
    }

    /**
     * Пустая ли ячейка по координамат?
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
     * Инициализация матрицы
     */
    private void initField() {
        for (int y = 0; y < this.matrixSize; y++) {
            for (int x = 0; x < this.matrixSize; x++)
                field[y][x] = EMPTY_CELL;
        }
    }

    /**
     * Заполнено ли все поле?
     *
     * @return boolean
     */
    private boolean isFieldFull() {
        for (int y = 0; y < this.matrixSize; y++) {
            for (int x = 0; x < this.matrixSize; x++) {
                if (field[x][y] == EMPTY_CELL)
                    return false;
            }
        }
        return true;
    }

    /**
     * Игрок с именем name выиграл.
     *
     * @param name String
     */
    private void win(String name) {
        this.winnerName = name;
        this.isTheEnd = true;
    }

    /**
     * Режим "Человек vs. Человека"
     *
     * @param x int
     * @param y int
     */
    private void modeHVH(int x, int y) {
        if (!isUserFirstTurn) {
            if (isCellEmpty(x, y)) {
                setInCell(x, y, CROSS_SIGN);
                if (isWin(CROSS_SIGN))
                    win(USER_WIN);
                if (isFieldFull())
                    win(DRAW);
                isUserFirstTurn = true;
            }
        } else {
            if (isCellEmpty(x, y)) {
                setInCell(x, y, ZERO_SIGN);
                if (isWin(ZERO_SIGN))
                    win(USER2_WIN);
                if (isFieldFull())
                    win(DRAW);
                isUserFirstTurn = false;
            }
        }
    }

    /**
     * Режим "Человек vs. Компьютер"
     *
     * @param x int
     * @param y int
     */
    public void modeHVA(int x, int y) {
        if (isCellEmpty(x, y)) {
            setInCell(x, y, CROSS_SIGN);
            if (isWin(CROSS_SIGN))
                win(USER_WIN);
            if (isFieldFull())
                win(DRAW);
        }

        /* Компьютер делает ход */
        aiThinks();

        if (isWin(ZERO_SIGN))
            win(PC_WIN);
        if (isFieldFull())
            win(DRAW);
    }

    /* Компьютер принимает решение */
    public void aiThinks() {
        for (int maxRaiting = 10; maxRaiting > 0; maxRaiting--) {
            if (this.isTheEnd)
                break;
            if (raiting(sumSignsInCol(CROSS_SIGN), maxRaiting, ColNextX, ColNextY))
                break;
            if (raiting(sumSignsInRow(CROSS_SIGN), maxRaiting, RowNextX, RowNextY))
                break;
            if (raiting(sumSignsInStraightDiagonal(CROSS_SIGN), maxRaiting, StraightDiagonalNextX, StraightDiagonalNextY))
                break;
            if (raiting(sumSignsInReverseDiagonal(CROSS_SIGN), maxRaiting, ReverseDiagonalNextX, ReverseDiagonalNextY))
                break;
        }
    }
}