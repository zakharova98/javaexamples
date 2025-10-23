package org.example.streamApi;

import org.example.classes.Box;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamApiExamplesTest {

    // collections for testing
    public List<Integer> integerList = new ArrayList<>() {{
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
    }};

    public List<String> words = new ArrayList<>() {{
        add("name");
        add("Sasha");
        add("apple");
    }};

    public Map<String, Integer> map = new HashMap<>() {{
        put("Sasha", 5);
        put("apple", 5);
        put("name", 4);
    }};

    public Box box1 = new Box(2,2,4);
    public Box box2 = new Box(1,2,8);
    public Box box3 = new Box(1,1,1);

    public List<Box> boxes = new ArrayList<>() {{
        add(box1);
        add(box2);
        add(box3);
    }};

    @Test
    public void filterTest() {
        List<Integer> expectedList = new ArrayList<>() {{
            add(2);
            add(4);
        }};

        List<Integer> actualList = StreamApiExamples.filterExample(integerList);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void processTest() {
        List<Integer> expectedList = new ArrayList<>() {{
            add(1);
            add(4);
            add(9);
            add(16);
            add(25);
        }};
        List<Integer> actualList = StreamApiExamples.preprocessExample(integerList);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void mapFromListTest() {
        Map<String, Integer> actualMap = StreamApiExamples.mapFromList(words);
        Assertions.assertEquals(map, actualMap);
    }

    @Test
    public void distinctLimitTest() {
        List<String> sourseList = new ArrayList<>();
        sourseList.add("Yesterday");
        sourseList.add("Wednesday");
        sourseList.add("Sunday");
        sourseList.add("Sasha");
        sourseList.add("I");
        sourseList.add("Sasha");

        List<String> filteringList = sourseList.stream()
                .filter(s -> s.length() >= 5)
                .peek(e -> System.out.println("Filtered value: " + e))
                .distinct()
                .peek(e -> System.out.println("distinct value: " + e))
                .sorted()
                .peek(e -> System.out.println("sorted value: " + e))
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());

        Assertions.assertTrue(filteringList.size() == 2);
        Assertions.assertTrue(filteringList.contains("Sunday"));
        Assertions.assertTrue(filteringList.contains("Wednesday"));
    }


    @Test
    public void setFromListTest() {
        List<String> sourseList = new ArrayList<>(words);
        sourseList.add("Sasha");
        sourseList.add("apple");

        Set<String> expectedSet = new HashSet<>() {{
            add("name");
            add("Sasha");
            add("apple");
        }};

        Set<String> actualSet = StreamApiExamples.setFromList(sourseList);
        Assertions.assertTrue(expectedSet.containsAll(actualSet));
    }

    @Test
    public void mapToListTest() {
        List<String> actualList = StreamApiExamples.mapToList(map);
        Assertions.assertTrue(words.containsAll(actualList));
    }

    @Test
    public void reduceTest() {
        int expected = 15;
        int actual = StreamApiExamples.reduce(integerList);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void groupingByExampleTest() {
        Map<Double, List<Box>> expextedMap = new HashMap<>() {{
            put(16.0, Arrays.asList(box1, box2));
            put(1.0, Collections.singletonList(box3));
        }};
        Map<Double, List<Box>> actualMap = StreamApiExamples.groupingByExample(boxes);
        Assertions.assertEquals(expextedMap, actualMap);
    }

    @Test
    public void optionalExampleTest() {
        Optional<String> empty = Optional.empty();
        Assertions.assertFalse(empty.isPresent());

        String name = "Sasha";
        Optional<String> opt = Optional.of(name);
        Assertions.assertTrue(opt.isPresent());

        Assertions.assertThrows(NullPointerException.class, () -> {
            Optional.of(null);
        });

        String nullValue = null;
        Optional<String> optNullable = Optional.ofNullable(nullValue);
        Assertions.assertFalse(optNullable.isPresent());

        String orElseName = Optional.ofNullable(nullValue).orElse("Sasha");
        Assertions.assertEquals("Sasha", orElseName);

        orElseName = Optional.ofNullable(nullValue).orElseGet(() -> "Sasha");
        Assertions.assertEquals("Sasha", orElseName);
    }


    @Test
    public void findTest() {
        Optional<Box> actualOpt = StreamApiExamples.findExample(boxes);
        Assertions.assertTrue(actualOpt.isPresent());
        Box box = actualOpt.get();
        Assertions.assertEquals(box, box1);
    }

    @Test
    public void findAnyTest() {
        Optional<Box> actualOpt = StreamApiExamples.findAnyExample(boxes);
        Assertions.assertTrue(actualOpt.isPresent());
        Box box = actualOpt.get();
        Assertions.assertEquals(box, box3);
    }

    @Test
    public void findMaxTest() {
        Optional<Box> actualOpt = boxes.stream()
                .filter(box -> box.getVolume() >= 16)
                .max(Comparator.comparing(Box::getWidth));
        Assertions.assertTrue(actualOpt.isPresent());
        Box box = actualOpt.get();
        Assertions.assertEquals(box, box1);
    }

    @Test
    public void findMinTest() {
        Optional<Box> actualOpt = boxes.stream()
                .filter(box -> box.getVolume() >= 16)
                .min(Comparator.comparing(Box::getWidth));
        Assertions.assertTrue(actualOpt.isPresent());
        Box box = actualOpt.get();
        Assertions.assertEquals(box, box2);
    }


    @Test
    public void sortTest() {
        List<String> sourseList = new ArrayList<>();
        sourseList.add("Yesterday");
        sourseList.add("Sasha");
        sourseList.add("I");
        sourseList.add("Love");

        List<String> actualList = StreamApiExamples.sortExample(sourseList);
        Assertions.assertEquals("I", actualList.get(0));
        Assertions.assertEquals("Love", actualList.get(1));
        Assertions.assertEquals("Sasha", actualList.get(2));
        Assertions.assertEquals("Yesterday", actualList.get(3));
    }

    @Test
    public void partitionTest() {
        List<Integer> evenExpected = new ArrayList<>() {{ add(2); add(4); }};
        List<Integer> oddExpected = new ArrayList<>() {{ add(1);  add(3); add(5); }};

        Map<Boolean, List<Integer>> actualMap = StreamApiExamples.partitioningExample(integerList);
        List<Integer> evenNumbersActual = actualMap.get(true);
        List<Integer> oddNumbersActual = actualMap.get(false);

        Assertions.assertTrue(evenExpected.containsAll(evenNumbersActual));
        Assertions.assertTrue(oddExpected.containsAll(oddNumbersActual));
    }

    @Test
    public void countTest() {
        long expected = 2;
        long actual = StreamApiExamples.countExample(integerList);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchTest() {
        boolean allMatch = words.stream()
                .allMatch(word -> word.length() > 3);
        Assertions.assertTrue(allMatch);

        allMatch = words.stream()
                .allMatch(word -> word.length() > 3000);
        Assertions.assertFalse(allMatch);

        //----------------------------------------------------------

        boolean anyMatch = words.stream()
                .anyMatch(word -> word.length() == 4);
        Assertions.assertTrue(anyMatch);

        anyMatch = words.stream()
                .anyMatch(word -> word.length() > 3000);
        Assertions.assertFalse(anyMatch);

        //----------------------------------------------------------

        boolean noneMatch = words.stream()
                .noneMatch(word -> word.length() > 3000);
        Assertions.assertTrue(noneMatch);
    }

    @Test
    public void joinTest() {
       String joinString = words.stream().collect(Collectors.joining(" - "));
       String expected = "name - Sasha - apple";
       Assertions.assertEquals(expected, joinString);
    }

    @Test
    // найти все коробки, у которых высота (height) больше 1 и объем = 16 в отсортированном порядке по ширине (width)
    public void example() {
        List<Box> boxList = new ArrayList<>();
        boxList.add(new Box(1,2,8));  // ==16
        boxList.add(new Box(5,5,5));
        boxList.add(new Box(2,2,4));  // ==16
        boxList.add(new Box(1,16,1)); // ==16
        boxList.add(new Box(6,6,6));

        List<Box> foundBoxes = new ArrayList<>();
        for (Box box : boxList) {
            if (box.getHeight() > 1 && box.getVolume() == 16)
                foundBoxes.add(box);
        }
        foundBoxes.sort(Comparator.comparing(Box::getWidth));

        List<Box> foundBoxesStream = boxList.stream()
                .filter(box -> box.getHeight() > 1 && box.getVolume() == 16)
                .sorted(Comparator.comparingDouble(Box::getWidth))
                .collect(Collectors.toList());

        Assertions.assertTrue(foundBoxesStream.containsAll(foundBoxes));
    }

    @Test
    public void streamMechanism() {
        final List<String> list = List.of("one", "two", "three");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
                .forEach(x -> {
                    System.out.println("forEach: " + x);
                });
    }

    @Test
    public void streamMechanismSort() {
        final List<String> list = List.of("one", "two", "three");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
                .sorted()
                .forEach(x -> {
                    System.out.println("forEach: " + x);
                });
    }

    @Test
    public void splitIteratorTest() {
        AtomicInteger i = new AtomicInteger(0);

        List<String> words = Stream.generate(() -> {
                    i.incrementAndGet();
                    return  "word " + i;
                }).limit(10)
                .collect(Collectors.toList());

        Spliterator<String> spliterator = words.spliterator();
        Spliterator<String> split2 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));
        System.out.println("-----");
        while (split2.tryAdvance(System.out::println));
    }

    @Test
    @Disabled
    public void parallelStreamTest() {
        AtomicInteger i = new AtomicInteger(0);

        List<Integer> numbers = Stream.generate((i::incrementAndGet))
                .limit(100000000)
                .collect(Collectors.toList());

        long startTime = System.nanoTime();
        List<Integer> evenNumbers = numbers.stream()
                .filter(n-> n % 2 == 0)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        long parallelTime = endTime - startTime;
        System.out.println("WITHOUT parallel execution Time = " + parallelTime/1000000 + " ms");

        startTime = System.nanoTime();
        List<Integer> evenNumbers2 = numbers.stream().parallel()
                .filter(n-> n % 2 == 0)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        endTime = System.nanoTime();
        parallelTime = endTime - startTime;
        System.out.println("WITH parallel execution Time = " + parallelTime/1000000 + " ms");
    }

    @Test
    @Disabled
    public void parallelStreamArraysTest() {
        List<Integer> arrayListOfNumbers = new ArrayList<>();
        List<Integer> linkedListOfNumbers = new LinkedList<>();

        IntStream.rangeClosed(1, 1_000_000).forEach(i -> {
            arrayListOfNumbers.add(i);
            linkedListOfNumbers.add(i);
        });

        long startTime = System.nanoTime();
        arrayListOfNumbers.stream().reduce(0, Integer::sum);
        long endTime = System.nanoTime();
        long execTime = endTime - startTime;
        System.out.println("ArrayList reduce stream() = " + execTime/1000000 + " ms");

        startTime = System.nanoTime();
        arrayListOfNumbers.parallelStream().reduce(0, Integer::sum);
        endTime = System.nanoTime();
        execTime = endTime - startTime;
        System.out.println("ArrayList reduce parallelStream() = " + execTime/1000000 + " ms");

        startTime = System.nanoTime();
        linkedListOfNumbers.stream().reduce(0, Integer::sum);
        endTime = System.nanoTime();
        execTime = endTime - startTime;
        System.out.println("LinkedList reduce stream() = " + execTime/1000000 + " ms");

        startTime = System.nanoTime();
        linkedListOfNumbers.parallelStream().reduce(0, Integer::sum);
        endTime = System.nanoTime();
        execTime = endTime - startTime;
        System.out.println("LinkedList reduce parallelStream() = " + execTime/1000000 + " ms");
    }

    @Test
    @Disabled
    public void performanceTest() {
        List<Integer> arrayListOfNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 1_000_000).forEach(arrayListOfNumbers::add);

        long startTime = System.nanoTime();
        arrayListOfNumbers.stream().reduce(0, Integer::sum);
        long endTime = System.nanoTime();
        long execTime = endTime - startTime;
        System.out.println("ArrayList reduce stream() = " + execTime/1000000 + " ms");

        startTime = System.nanoTime();
        arrayListOfNumbers.stream().parallel().reduce(0, Integer::sum);
        endTime = System.nanoTime();
        execTime = endTime - startTime;
        System.out.println("ArrayList reduce parallel() = " + execTime/1000000 + " ms");

        startTime = System.nanoTime();
        arrayListOfNumbers.stream().collect(Collectors.toSet());
        endTime = System.nanoTime();
        execTime = endTime - startTime;
        System.out.println("ArrayList collect stream() = " + execTime/1000000 + " ms");

        startTime = System.nanoTime();
        arrayListOfNumbers.stream().parallel().collect(Collectors.toSet());
        endTime = System.nanoTime();
        execTime = endTime - startTime;
        System.out.println("ArrayList collect parallel() = " + execTime/1000000 + " ms");
    }





}