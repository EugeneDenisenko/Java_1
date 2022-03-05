package com.geekbrains.lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {

        int[] array1 = {1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else if (array1[i] == 1) {
                array1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array1));
        System.out.println("-----");

        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        System.out.println(Arrays.toString(array2));
        System.out.println("-----");

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array3));
        System.out.println("-----");

        int[][] square = new int[9][9];
        for (int i = 0, j = square.length - 1; i < square.length; i++, j--) {
            square[i][i] = 1;
            square[j][i] = 1;
        }
        for (int[] a : square) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println("-----");

        int[] newArray;
        newArray = createArray(7, 777);
        System.out.println(Arrays.toString(newArray));
        System.out.println("-----");

        int[] numbers = {2121, 3, -5, 0, 876, -88765, 123, -555};
        System.out.println(Arrays.toString(numbers));
        int min = numbers[0];
        int max = numbers[0];
        for (int a : numbers) {
            if (a < min) {
                min = a;
            } else if (a > max) {
                max = a;
            }
        }
        System.out.println("min = " + min + ", max = " + max);
        System.out.println("-----");

        int[] arr = {2, 1, 4, 3, 2, 1, 5, 7, 2, 1, 3, 4, 0};
        int[] a = {1, 2, 3, 4, 5, 15};
        int[] b = {3, 2, 1, 7};
        int[] err = {1};
        System.out.println(checkSumLeftRight(arr));
        System.out.println(checkSumLeftRight(a));
        System.out.println(checkSumLeftRight(b));
        System.out.println(checkSumLeftRight(err));
        System.out.println("-----");

        int[] shift = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(shift));
        getShift(shift, 3);
        getShift(shift, -1);
    }

    private static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    private static boolean checkSumLeftRight(int[] array) {
        boolean flag = false;
        if (array.length < 2) {
            System.out.print("Сравнение невозможно. ");
        }
        int sumLeft = 0;
        int sumRight;
        for (int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            sumRight = 0;
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static void getShift(int[] array, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int fin = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = fin;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                int st = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = st;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
