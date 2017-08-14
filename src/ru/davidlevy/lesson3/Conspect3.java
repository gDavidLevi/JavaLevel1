package ru.davidlevy.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by david on 28.01.17.
 */
public class Conspect3 {
    private static final int FIELD_SIZE = 3;
    private static final char EMPTY_DOT = ' ';
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';

    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    /* Игровое поле */
    private static final char[][] FIELD = new char[FIELD_SIZE][FIELD_SIZE];

    /* Инициализация поля */
    private static void initField() {
        for (int i = 0, qi = FIELD.length; i < qi; i++) {
            for (int j = 0, qj = FIELD[i].length; j < qj; j++)
                FIELD[i][j] = EMPTY_DOT;
        }
    }

    /* Выпод к консоль */
    private static void printField() {
        System.out.println("-------");
        for (int i = 0, qi = FIELD.length; i < qi; i++) {
            System.out.print('|');
            for (int j = 0, qj = FIELD[i].length; j < qj; j++) {
                System.out.print(FIELD[i][j] + "|");
            }
            System.out.println("\n-------");
        }
        System.out.println();
    }

    /* Установить СИМВОЛ по координатам */
    private static void setX0(int x, int y, char symbol) {
        FIELD[x][y] = symbol;
    }

    /* Ввод координат для установки КРЕСТИКА (для игрока) */
    private static void playerTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты X Y (1-3)> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellEmpty(x, y)); // пока доступна для ввода
        setX0(x, y, HUMAN_DOT);
    }

    /* Компьютер делает ход */
    private static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(FIELD_SIZE);
            y = RANDOM.nextInt(FIELD_SIZE);
        } while (!isCellEmpty(x, y)); // пока доступна для ввода
        setX0(x, y, AI_DOT);
    }

    /**
     * Можно ли ставить в координаты КРЕСТИК?
     *
     * @param x int
     * @param y int
     * @return boolean
     */
    private static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1)
            return false;
        if (FIELD[x][y] == EMPTY_DOT)
            return true;
        return false;
    }

    /**
     * Проверка на победу
     *
     * @param symbol char
     * @return boolean
     */
    private static boolean isWin(char symbol) {
        // по горизонтали
        return (FIELD[0][0] == symbol && FIELD[1][0] == symbol && FIELD[2][0] == symbol) ||
                (FIELD[0][1] == symbol && FIELD[1][1] == symbol && FIELD[2][1] == symbol) ||
                (FIELD[0][2] == symbol && FIELD[1][2] == symbol && FIELD[2][2] == symbol) ||
                // по вертикали
                (FIELD[0][0] == symbol && FIELD[0][1] == symbol && FIELD[0][2] == symbol) ||
                (FIELD[1][0] == symbol && FIELD[1][1] == symbol && FIELD[1][2] == symbol) ||
                (FIELD[2][0] == symbol && FIELD[2][1] == symbol && FIELD[2][2] == symbol) ||
                // по диагонали
                (FIELD[0][0] == symbol && FIELD[1][1] == symbol && FIELD[2][2] == symbol) ||
                (FIELD[2][0] == symbol && FIELD[1][1] == symbol && FIELD[0][2] == symbol);
    }

    /**
     * Ничья?
     *
     * @return boolean
     */
    private static boolean isFieldFull() {
        for (int i = 0, qi = FIELD.length; i < qi; i++) {
            for (int j = 0, qj = FIELD[i].length; j < qj; j++) {
                if (FIELD[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    /* Точка входа */
    public static void main(String[] args) {
        /* Инициализация */
        initField();

        /* Игровой цикл */
        while (true) {
            playerTurn();
            printField();
            if (isWin(HUMAN_DOT)) {
                System.out.println("Player wins");
                break;
            }
            aiTurn();
            printField();
            if (isWin(AI_DOT)) {
                System.out.println("Computer wins");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
        }

        /* Закрыть сканер */
        SCANNER.close();
    }
}