package org.example.collections;

import java.util.*;

public class CollectionsExamples {

    public CollectionsExamples() {
    }

    public void arrayListDemo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        System.out.println("ArrayList elements size = " + list.size() + ". Elements:");
        list.forEach(System.out::println);

        list.remove("Monday");
        System.out.println("\nArrayList elements size after remove = " + list.size() + ". Elements:");
        list.forEach(System.out::println);
    }

    public void linkedListDemo() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        System.out.println("LinkedList elements size = " + list.size() + ". Elements:");
        list.forEach(System.out::println);

        System.out.println();
        boolean result = list.remove("lalala");
        System.out.println("Remove \"lalala\" result = " + result);
        result = list.remove("Wednesday");
        System.out.println("Remove \"Wednesday\" result = " + result);

        System.out.println("LinkedList elements size after remove = " + list.size() + ". Elements:");
        list.forEach(System.out::println);

        System.out.println();
        list.removeFirst();
        System.out.println(list.getFirst());
    }

    public void hashSetDemo() {
        HashSet<String> set = new HashSet<>();
        set.add("Beta");
        set.add("Gamma");
        set.add("Delta");
        set.add("Alpha");

        // элементы не хранятся в отсортированном порядке
        set.forEach(s -> System.out.println(s + " hashCode = " + s.hashCode()));
    }

    public void linkedHashSetDemo() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Beta");
        set.add("Gamma");
        set.add("Delta");
        set.add("Alpha");

        // в порядке добавления
        set.forEach(s -> System.out.println(s + " hashCode = " + s.hashCode()));
    }

    public void treeSetDemo() {
        TreeSet<String> set = new TreeSet<>();
        System.out.println("\nTree set:");
        set.add("Beta");
        set.add("Gamma");
        set.add("Delta");
        set.add("Alpha");

        // отсортированный порядок
        set.forEach(System.out::println);

        System.out.println("\nSubset:");
        Set<String> subSet = set.subSet("Beta" , "Gamma");
        System.out.println(subSet);
    }

    public void priorityQueueDemo() {
        Comparator<String> comparator = Comparator.comparing(String::length);

        PriorityQueue<String> queue = new PriorityQueue<>(comparator);
        queue.add("Sasha");
        queue.add("Anastasia");
        queue.add("Anna");
        queue.add("Marina");

        System.out.println("Head = " + queue.peek());
    }

    public void arrayDequeDemo() {
        ArrayDeque<String> deque = new ArrayDeque<>();

        // добавляем объекты e в голову двусторонней очереди
        deque.push("A");
        deque.push("B");
        deque.push("D");
        deque.push("E");
        deque.push("F");

        while (deque.peek() != null) {
            System.out.println(deque.pop()); // возвращает элемент из головы двусторонней очереди, в процессе удаляя его
        }
        System.out.println("deque = " + deque);
    }

    public void hashMapDemo() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Sasha", 27);
        hashMap.put("Anastasia", 25);
        hashMap.put("Anna" , 13);
        hashMap.put("Vladimir" , 72);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Change Anna's value...");
        hashMap.put("Anna" , 14);
        System.out.println("Anna value: " + hashMap.get("Anna"));
    }

    public void treeMapDemo() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Sasha", 27);
        treeMap.put("Anastasia", 25);
        treeMap.put("Anna" , 13);
        treeMap.put("Vladimir" , 72);

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nLower key: " + treeMap.firstEntry().getKey());
        System.out.println("Higher key: " + treeMap.lastEntry().getKey());
        System.out.println(treeMap.tailMap("Sasha"));
    }

    public void linkedHashMapDemo() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(27, "Sasha");
        linkedHashMap.put(14, "Anna");
        linkedHashMap.put(72, "Vladimir");
        linkedHashMap.put(55, "Anastasia");

        System.out.println("LinkedHashMap  = " + linkedHashMap);

        System.out.println("Contains value Sasha = " + linkedHashMap.containsValue("Sasha"));
        System.out.println("Contains key 23 = " + linkedHashMap.containsKey(23));
        System.out.println("Key set = " + linkedHashMap.keySet());
    }

    public void enumMapDemo() {
        EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
        activityMap.put(DayOfWeek.MONDAY, "Football");
        activityMap.put(DayOfWeek.TUESDAY, "Swimming");
        activityMap.put(DayOfWeek.FRIDAY, "Basketball");

        System.out.println("Tuesday's activity is " + activityMap.get(DayOfWeek.TUESDAY));
        System.out.println("Activity map contains Wednesday is " + activityMap.containsKey(DayOfWeek.WEDNESDAY));
    }

    public void enumDemo() {
        System.out.println("Enum Demo");
        System.out.println("CompareTo Monday and Wednesday: " + DayOfWeek.MONDAY.compareTo(DayOfWeek.WEDNESDAY));
        System.out.println("Equals Monday and Tuesday: " + DayOfWeek.MONDAY.equals(DayOfWeek.TUESDAY));
        System.out.println("Declaring class of Monday: " + DayOfWeek.MONDAY.getDeclaringClass());
        System.out.println("Hash code of Friday: " + DayOfWeek.FRIDAY.hashCode());
        System.out.println("Name of Thursday: " + DayOfWeek.THURSDAY.name());
        System.out.println("Number of Sunday: " + DayOfWeek.SUNDAY.ordinal());
        System.out.println("value of \"SATURDAY\":" + DayOfWeek.valueOf("SATURDAY"));
    }

    public void comparatorDemo() {
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str2.compareTo(str1); // обратить сравнение
            }
        };

        // по умолчанию, в TreeSet бъекты хранятся в отсортированном порядке по возрастанию
        TreeSet<String> names = new TreeSet<>(myComparator);
        names.add("Sasha");
        names.add("Anastasia");
        names.add("Vladimir");
        names.add("Anna");
        names.add("Nikita");

        for (String name : names) {
            System.out.println(name);
        }
    }

    public void arraysMethodsDemo() {

        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = -3 * i;

        System.out.print("Array elements: ");
        displayArray(array);

        Arrays.sort(array);
        System.out.print("Array after sorting: " );
        displayArray(array);

        Arrays.fill(array, 2, 6, -1);
        System.out.print("Array after fill: ");
        displayArray(array);

        Arrays.sort(array);
        System.out.print("Array after sorting: ");
        displayArray(array);

        int index = Arrays.binarySearch(array, -9);
        System.out.println("Value -9 on position: " + index);
    }

    private void displayArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void propertiesDemo() {
        Properties capitals = new Properties();
        capitals.setProperty("Russia", "Moscow");
        capitals.setProperty("Germany", "Berlin");
        capitals.setProperty("France", "Paris");
        capitals.setProperty("Finland", "Helsinki");

        Set<?> countries = capitals.keySet();
        for(Object name : countries) {
            System.out.println("Capital of " + name + " is " + capitals.getProperty((String) name));
        }

        String str = capitals.getProperty("Ecuador", "undefined");
        System.out.println("Capital of Ecuador is " + str);
    }
}

