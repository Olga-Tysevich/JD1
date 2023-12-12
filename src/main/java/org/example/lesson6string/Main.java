package org.example.lesson6string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //\W - Любой символ, кроме цифр, букв (латинский алфавит) и знака подчеркивания. Эквивалентно [^0-9a-zA-Z_] .
        /*Введите с клавиатуры строку. Найти в строке не только запятые, но и другие знаки препинания. Посчитать их общее количество*/
        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        String s = "\\W - Любой символ, кроме цифр, букв (латинский алфавит) и знака подчеркивания. Test .";

        Pattern p = Pattern.compile("\\p{P}");
        Matcher m = p.matcher(s);
        int punctuationMarks = 0;

        while (m.find()) {
            punctuationMarks++;
        }

        System.out.println("There are " + punctuationMarks + " punctuation marks in the line");

        /*Введите с клавиатуры текст. Подсчитать количество слов в тексте. Учесть, что слова могут разделяться несколькими пробелами,
         в начале и конце текста также могут быть пробелы, но могут и отсутствовать */
        p = Pattern.compile("[а-яА-Я]+|[a-zA-Z]+");
        m = p.matcher(s);

        int wordCount = 0;

        while (m.find()) {
            wordCount++;
        }

        System.out.println("Text contains " + wordCount + " words");

        /*Введите с клавиатуры текст. Выведите на экран текст, составленный из последних букв всех слов исходного текста*/
        s = s.replaceAll("\\p{P}", " ").strip().replaceAll("\\s+", " ");
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word.charAt(word.length() - 1));
        }
        System.out.println(sb);

        /*Введите с клавиатуры строку. Напишите метод, выполняющий поиск в строке шестнадцатеричных чисел, записанных по правилам
        * Java, с помощью регулярных выражений. Результат работы выведите на экран*/
        s = "Число d в шестнадцатеричной системе: 0x141D12. int d = 0x141Z12; // Ошибка. ри использовании типа long необходимо в конце ставить символ L," +
                " обозначающий этот тип:long x = 0x1101010110; // Ошибка";
        p = Pattern.compile("0x\\w+");
        m = p.matcher(s);
        StringBuilder stringBuilder = new StringBuilder("Шестнадцатиричные числа в строке: ");

        while (m.find()) {
            stringBuilder.append(m.group()).append(", ");
        }
        System.out.println(stringBuilder);

        /*Введите с клавиатуры строку. Напишите метод, выполняющий поиск в строке всех тегов базацев, в том числе тех, у которых есть параметры,
        * например, <p id="p1">, и замену их на простые теги абзацев <p>. Результат работы выведите на экран*/
        s = "<h2>Отображение HTML-кода</h2>\n" +
                "<p id=\"p1\">Вы не можете быть уверены, как будет отображаться HTML.</p>\n" +
                "<p>Большие или малые экраны, и размер окна будут создавать различные результаты.</p>\n" +
                "<p>С помощью HTML нельзя изменить вывод, добавляя лишние пробелы или дополнительные строки в HTML-код.</p>\n" +
                "<p id=\"p2\">При отображении страницы браузер удалит лишние пробелы и дополнительные строки:</p>\n" +
                "<div class=\"w3-example\">\n" +
                "<h3>Пример</h3>\n" +
                "<div class=\"w3-code notranslate htmlHigh\">";
        List<String> strings = new ArrayList<>();
        p = Pattern.compile("<p[\\s\\w=\"]*>");
        m = p.matcher(s);

        while (m.find()) {
            strings.add(m.group());
        }

        strings.forEach(el -> System.out.println("Tag: " + el + ", "));

        System.out.println(s.replaceAll("<p[\\s\\w=\"]*>", "<p>"));

        /*Напишите два цикла выполняющих миллион сложений строк вида "aaabbbccc", один с помощью оператора сложения и String,
        * а другой с помощью StringBuilder и метода append. сравните скорость их работы. Выведите сравнение на экран*/

        char ch = 'a';
        String str1 = "";
        StringBuilder sb1 = new StringBuilder();
        long start = System.currentTimeMillis();

       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str1 = str1 + ch;
            }
            ch++;
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println(timeWorkCode);

        ch = 'a';
        long start2 = System.currentTimeMillis();
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb1.append(ch);
            }
            ch++;
        }
        long timeWorkCode2 = System.currentTimeMillis() - start2;
        System.out.println(timeWorkCode2);

        System.out.println("String + String is faster than append: " + (timeWorkCode > timeWorkCode2));

    }
}
