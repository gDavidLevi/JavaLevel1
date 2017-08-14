package ru.davidlevy.lesson1;

/**
 * Created by d.levi on 24.01.2017.
 */
public class HomeWork1 {
    /* 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a,b,c,d – входные параметры этого метода. */
    private static double evaluateExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /* 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах 10 до 20, если да – вернуть true, в противном случае – false. */
    private static boolean beToInterval(int a, int b) {
        if ((a + b >= 10) && (a + b <= 20)) {
            return true;
        } else {
            return false;
        }
        /* Или return (a + b >= 10) && (a + b <= 20); */
    }

    /* 5. * Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. */
    private static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
        /* Или return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)); */
    }

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения
        byte aByte = 127;
        short aShort = 32767;
        int aInt = 2147483647;
        long aLong = 9223372036854775807L;
        float aFloat = 3.4e+038f;
        double aDouble = 0x1.fffffffffffffP+1023;
        boolean aBoolean = true;
        char aChar = '\uffff';
        // дополнительно:
        float pi = 3.14_15F;
        float f1 = 123.4f;
        double d2 = 1.234e2;
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        long sociaPassportNumber = 17_05_700003L;
        long hexBytes = 0xFF_EC_DE_5E;
        long bytes = 0b11010010_01101001_10010100_10010010;

        /* Результат работы метода evaluateExpression */
        System.out.println("evaluateExpression:");
        System.out.println(evaluateExpression(6, 0.36f, 254, 17));

        /* Результат работы метода beToInterval */
        System.out.println("beToInterval:");
        System.out.println("9 и 0 > " + beToInterval(9, 0));
        System.out.println("10 и 5 > " + beToInterval(10, 5));
        System.out.println("10 и 11 > " + beToInterval(10, 11));

        /* Результат работы метода isLeapYear */
        System.out.println("isLeapYear:");
        System.out.println("2000 > " + isLeapYear(2000)); // высокосный
        System.out.println("2015 > " + isLeapYear(2015)); // не высокосный
        System.out.println("2016 > " + isLeapYear(2016)); // высокосный
        System.out.println("2100 > " + isLeapYear(2100)); // не высокосный
    }
}