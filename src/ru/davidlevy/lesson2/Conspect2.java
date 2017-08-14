package ru.davidlevy.lesson2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by david on 26.01.17.
 * Тема: switch, for, while, do, тернарный оператор, массивы
 */
public class Conspect2 {
    /**
     * Метод возведения в степень
     *
     * @param base          int
     * @param significative int
     * @return int
     */
    private static int power(int base, int significative) {
        int ret = 1;
        for (int i = 0; i < significative; i++) {
            ret *= base;
        }
        return ret;
    }

    /**
     * Метод Пифагор
     */
    private static void tabPifagor() {
        System.out.println("Таблица Пифагора");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    /* Константа */
    private static final int ARRAY_SIZE = 7;

    /**
     * Печать массива на экран
     *
     * @param array int[]
     */
    private static void showArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /* Точка входа */
    public static void main(String[] args) {
        System.out.println("switch::");
        String nickname = "David";
        /* switch */
        switch (nickname) {
            case "David":
                System.out.println("Message send to table #25");
                break;
            case "Shlomo":
                System.out.println("Message send to table #10");
                break;
            case "Rachel":
                System.out.println("Message send to table #5");
                break;
            default:
                break;
        }

        /* for */
        System.out.println("for::");
        for (int x = 0; x < 9; x++) {
            // Если x=3, то начать цикл со следующим х
            if (x == 3) continue;
            System.out.print("x");
        }
        System.out.println();
        System.out.println(power(2, 8));
        tabPifagor();

        /* while */
        System.out.println("while::");
        int index = 0;
        while (index < 10) {
            System.out.print(index++ + " \t");
        }

        /* do */
        System.out.println("\ndo::");
        index = 0;
        do {
            System.out.print(++index + " \t");
            if (index == 5) break;
        } while (index < 10);

        /* Тернарный оператор */
        System.out.println("\nтернарный оператор::");
        int a = 1, b = 2;
        System.out.println((a < b) ? a : b);

        /* Массивы */
        System.out.println("массивы::");
        int[] aArray = new int[5];
        int bArray[] = aArray;
        showArray(bArray);

        /* Массив строк */
        String[] names = new String[3];
        names[0] = "david";
        names[1] = "shlomo";
        names[2] = "dan";
        System.out.println(Arrays.toString(names));

        //
        int[] david = new int[ARRAY_SIZE];
        for (int i = 0, q = david.length; i < q; i++) {
            david[i] = i;
        }
        System.out.println(Arrays.toString(david));

        //
        int[][] tabPifagor = new int[9][9];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                tabPifagor[i - 1][j - 1] = i * j;
            }
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(tabPifagor[i]));
        }
        System.out.println(Arrays.deepToString(tabPifagor));

        /* Ввод с консоли, см. https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html  */
        System.out.println("ввод с консоли::\n");
        System.out.print("Prompt >> ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); // читать целое
        //String aWord = scanner.next(); // читать слово
        //String aString = scanner.nextLine(); // читать строку
        scanner.close();
        System.out.println(number);
    }
}