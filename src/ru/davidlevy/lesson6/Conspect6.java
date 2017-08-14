package ru.davidlevy.lesson6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by david on 09.02.17.
 */
public class Conspect6 {
    private final static String FILE_NAME = "src/ru/davidlevy/lesson6/ClassWork.txt";

    public static void main(String[] args) throws Exception {
        /* пишем в файл */
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        String s = "Hello World!";
        fileOutputStream.write(s.getBytes()); // пишет байты строки s
        fileOutputStream.write(72); // пишет байт
        fileOutputStream.flush(); // использется при выводе FileOutputStream
        fileOutputStream.close();

        /* читаем из файла */
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        int oneByte;
        do {
            oneByte = fileInputStream.read();
            System.out.print((char) oneByte);  // читаем один байт-символ
        } while (oneByte != -1);
        fileInputStream.close();

        /* пишем в файл классом PrintStream */
        PrintStream printStream = new PrintStream(new FileOutputStream(FILE_NAME));
        printStream.println("PrintStream...");
        printStream.println("PrintStream...");
        printStream.println("PrintStream...");
        printStream.println("PrintStream...");
        printStream.println("PrintStream...");
        printStream.println("PrintStream...");
        printStream.close();

        /* читаем из файла */
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            System.out.println(nextLine);
        }
        scanner.close();
    }
}