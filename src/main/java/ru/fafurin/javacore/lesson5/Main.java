package ru.fafurin.javacore.lesson5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1
        final String filename = "1.txt";
//        int[] numbers = {1, 4, 43, 6, 2, 5, 0, 1, 9};
//        printIntArrayToFile(filename, numbers);

        // 2
//        fillIntArrayFromFile(filename);

        // 3
//        replaceLetterInTextAndSaveToFile("1.txt", "2.txt", "w");

        // 3*
//        replaceWordInTextAndSaveToFile("1.txt", "2.txt", "one");

        // 4
//        printFilesFromDir(System.getProperty("user.dir"));

        // 4*
//        printFilesFromDirs(System.getProperty("user.dir"));

        // 5
        addPrefixToFile(new String[]{"1.txt", "2.txt"});
    }


    // 1. Создать массив из 9 цифр и записать его в файл, используя поток вывода.
    private static void printIntArrayToFile(String filename, int[] numbers) {
        try (FileOutputStream stream = new FileOutputStream(filename)) {
            PrintWriter writer = new PrintWriter(stream);
            writer.print('[');
            for (int x = 0; x < numbers.length; x++) {
                writer.print(numbers[x]);
                if (x < numbers.length - 1) writer.print(',');
            }
            writer.print(']');
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 2. Создать массив целых чисел и заполнить его информацией из файла, записанного в предыдущем задании.
    private static void fillIntArrayFromFile(String filename) {
        int[] res = new int[9];

        try (FileInputStream stream = new FileInputStream(filename)) {
            Scanner sc = new Scanner(stream);
            String str = sc.nextLine().replace("[", "").replace("]", "");
            String[] arr = str.split(",");
            for (int x = 0; x < arr.length; x++) {
                res[x] = Integer.parseInt(arr[x]);
            }
            System.out.println(Arrays.toString(res));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3. Написать программу заменяющую указанный символ в текстовом файле на пробел, сохраняющую получившийся текст в новый файл.
    private static void replaceLetterInTextAndSaveToFile(String oldFile, String newFile, String letter) {
        try (InputStream fileInputStream = new FileInputStream(oldFile)) {
            String str = new Scanner(fileInputStream).nextLine().replace(letter, " ");
            FileWriter writer = new FileWriter(newFile);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3*. Модифицировать алгоритм поиска замены символа так, чтобы программа осуществляла замену слова
    // (последовательного набора символов) в исходном файле и записывала результат в новый файл.
    private static void replaceWordInTextAndSaveToFile(String oldFile, String newFile, String word) {
        try (InputStream fileInputStream = new FileInputStream(oldFile)) {
            String str = new Scanner(fileInputStream).nextLine().replace(word, " ");
            FileWriter writer = new FileWriter(newFile);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 4. Написать программу, читающую и выводящую в содержимое текущей папки
    private static void printFilesFromCurrentDir(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) continue;
            System.out.println("./" + file.getName());
        }
    }

    // 4*. Написать программу таким образом, чтобы она рекурсивно выводила содержимое не только текущей папки,
    // но и вложенных.
    private static void printFilesFromDirs(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) printFilesFromDirs(file.getPath());
            System.out.println("./" + file.getName());
        }
    }

    // 5. Написать функцию, добавляющую префикс к каждому из набора файлов,
    // названия которых переданы ей в качестве параметров через пробел.

    private static void addPrefixToFile(String[] string) throws IOException {
        for (String fileName: string) {
            Path file = Path.of(fileName);
            if (Files.exists(file)) {
                Files.move(file, Paths.get("pre_" + file), REPLACE_EXISTING);
            } else {
                System.out.println("File not found");
            }
        }
    }

}
