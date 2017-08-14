package ru.davidlevy.lesson6;

import java.io.*;
import java.util.Scanner;

/**
 * В данной программе изучаем Работу со строками и файлами *
 * Ключивые слова: java.io.InputStream, java.io.OutputStream, java.io.FileOutputStream,
 * String, StringBuffer, StringBuilder, FileInputStream, FileOutputStream, BufferedInputStream,
 * PrintStream, Scanner, System.out, InputStreamReader
 * try, catch, Exception
 *
 * @author David A. Lévy
 * @version 1.04 09.02.2017
 */
public class HomeWork6 {
    /* Писать будем в UTF-8 */
    private final static String CHARSET = "UTF-8";

    /* имена файлов */
    private final static String FILEOUT_0 = "ru/davidlevy/lesson6/file0.txt";
    private final static String FILEOUT_1 = "ru/davidlevy/lesson6/file1.txt";
    private final static String FILEOUT_2 = "ru/davidlevy/lesson6/file2.txt";
    private final static String FILEOUT_3 = "ru/davidlevy/lesson6/file3.txt";

    /**
     * Метод createFileUsePrintWriter печатает в файл filename строки перечисленные в массиве String[].
     *
     * @param filename имя файла String
     */
    private static void createFileUsePrintWriter(String filename) throws Exception {
        String[] strings = {"*line0русский\n",
                "*line1עברית\n",
                "*line2\n",
                "*line3\n",
                "*line4\n"};

        PrintWriter pw = new PrintWriter(filename, CHARSET);
        for (String l : strings) {
            pw.print(l.toCharArray());
        }
        pw.flush();
        pw.close();
    }

    /**
     * Метод createFileUseFileOutputStream создает в файле filename строки перечисленные в массиве String[].
     *
     * @param filename имя файла String
     */
    private static void createFileUseFileOutputStream(String filename) {
        String[] strings = {"***\nО сколько нам открытий чудных\n",
                "Готовит просвещенья дух",
                "И опыт, сын ошибок трудных,\n",
                "И гений, парадоксов друг,",
                "И случай, бог изобретатель.\n"};

        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл " + filename);
            return;
        }

        try {
            fileOutputStream.write(strings[0].getBytes(CHARSET));

            fileOutputStream.write(strings[1].getBytes(CHARSET));
            fileOutputStream.write(13);

            StringBuilder stringBuilder1 = new StringBuilder(strings[2]);
            fileOutputStream.write(stringBuilder1.toString().getBytes(CHARSET));

            StringBuffer stringBuffer2 = new StringBuffer(strings[3]);
            stringBuffer2.append("\n");
            fileOutputStream.write(stringBuffer2.toString().getBytes(CHARSET));

            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(strings[4]);
            fileOutputStream.write(stringBuffer3.toString().getBytes(CHARSET));

            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод screateFileUsePrintStream создает в файле filename строки перечисленные в массиве String[].
     *
     * @param filename имя файла String
     */
    private static void createFileUsePrintStream(String filename) {
        String[] strings = {"***\nСегодня был я ей представлен,\n",
                "...Глядел на мужа с полчаса;...",
                "Он важен, красит волоса,",
                "Он чином от ума избавлен.",
                "                  А.С. Пушкин\n"};
        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл " + filename);
            return;
        }

        try {
            PrintStream printStream = new PrintStream(fileOutputStream, true, CHARSET);
            printStream.write('\n');
            printStream.write(strings[0].getBytes());

            CharSequence sequence = (strings[1]).toString();
            printStream.append(sequence, 3, 28);
            printStream.write('\n');

            StringBuilder stringBuilder = new StringBuilder(strings[2]);
            stringBuilder.append("\n");
            printStream.write(stringBuilder.toString().getBytes());

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strings[3]);
            stringBuffer.append("\n");
            printStream.write(stringBuffer.toString().getBytes());

            printStream.print(strings[4].toCharArray());
            printStream.println();

            fileOutputStream.close();
            printStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод seekEntry ищет в файле filename вхождение строки типа String
     *
     * @param filename имя файла String
     * @param find     строка-вхождение String
     */
    private static void seekEntry(String filename, String find) {
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл " + filename);
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();

        try {
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                stringBuffer.append(scanner.nextLine());
            }
            scanner.close();
            fileInputStream.close();
            if (stringBuffer.lastIndexOf(find) > 0)
                System.out.println("Есть вхождение.");
            else System.out.println("Не найдена строка '" + find + "'");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод fileToBuffer переписывает строки из файла filename в объект типа StringBuffer
     *
     * @param filename имя файла String
     * @param buffer   объект типа StringBuffer
     */
    private static void fileToBuffer(String filename, StringBuffer buffer) {
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл " + filename);
            return;
        }

        try {
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                buffer.append(scanner.nextLine());
                buffer.append("\n");
            }
            scanner.close();
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод fileToBufferV2 переписывает строки из файла filename в объект типа StringBuffer
     *
     * @param filename     имя файла String
     * @param stringBuffer объект типа StringBuffer
     */
    private static void fileToBufferV2(String filename, StringBuffer stringBuffer) {
        int oneCharacter;
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(filename), CHARSET);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл " + filename);
            return;
        } catch (UnsupportedEncodingException e) {
            System.out.println("Неподдерживаемая кодировка.");
        }

        try {
            do {
                oneCharacter = inputStreamReader.read();
                if (oneCharacter != -1) stringBuffer.append((char) oneCharacter);
            } while (oneCharacter != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла " + filename);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла " + filename);
            }
        }
    }

    /**
     * Метод bufferToFile переписывает строки из объекта StringBuffer в файл filename
     *
     * @param stringBuffer объект типа StringBuffer
     * @param filename     имя файла String
     */
    private static void bufferToFile(StringBuffer stringBuffer, String filename) {
        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл " + filename);
            return;
        }

        try {
            PrintStream printStream = new PrintStream(fileOutputStream, true, CHARSET);
            printStream.println(stringBuffer);
            fileOutputStream.close();
            printStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод в выходной файл outputFile пишет последовательно inputFile1 и inputFile2
     *
     * @param inputFile1 входной файл1 String
     * @param inputFile2 входной файл2 String
     * @param outputFile выходной файл String
     */
    private static void mergeToFile(String inputFile1, String inputFile2, String outputFile) {
        StringBuffer stringBuffer = new StringBuffer();
        fileToBuffer(inputFile1, stringBuffer);   // вариант 1 fileToBuffer
        //fileToBuffer(inputFile2, stringBuffer);
        //fileToBufferV2(inputFile1, stringBuffer); // вариант 2 fileToBufferV2
        fileToBufferV2(inputFile2, stringBuffer);
        bufferToFile(stringBuffer, outputFile);
    }

    public static void main(String[] args) throws Exception {
        createFileUsePrintWriter(FILEOUT_0);
        createFileUseFileOutputStream(FILEOUT_1);
        createFileUsePrintStream(FILEOUT_2);
        mergeToFile(FILEOUT_1, FILEOUT_2, FILEOUT_3);
        seekEntry(FILEOUT_3, "друг");
        seekEntry(FILEOUT_3, "д+руг");
    }
}