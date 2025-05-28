package com.wakexgod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private String fileName;

    public WordCounter(String fileName) {
        this.fileName = fileName;
    }

    public String countWords(String[] wordsToCount) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Инициализация словаря
        for (String word : wordsToCount) {
            wordCountMap.put(word, 0);
        }

        // Чтение файла и подсчет слов
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : wordsToCount) {
                    int count = countOccurrences(line, word);
                    wordCountMap.put(word, wordCountMap.get(word) + count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Формирование результата
        StringBuilder result = new StringBuilder("[");
        for (String word : wordsToCount) {
            result.append(word).append("-").append(wordCountMap.get(word)).append(", ");
        }

        // Удаление последней запятой и пробела, добавление закрывающей скобки
        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        result.append("]");

        return result.toString();
    }

    private int countOccurrences(String line, String word) {
        String[] words = line.split("\\W+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }

    public static void execute() {
        WordCounter wordCounter = new WordCounter("D:\\MMF\\java\\technologies\\Lab8\\src\\main\\resources\\words.txt");
        String[] words = {"aaa", "bbb"};
        String result = wordCounter.countWords(words);
        System.out.println(result);
    }
}