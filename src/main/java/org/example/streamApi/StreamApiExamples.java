package org.example.streamApi;

import java.util.*;
import java.util.stream.Collectors;
import org.example.classes.Box;

public class StreamApiExamples {



    public static List<Integer> filterExample(List<Integer> sourceList) {
        return sourceList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> preprocessExample(List<Integer> sourceList) {
        return sourceList.stream()
                .map(n -> n*n)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> mapFromList(List<String> sourceList) {
        return sourceList.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        String::length));
    }

    public static Set<String> setFromList(List<String> sourceList) {
        return sourceList.stream()
                .collect(Collectors.toSet());
    }

    public static List<String> mapToList(Map<String, Integer> map) {
        return map.entrySet().stream()
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public static int reduce(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static Map<Double, List<Box>> groupingByExample(List<Box> boxes) {
        return boxes.stream()
                .collect(Collectors.groupingBy(box -> box.getVolume()));
    }

    public static Optional<Integer> findFirstExample(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
    }

    public static Optional<Box> findExample(List<Box> boxes) {
        return boxes.stream()
                .filter(box -> box.getVolume() > 5)
                .findFirst();
    }

    public static Optional<Box> findAnyExample(List<Box> boxes) {
        return boxes.stream()
                .filter(box -> box.getHeight() == 1)
                .findAny();
    }

    public static List<String> sortExample(List<String> sourceList) {
        return sourceList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Map<Boolean, List<Integer>> partitioningExample(List<Integer> sourceList) {
        return sourceList.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    public static long countExample(List<Integer> sourceList) {
        return sourceList.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }
}
