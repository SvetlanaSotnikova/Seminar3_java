import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

public class Seminar3_Lesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task0();

        System.out.print("input size of array: ");
        int size = scanner.nextInt();

        System.out.print("input min interval: ");
        int min = scanner.nextInt();

        System.out.print("input max interval: ");
        int max = scanner.nextInt();

        task1(size, min, max);

        task2();
        task3();

        List<List<String>> list = new ArrayList<>();
        char end = '/';
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.print("input name of book: ");
            String name = scanner.nextLine();
            System.out.print("input genre of book: ");
            String genre = scanner.nextLine();

            System.out.print("Continue? (y/n): ");
            String userInput = scanner.next().charAt(0) + "";
            scanner.nextLine();

            if (userInput.equalsIgnoreCase("N") || userInput.charAt(0) == end) {
                continueLoop = false;

            }
            task4(name, genre, list);
            System.out.println(list);
        }

        scanner.close();
    }

    static void task0() {
        // Даны следующие строки, cравнить их с помощью == и
        // метода equals() класса Object
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[] { 'h', 'e', 'l', 'l', 'o' });

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
        System.out.println(s5 == s6);

        System.out.println();
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s4));
        System.out.println(s4.equals(s5));
        System.out.println(s5.equals(s6));
    }

    static void task1(int size, int min, int max) {
        // Заполнить список десятью случайными числами.
        // Отсортировать список методом sort() и вывести его на
        // экран.

        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(min, max + 1));
        }
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }

    static void task2() {
        // task_2.1
        // Заполнить список названиями планет Солнечной
        // системы в произвольном порядке с повторениями.
        // Вывести название каждой планеты и количество его
        // повторений в списке.

        ArrayList<String> planets = new ArrayList<>();
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");
        planets.add("Земля");
        planets.add("Плутон");
        planets.add("Уран");
        planets.add("Плутон");
        planets.add("Нептун");
        planets.add("Сатурн");
        planets.add("Юпитер");
        planets.add("Юпитер");
        planets.add("Марс");
        planets.add("Земля");

        // String currentPlanet = planets.get(0);
        // int count = 1;

        // for (int i = 0; i < planets.size(); i++) {
        // if (planets.get(i).equals(currentPlanet)) {
        // count++;
        // } else {
        // System.out.println("Planet: " + currentPlanet + "\t\tcount of repetitions: "
        // + count);
        // currentPlanet = planets.get(i);
        // count = 1;
        // }
        // }
        // System.out.println("Planet: " + currentPlanet + "\t\tcount of repetitions: "
        // + count);
        Map<String, List<String>> planetMap = new HashMap<>();

        for (String planet : planets) {
            if (!planetMap.containsKey(planet)) {
                planetMap.put(planet, new ArrayList<>());
            }
            planetMap.get(planet).add(planet);
        }

        for (Map.Entry<String, List<String>> entry : planetMap.entrySet()) {
            System.out.println("Planet: " + entry.getKey() + "\t\tcount of repetitions: " + entry.getValue().size());
        }

        // task_2.2
        // Пройти по списку из предыдущего задания и удалить
        // повторяющиеся элементы.
        Iterator<String> iterator = planets.iterator();
        HashSet<String> uniqueEl = new HashSet<>();

        while (iterator.hasNext()) {
            String planet = iterator.next();

            if (!uniqueEl.add(planet)) {
                iterator.remove();
            }
        }
        System.out.println("Updated list: \n" + planets);

    }

    static void task3() {
        // Создать список типа ArrayList<String>.
        // Поместить в него как строки, так и целые числа.
        // Пройти по списку, найти и удалить целые числа

        ArrayList list = new ArrayList<>();
        list.add(1);
        list.add("wew");
        list.add("er");
        list.add(23.43);
        list.add(32);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();

            if (o instanceof Integer) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    static void task4(String name, String genre, List<List<String>> bookshop) {
        // Каталог товаров книжного магазина сохранен в виде двумерного
        // списка List<ArrayList<String>> так, что на 0й позиции каждого
        // внутреннего списка содержится название жанра, а на остальных
        // позициях - названия книг. Напишите метод для заполнения данной
        // структуры.

        for (int i = 0; i < bookshop.size(); i++) {
            if (bookshop.get(i).get(0).equals(genre)) {
                bookshop.get(i).add(name);
                return;
            }
        }
        List<String> collection_book = new ArrayList<>();
        collection_book.add(genre);
        collection_book.add(name);
        bookshop.add(collection_book);
    }
}
