package org.example.lesson11files.service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.lesson11files.service.ServiceConstants.*;

public class TextManager {

    public long findWords(List<String> strings) {
        return strings.stream().map(s -> Arrays.stream(s.split(NOT_WORD)).toList().size())
                .reduce(Integer::sum).orElse(0);
    }

    public long findPunctuationsMark(List<String> strings) {
        return strings.stream().map(s -> Arrays.stream(s.split(NOT_PUNCTUATIONS_MARK))
                .filter(e -> !e.isBlank()).count()).reduce(Long::sum).orElse(0L);
    }

    public List<Double> findNumbers(List<String> strings) {
        List<String> filteredStrings = findMatches(ANY_NUMBER, strings);
        List<Double> numbers = new ArrayList<>();
        filteredStrings.forEach(e -> numbers.add(Double.parseDouble(e.replace(NUMBER_SEPARATOR_RUS, NUMBER_SEPARATOR_US))));
       return numbers;
    }

    private  List<String> findMatches(String regex, List<String> strings) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        for (String s : strings) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                result.add(matcher.group());
            }
        }
        return result;
    }
}
