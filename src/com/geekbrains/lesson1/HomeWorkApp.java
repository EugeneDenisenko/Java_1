package com.geekbrains.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println("-----");
        checkSumSign();
        System.out.println("-----");
        printColor();
        System.out.println("-----");
        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 5;
        int b = -7;
        if ((a + b) >= 0) System.out.println("Сумма положительная.");
        else System.out.println("Сумма отрицательная.");
    }

    private static void printColor() {
        int value = 7;
        if (value <= 0) System.out.println("Красный");
        else if (value > 0 & value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    private static void compareNumbers() {
        int a = 777;
        int b = -555;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
