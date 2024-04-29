// 1. Создайте HashSet, заполните его следующими числами: {5, 3, 1, 5, 18, 2, 10}.
// Распечатайте содержимое данного множества.
// 2. Создайте LinkedHashSet, заполните его следующими числами: {5, 3, 1, 5, 18, 2, 10}. 
//Распечатайте содержимое данного множества.
// 3. Создайте TreeSet, заполните его следующими числами: {5, 3, 1, 5, 18, 2, 10}.
// Распечатайте содержимое данного множества.

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExamples {
    public static void main(String[] args) {
        // Создание и заполнение HashSet
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 1, 5, 18, 2, 10));
        System.out.println(hashSet);
        System.out.println();

        // Создание и заполнение LinkedHashSet
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(5, 3, 1, 5, 18, 2, 10));
        System.out.println(linkedHashSet);
        System.out.println();

        // Создание и заполнение TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 3, 1, 5, 18, 2, 10));
        System.out.println(treeSet);
        System.out.println();
    }
}