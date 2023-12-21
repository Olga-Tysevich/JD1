package org.example.lesson11files.files;

import org.example.lesson11files.service.CustomReader;
import org.example.lesson11files.service.CustomWriter;
import org.example.lesson11files.service.DirectoryManager;
import org.example.lesson11files.service.TextManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.example.lesson11files.files.Constants.*;

public class FilesDemo {
    public static void main(String[] args) {
        DirectoryManager directoryManager = new DirectoryManager();
        CustomReader reader = new CustomReader();
        CustomWriter writer = new CustomWriter();
        TextManager textManager = new TextManager();
        File file = new File(FILE);

        /*47) Вывести список файлов и каталогов выбранного каталога на диске.
         * Файлы и катологи должны быть распечетаны отдельно*/
        try {
            directoryManager.getDirectoriesList(DIRECTORY).forEach(System.out::println);
            System.out.println();
            directoryManager.getFilesList(DIRECTORY).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*48) Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов. Вывести результат*/
        System.out.println();
        List<String> text = reader.readFile(file);
        System.out.println("Words: " + textManager.findWords(text) + ", punctuation marks: " + textManager.findPunctuationsMark(text));

        /*49) Создать файл с текстом, в котором присутствуют числа. Найти все числа, вывести на экран, посчитать сумму,
        убрать все повторяющиеся и снова вывести на экран*/
        System.out.println();
        List<Double> numbers = textManager.findNumbers(reader.readFile(file));
        System.out.println(numbers + "\n");
        System.out.println("Sum: " + numbers.stream().reduce(Double::sum).orElse(0D));
        System.out.println("\n" + numbers.stream().distinct().toList());

        /*50) Записать с помощью Java в двоичный файл 20 случайных чисел.
         * Прочитать записанный файл, вывести на экран числа и их среднее арифметическое*/
        System.out.println();
        List<Integer> source = new ArrayList<>(new Random().ints(20, 0, 151).boxed().toList());
        System.out.println(source);
        writer.writeIntToBinaryFile(source, BINARY_FILE, false);
        source = reader.readIntFromBinaryFile(BINARY_FILE);
        System.out.println(source);
        System.out.println("Average: " + ((double) source.stream().reduce(Integer::sum).orElse(0) / source.size()) + "\n");

        /*51) Создать цепочку из трех папок. В конечном каталоге создать 5 произвольных текстовых файлов.
         * Заполнить их 10 произвольными целыми числами. Содержимое файлов записать в один файл в том же каталоге.
         * Создать файл, который будет содержать список файлов данного каталога*/
        System.out.println("Directory created: " + new File(DIRECTORY_PATH).mkdirs());
        List<String> fileNames = new ArrayList<>();
        IntStream.range(1, 6).forEach(i -> fileNames.add(DIRECTORY_PATH + FILE_NAME.replace(FILE_NUMBER, String.valueOf(i))));

        fileNames.forEach(f -> writer.writeToFile(new Random().ints(10, 0, 51).boxed().toList(), f, false));

        fileNames.forEach(f -> writer.writeToFile(reader.readFile(new File(f)), DIRECTORY_PATH + MERGED_FILE_NAME, true));

        try {
            writer.writeToFile(directoryManager.getFilesList(DIRECTORY_PATH), DIRECTORY_PATH + FILE_LIST_NAME, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
