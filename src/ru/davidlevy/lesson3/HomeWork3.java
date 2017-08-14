package ru.davidlevy.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * В данной программе создается игра TicTacToe
 *
 * @author David A. Levy
 * @version 2.00 28.01.2017
 */
public class HomeWork3 {
    /* Константа. Размер поля */
    private static final int FIELD_SIZE = 5;

    /* Константа. Выигрышная серия */
    private static final int MAX_SERIA = 4;

    /* Константы. Символы */
    private static final char EMPTY_CELL = ' ';
    private static final char CROSS_SIGN = '+';
    private static final char ZERO_SIGN = 'O';

    /* Матрица символов */
    private static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    /* Генератор случайных значений */
    private static Random random = new Random();

    /* Сканер консоли */
    private static Scanner scanner = new Scanner(System.in);

    /* Координаты */
    private static int ColNextX = 0;
    private static int ColNextY = 0;
    private static int RowNextX = 0;
    private static int RowNextY = 0;
    private static int StraightDiagonalNextX = 0;
    private static int StraightDiagonalNextY = 0;
    private static int ReverseDiagonalNextX = 0;
    private static int ReverseDiagonalNextY = 0;

    /* Инициализация поля */
    private static void constructorField() {
        for (int i = 0, qi = field.length; i < qi; i++) {
            for (int j = 0, qj = field[i].length; j < qj; j++)
                field[i][j] = EMPTY_CELL;
        }
    }

    /* Вывод поля на экран */
    private static void printField() {
        for (int i = 0, qi = field.length; i < qi; i++) {
            System.out.print('|');
            for (int j = 0, qj = field[i].length; j < qj; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    /* Установить СИМВОЛ по координатам */
    private static void setInCell(int x, int y, char s) {
        field[x][y] = s;
    }

    /**
     * Вес символов в колонке
     *
     * @param sign char
     * @return int
     */
    private static int sumSignsInCol(char sign) {
        int counter;
        for (int i = 0; i < FIELD_SIZE; i++) {
            counter = 0;
            for (int j = 0; j < FIELD_SIZE - 1; j++) {
                if (((field[j][i]) == (field[j + 1][i])) & (field[j + 1][i] == sign)) {
                    counter++;
                    if (isCellEmpty(j + 1 + 1, i)) {
                        ColNextX = j + 1 + 1;
                        ColNextY = i;
                    }
                }
            }
            if (counter > 0) {
                return counter + 1;
            }
        }
        return 0;
    }

    /**
     * Вес символов в строке
     *
     * @param sing char
     * @return int
     */
    private static int sumSignsInRow(char sing) {
        int counter;
        for (int i = 0; i < FIELD_SIZE; i++) {
            counter = 0;
            for (int j = 0; j < FIELD_SIZE - 1; j++) {
                if (((field[i][j]) == (field[i][j + 1])) & (field[i][j] == sing)) {
                    counter++;
                    if (isCellEmpty(i, j + 1 + 1)) {
                        RowNextX = i;
                        RowNextY = j + 1 + 1;
                    }
                }
            }
            if (counter > 0) {
                return counter + 1;
            }
        }
        return 0;
    }

    /**
     * Вес символов в прямой диагонали
     *
     * @param sing char
     * @return int
     */
    private static int sumSignsInStraightDiagonal(char sing) {
        int counter = 0;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            if ((field[i][i] == field[i + 1][i + 1]) & (field[i][i] == sing)) {
                counter++;
                if (isCellEmpty(i + 1 + 1, i + 1 + 1)) {
                    StraightDiagonalNextX = i + 2;
                    StraightDiagonalNextY = i + 2;
                    counter++;
                }
                if (isCellEmpty(i - 1, i - 1)) {
                    StraightDiagonalNextX = i - 1;
                    StraightDiagonalNextY = i - 1;
                    counter++;
                }
            }
        }
        if (counter > 0) {
            return counter + 1;
        } else
            return 0;
    }

    /**
     * Вес символов в обратной диагонали
     *
     * @param sing char
     * @return int
     */
    private static int sumSignsInReverseDiagonal(char sing) {
        int counter;
        counter = 0;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            if ((field[i][FIELD_SIZE - i - 1] == field[i + 1][FIELD_SIZE - i - 2]) & (field[i][FIELD_SIZE - i - 1] == sing)) {
                counter++;
                if (isCellEmpty(i + 1 + 1, FIELD_SIZE - i - 2 - 1)) {
                    ReverseDiagonalNextX = i + 1 + 1;
                    ReverseDiagonalNextY = FIELD_SIZE - i - 2 - 1;
                    counter++;
                }
            }
        }
        if (counter > 0) {
            return counter + 1;
        } else
            return 0;
    }

    /**
     * Вводит пользователь
     */
    private static void playerTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X Y (1-" + FIELD_SIZE + ")> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        setInCell(x, y, CROSS_SIGN);
    }

    /**
     * Автомат принятия решений
     */
    private static void aiTurn() {
        System.out.println("Ходит компьютер");
        int sCol, sRow, sSD, sRD, maxRaiting;
        sCol = sumSignsInCol(CROSS_SIGN);
        sRow = sumSignsInRow(CROSS_SIGN);
        sSD = sumSignsInStraightDiagonal(CROSS_SIGN);
        sRD = sumSignsInReverseDiagonal(CROSS_SIGN);
        for (maxRaiting = 10; maxRaiting > 0; maxRaiting--) {
            if (sCol == maxRaiting) {
                if (isCellEmpty(ColNextX, ColNextY)) setInCell(ColNextX, ColNextY, ZERO_SIGN);
                break;
            }
            if (sRow == maxRaiting) {
                if (isCellEmpty(RowNextX, RowNextY)) setInCell(RowNextX, RowNextY, ZERO_SIGN);
                break;
            }
            if (sSD == maxRaiting) {
                if (isCellEmpty(StraightDiagonalNextX, StraightDiagonalNextY))
                    setInCell(StraightDiagonalNextX, StraightDiagonalNextY, ZERO_SIGN);
                break;
            }
            if (sRD == maxRaiting) {
                if (isCellEmpty(ReverseDiagonalNextX, ReverseDiagonalNextY))
                    setInCell(ReverseDiagonalNextX, ReverseDiagonalNextY, ZERO_SIGN);
                break;
            }
        }
        if (sCol == 0 | sRow == 0 | sSD == 0 | sRD == 0) {
            aiTurnRandom();
        }
    }

    /* Компьютер делает ход */
    private static void aiTurnRandom() {
        int x;
        int y;
        do {
            x = random.nextInt(FIELD_SIZE);
            y = random.nextInt(FIELD_SIZE);
        } while (!isCellEmpty(x, y));
        setInCell(x, y, ZERO_SIGN);
    }

    /**
     * Можно ли ставить в координаты КРЕСТИК/НОЛИК?
     *
     * @param x int
     * @param y int
     * @return boolean
     */
    private static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1)
            return false;
        return field[x][y] == EMPTY_CELL;
    }

    /**
     * Проверка по колонкам
     *
     * @param sign char
     * @return boolean
     */
    private static boolean isWinInCol(char sign) {
        int counter;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            counter = 0;
            for (int j = 0; j < FIELD_SIZE - 1; j++) {
                if ((field[j][i] == field[j + 1][i]) & (field[j + 1][i] == sign)) {
                    counter++;
                }
            }
            if (counter == MAX_SERIA - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Поиск выигрышной комбинации в строке
     *
     * @param sign char
     * @return boolean
     */
    private static boolean isWinInRow(char sign) {
        int counter;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            counter = 0;
            for (int j = 0; j < FIELD_SIZE - 1; j++) {
                if ((field[i][j] == field[i][j + 1]) & (field[i][j] == sign)) {
                    counter++;
                }
            }
            if (counter == MAX_SERIA - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Поиск выигрышной комбинации в прямой диагонали
     *
     * @param sign char
     * @return boolean
     */
    private static boolean isWinInDiagonalStraight(char sign) {
        int counter = 0;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            if ((field[i][i] == field[i + 1][i + 1]) & (field[i][i] == sign))
                counter++;
        }
        if (counter == MAX_SERIA - 1) {
            return true;
        }
        return false;
    }

    /**
     * Поиск выигрышной комбинации в обратной диагонали
     *
     * @param sign char
     * @return boolean
     */
    private static boolean isWinInDiagonalReverse(char sign) {
        int counter;
        counter = 0;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            if ((field[i][FIELD_SIZE - i - 1] == field[i + 1][FIELD_SIZE - i - 2]) & (field[i][FIELD_SIZE - i - 1] == sign)) {
                counter++;
            }
        }
        if (counter == MAX_SERIA - 1) {
            return true;
        }
        return false;
    }

    /**
     * Проверка на победу
     *
     * @param sign char
     * @return boolean
     */
    private static boolean isWin(char sign) {
        return (isWinInRow(sign) | isWinInCol(sign) | isWinInDiagonalStraight(sign) | isWinInDiagonalReverse(sign));
    }

    /**
     * Ничья?
     *
     * @return boolean
     */
    private static boolean isFieldFull() {
        for (int i = 0, qi = field.length; i < qi; i++) {
            for (int j = 0, qj = field[i].length; j < qj; j++) {
                if (field[i][j] == EMPTY_CELL) return false;
            }
        }
        return true;
    }

    /* Точка входа */
    public static void main(String[] args) {
        /* Инициализация поля */
        constructorField();

        /* Игровой цикл */
        while (true) {
            playerTurn();
            printField();
            if (isWin(CROSS_SIGN)) {
                System.out.println("Пользователь выиграл!");
                break;
            }
            aiTurn();
            printField();
            if (isWin(ZERO_SIGN)) {
                System.out.println("Компьютер тебя обыграл.");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
        }

        /* Закрыть сканер ввода с клавиатуры  */
        scanner.close();
    }
}