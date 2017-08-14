package ru.davidlevy.lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Conspect6Alt {
    /* Константы */
    private static final Random RANDOM = new Random();
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final int FILES_AMOUNT = 10;
    private static final int WORDS_AMOUNT = 5;
    private static final int WORD_LENGTH = 10;
    private static final String TO_GEEKBRAINS = "geekbrains";

    /**
     * @param amount int
     * @return String
     */
    private static String generateSymbols(int amount) {
        String sequence = "";
        for (int i = 0; i < amount; i++)
            sequence += (char) (CHAR_BOUND_L + RANDOM.nextInt(CHAR_BOUND_H - CHAR_BOUND_L));
        return sequence;
    }

    /**
     * @param filename String
     * @param length   int
     * @throws IOException
     */
    private static void writeFileContents(String filename, int length) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        fileOutputStream.write(generateSymbols(length).getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private static void writeFileContents(String filename, int words, int length) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        for (int i = 0; i < words; i++) {
            if (RANDOM.nextInt(WORDS_AMOUNT) == WORDS_AMOUNT / 2)
                fileOutputStream.write(TO_GEEKBRAINS.getBytes());
            else
                fileOutputStream.write(generateSymbols(length).getBytes());
            fileOutputStream.write(' ');
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /**
     * @param file_in1 String
     * @param file_in2 String
     * @param file_out String
     * @throws IOException
     */
    private static void concatenate(String file_in1, String file_in2, String file_out) throws IOException {
        int ch;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        fileOutputStream = new FileOutputStream(file_out);

        fileInputStream = new FileInputStream(file_in1);
        while ((ch = fileInputStream.read()) != -1)
            fileOutputStream.write(ch);
        fileInputStream.close();

        fileInputStream = new FileInputStream(file_in2);
        while ((ch = fileInputStream.read()) != -1)
            fileOutputStream.write(ch);
        fileInputStream.close();

        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /**
     * @param filename String
     * @param search   String
     * @return boolean
     * @throws IOException
     */
    private static boolean isInFile(String filename, String search) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        byte[] searchSequence = search.getBytes();
        int ch;
        int i = 0;
        while ((ch = fileInputStream.read()) != -1) {
            if (ch == searchSequence[i])
                i++;
            else {
                i = 0;
                if (ch == searchSequence[i])
                    i++;
            }
            if (i == searchSequence.length) {
                fileInputStream.close();
                return true;
            }
        }
        fileInputStream.close();
        return false;
    }

    /**
     * @param files  String[]
     * @param search String
     * @return String[]
     * @throws IOException
     */
    private static String[] searchMatch(String[] files, String search) throws IOException {
        String[] list = new String[files.length];
        int count = 0;
        File path = new File(new File(".").getCanonicalPath());
        File[] listFilesAndDirs = path.listFiles();
        for (int i = 0, qi = listFilesAndDirs.length; i < qi; i++) {
            if (listFilesAndDirs[i].isDirectory())
                continue;
            for (int j = 0, qj = files.length; j < qj; j++)
                if (listFilesAndDirs[i].getName().equals(files[j]))
                    if (isInFile(listFilesAndDirs[i].getName(), search)) {
                        list[count] = listFilesAndDirs[i].getName();
                        count++;
                        break;
                    }
        }
        return list;
    }

    /* Точка входа */
    public static void main(String[] args) throws Exception {
        String[] filenames = new String[FILES_AMOUNT];
        for (int i = 0, q = filenames.length; i < q; i++)
            filenames[i] = "file_" + i + ".txt";

        for (int i = 0, q = filenames.length; i < q; i++)
            if (i < 2)
                writeFileContents(filenames[i], 100);
            else
                writeFileContents(filenames[i], WORDS_AMOUNT, WORD_LENGTH);
        System.out.println("First task results are in file_0 and file_1.");

        concatenate(filenames[0], filenames[1], "FILE_OUT.txt");
        System.out.println("Second task result is in FILE_OUT.");

        System.out.println("Check result in file_2 for third task is: " + isInFile(filenames[2], TO_GEEKBRAINS));

        System.out.println("And here's the result of the fourth task. Go ahead and check it!");
        String[] result = searchMatch(filenames, TO_GEEKBRAINS);
        for (int i = 0, q = result.length; i < q; i++)
            if (result[i] != null)
                System.out.println("File '" + result[i] + "' contains the searched word '" + TO_GEEKBRAINS + "'");
    }
}