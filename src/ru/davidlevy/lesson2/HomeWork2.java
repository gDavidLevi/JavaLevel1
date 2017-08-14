package ru.davidlevy.lesson2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * В данной программе изучаем основы
 *
 * @author David A. Levy
 * @version 1.00 27.01.2017
 */

public class HomeWork2 {
    /**
     * Генератор от min до max включительно
     *
     * @param min int
     * @param max int
     * @return int
     */
    private static int randomInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Заполнить массив случайными числами в диапазоне от min до max включительно
     *
     * @param array int[]
     * @param min   int
     * @param max   int
     */
    private static void fillArray(int[] array, int min, int max) {
        for (int i = 0, q = array.length; i < q; i++) {
            array[i] = randomInt(min, max);
        }
    }

    /**
     * Инвертирование элементов массива
     *
     * @param array int[]
     */
    private static void invertingBit(int[] array) {
        for (int i = 0, q = array.length; i < q; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
    }

    /**
     * Модификация элементов массива
     *
     * @param array int[]
     */
    private static void modificationElements(int[] array) {
        for (int i = 0, q = array.length; i < q; i++) {
            if (array[i] < 6)
                array[i] = array[i] * 2;
        }
    }

    /**
     * Минимальный элемент массива
     *
     * @param array int[]
     * @return int
     */
    private static int minElementOfArray(int[] array) {
        int min = 0;
        for (int i = 0, q = array.length; i < q; i++) {
            if (array[min] > array[i]) min = i;
        }
        return min;
    }

    /**
     * Максимальный элемент массива
     *
     * @param array int[]
     * @return int
     */
    private static int maxElementOfArray(int[] array) {
        int max = 0;
        for (int i = 0, q = array.length; i < q; i++) {
            if (array[max] < array[i]) max = i;
        }
        return max;
    }

    /**
     * Метод возведения в степень
     *
     * @param base          int
     * @param significative int
     * @return int
     */
    private static int involutionInt(int base, int significative) {
        int ret = 1;
        for (int i = 0; i < significative; i++) {
            ret *= base;
        }
        return ret;
    }

    /**
     * Калькулятор
     */
    private static void simpleCalc() {
        /* Ввод с консоли */
        Scanner console = new Scanner(System.in);
        System.out.println("Первый операнд >");
        String operand1 = console.nextLine();
        System.out.println("Введите операцию [+,-,*,/,^] >");
        String operation = console.nextLine();
        System.out.println("Второй операнд >");
        String operand2 = console.nextLine();
        console.close();

        /* Расчет */
        switch (operation) {
            case "+":
                System.out.println("Результат: " + operand1 + "+" + operand2 + " = " + (Integer.valueOf(operand1) + Integer.valueOf(operand2)));
                break;
            case "-":
                System.out.println("Результат: " + operand1 + "-" + operand2 + " = " + (Integer.valueOf(operand1) - Integer.valueOf(operand2)));
                break;
            case "*":
                System.out.println("Результат: " + operand1 + "*" + operand2 + " = " + (Integer.valueOf(operand1) * Integer.valueOf(operand2)));
                break;
            case "/":
                System.out.println("Результат: " + operand1 + "/" + operand2 + " = " + (Integer.valueOf(operand1) / Integer.valueOf(operand2)));
                break;
            case "^":
                System.out.println("Результат: " + operand1 + "^" + operand2 + " = " + involutionInt(Integer.valueOf(operand1), Integer.valueOf(operand2)));
                break;
            default:
                System.out.println("Операция не определена в программе! Выход.");
                break;
        }
    }

    /**
     * Расчет баланса
     *
     * @param array int[]
     * @return boolean
     */
    private static boolean checkBalance(int[] array) {
        int sumLeft = array[0];
        int sumRight = 0;
        for (int i = 1, q = array.length; i < q; i++)
            sumRight += array[i];
        for (int j = 0, q = array.length - 1; j < q; j++) {
            if (sumLeft == sumRight) {
                System.out.print("(sL:" + sumLeft + " sR:" + sumLeft + " bI: " + j + ") > ");
                return true;
            }
            sumLeft += array[j + 1];
            sumRight -= array[j];
        }
        return false;
    }

    /* Точка входа */
    public static void main(String[] args) {
        /* 1. Создать массив, состоящий из элементов 0 и 1, например, int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 }; */
        System.out.println(">> Решение задачи 1:");
        int[] array1 = new int[10];
        fillArray(array1, 0, 1);
        System.out.println(Arrays.toString(array1));

        /* 2. В массиве из предыдущего пункта с помощью цикла заменить 0 на 1, 1 на 0; */
        System.out.println("\n>> Решение задачи 2:");
        invertingBit(array1);
        System.out.println(Arrays.toString(array1));

        /* 3. Создать массив из 8 целых чисел. С помощью цикла заполнить его значениями 1 4 7 10 13 16 19 22 */
        System.out.println("\n>> Решение задачи 3:");
        int[] array2 = new int[8];
        for (int i = 0, q = array2.length; i < q; i++) {
            array2[i] = 3 * i + 1;
        }
        System.out.println(Arrays.toString(array2));

        /* 4. Задать массив int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }; пройти по нему циклом, и числа, которые меньше 6, умножить на 2. */
        System.out.println("\n>> Решение задачи 4:");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("До " + Arrays.toString(array3));
        modificationElements(array3);
        System.out.println("После " + Arrays.toString(array3));

        /* 5. * Задать одномерный массив и найти в нем минимальный и максимальный элементы; */
        System.out.println("\n>> Решение задачи 5*:");
        int[] array4 = new int[7];
        fillArray(array4, 0, 20);
        System.out.println(Arrays.toString(array4));
        System.out.println("Минимальный элемент: " + minElementOfArray(array4));
        System.out.println("Максимальный элемент: " + maxElementOfArray(array4));

        /* 6 ** Написать простой консольный калькулятор. Пользователь вводит два числа и операцию, которую хочет выполнить, программа вычисляет результат и выводит в консоль; */
        System.out.println("\n>> Решение задачи 6**:");
        simpleCalc();

        /* Другая методичка. 5. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами; */
        System.out.println("\n>> Решение задачи 5 из другой методички:");
        int sizeMatrix = 5;
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        for (int i = 0, q = matrix.length; i < q; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
        for (int[] i : matrix)
            System.out.println(Arrays.toString(i));

        /* Другая методичка. 7. * Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance ([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят. */
        System.out.println("\n>> Решение задачи 7* из другой методички:");
        int[] array6 = new int[7];
        for (int i = 0; i < 5; i++) {
            fillArray(array6, 1, 2);
            System.out.println(Arrays.toString(array6) + " → " + checkBalance(array6));
        }
        int[] array7 = new int[6];
        for (int i = 0; i < 5; i++) {
            fillArray(array7, 0, 1);
            System.out.println(Arrays.toString(array7) + " → " + checkBalance(array7));
        }
        /* {10, 1, 2, 3, 4}  → [10 |тут| 1, 2, 3, 4] */
        int[] array8 = {10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(array8) + " → " + checkBalance(array8));

        System.out.println("\nКонец.");
    }
}