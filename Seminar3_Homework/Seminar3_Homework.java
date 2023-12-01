import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Seminar3_Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Merge testMerge = new Merge();
        System.out.print("input size of array: ");
        int size = scanner.nextInt();

        int[] actual = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("input el " + (i + 1) + ": ");
            actual[i] = scanner.nextInt();
        }

        System.out.print("result: ");
        int[] result = task0(actual, actual.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        List<Integer> list_task1 = new ArrayList<>();
        System.out.println("\n\nВведите целые числа для заполнения списка (для завершения введите нецелое число):");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            list_task1.add(number);
        }

        System.out.println();
        System.out.println("main list: " + list_task1);
        task1(list_task1);

        scanner.next(); // ВАЖНО

        List<Integer> list_task2 = new ArrayList<>();
        System.out.println("\nВведите целые числа для заполнения списка (для завершения введите нецелое число):");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            list_task2.add(number);
        }
        System.out.println();       
        task2(list_task2);

        scanner.close();
    }

    static int[] task0(int[] array, int length) {
        // Реализовать алгоритм сортировки слиянием
        // length = array.length;
        if (length < 2) {
            return array;
        }

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < length; i++) {
            right[i - middle] = array[i];
        }
        task0(left, middle);
        task0(right, length - middle);
        mergeSort(array, left, right, middle, length - middle);
        return array;
    }

    static void mergeSort(int[] array, int[] left, int[] right, int start, int end) {

        int i = 0, j = 0, k = 0;
        while (i < start && j < end) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < start) {
            array[k++] = left[i++];
        }
        while (j < end) {
            array[k++] = right[j++];
        }
    }

    static void task1(List<Integer> list) {
        // Пусть дан произвольный список целых чисел, удалить из него четные числа
        list.removeIf(number -> number % 2 == 0);
        System.out.println("result: " + list);
    }

    static void task2(List<Integer> list) {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и
        // среднее из
        // этого списка.
        int min = Collections.min(list);
        int max = Collections.max(list);

        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        double middle = (double) sum / list.size();
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.printf("Average: %.2f", middle);
    }
}
