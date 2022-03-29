package ru.vsu.cs.avdeeva_p_a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PriorityQueueList priorityQueue = new PriorityQueueList();

        String textFile = readFromFile();
        SortedSet<String> wordsList = sortWords(textFile);
        getWord(wordsList, priorityQueue);

        System.out.println("The first page of \"War and Peace\" sorted in descending order:\n"
                + priorityQueue);

    }

    public static String readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("firstPage.txt"));
        StringBuilder text = new StringBuilder();

        while (scanner.hasNextLine()) {
            text.append(scanner.nextLine());
        }
        return text.toString();
    }

    public static SortedSet<String> sortWords(String text) {
        Pattern pattern =
                Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        SortedSet<String> words = new TreeSet<>();

        while (matcher.find()) {
            words.add(matcher.group().toLowerCase(Locale.ROOT));
        }

        return words;
    }

    public static void getWord(SortedSet<String> listOfWords, PriorityQueueList priorityQueue) {
        for (String element : listOfWords) {
            priorityQueue.add(element);
        }
    }

}
