package ru.fafurin.javacore.lesson5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1.
        createCurrentDirFilesBackup(System.getProperty("user.dir") + "\\tmp");


        // 2.
        encodeAndSaveArrToFile("44.txt", fillArrayWithRandomValuesFrom0To3());
    }


    // 1. Написать функцию, создающую резервную копию всех файлов в директории (без
    // поддиректорий) во вновь созданную папку ./backup
    private static void createCurrentDirFilesBackup(String path) {
        File dir = new File(path);
        try {
            File[] files = dir.listFiles();
            if (files.length > 1) {
                Path backupFolder = Files.createDirectories(Path.of(dir.getAbsolutePath() + "/.backup"));
                for (File file : files) {
                    if (file.isFile()) {
                        Files.copy(file.toPath(),
                                (new File(backupFolder + "\\" + file.getName())).toPath(),
                                StandardCopyOption.REPLACE_EXISTING);
                    }
                }
                System.out.printf("Backup of %s files successfully created", path);
            } else System.out.printf("There are no files in %s", path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон [0, 3],
    // и представляют собой, например, состояния ячеек поля для игры в крестики-
    // нолики, где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,
    // 3 – резервное значение. Такое предположение позволит хранить в одном числе типа
    // int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

    private static void encodeAndSaveArrToFile(String filename, int[] numbers) {
        try (FileOutputStream stream = new FileOutputStream(filename)) {
            PrintWriter writer = new PrintWriter(stream);

            for (int i = 0; i < 3; i++) {
                byte res = 0;
                for (int j = 0; j < 3; j++) {
                    res += numbers[3 * i + j] << (j * 2);
                }
                writer.write(res);
            }
            writer.close();
            System.out.printf("The array successfully encoded and saved to file %s \n", filename);
            printFileSize(filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void printFileSize(String filename) {
        File file = new File(filename);
        long size = file.length();
        System.out.printf("The %s size is %s bytes", file, size);
    }

    private static int[] fillArrayWithRandomValuesFrom0To3() {
        int[] numbers = new int[9];
        for (int x = 0; x < numbers.length; x++) {
            numbers[x] = (int) (Math.random() * 4);
        }
        System.out.println("Array is " + Arrays.toString(numbers));
        return numbers;
    }

}
