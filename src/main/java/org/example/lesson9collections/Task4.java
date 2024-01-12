package org.example.lesson9collections;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task4 {
    public static final String ANY_WORD = "[a-zA-Z]+|[а-яА-я]+";
    public static final String NOT_WORD = "\\s+\\p{P}*\\s*|\\p{P}*\\n+\\p{P}*|\\s*\\p{P}+\\s*";

    public static void main(String[] args) {
        /*Ввести текст с клавиатуры. Для текста создать Мар, где ключом будет слово,
        а значение - количество повторений этого слова в тексте*/
        String text = TextScanner.getText();
        System.out.println(text);

        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        String[] words = text.split(NOT_WORD);

        for (String w : words) {
            wordsMap.put(w, wordsMap.containsKey(w) ? wordsMap.get(w) + 1 : 1);
        }
        System.out.println(wordsMap);
        System.out.println('\n');


        wordsMap = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(ANY_WORD);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            wordsMap.put(matcher.group(), wordsMap.containsKey(matcher.group()) ? wordsMap.get(matcher.group()) + 1 : 1);
        }
        System.out.println(wordsMap);
        System.out.println('\n');


        Map<String, Integer> wordsMap2 = new LinkedHashMap<>();
        Arrays.stream(words).forEach(w -> wordsMap2.put(w, Collections.frequency(Arrays.stream(words).collect(Collectors.toList()), w)));
        System.out.println(wordsMap2);
    }

}
