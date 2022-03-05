package com.geekbrains.lesson2;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        System.out.println(checkingForWithin(-16, 5));
        System.out.println("-----");
        isPositive(13);
        System.out.println("-----");
        System.out.println(checkPositive(-777));
        System.out.println("-----");
        printString("Переданная строка", 5);
        System.out.println("-----");
        System.out.println(isLeapYear(400));
    }

    private static boolean checkingForWithin(int a, int b) {
        if (a + b > 10 & a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void isPositive(int a) {
        if (a >= 0) {
            System.out.printf("Число %d - положительное.", a);
        } else {
            System.out.printf("Число %d - отрицательное.", a);
        }
        System.out.println();
    }

    private static boolean checkPositive(int a) {
        return a >= 0 ? false : true;
    }

    private static void printString(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    private static boolean isLeapYear(int year) {
        if (year <= 0) {
            System.out.println("Check positive number of year.");
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else return false;
    }
}

