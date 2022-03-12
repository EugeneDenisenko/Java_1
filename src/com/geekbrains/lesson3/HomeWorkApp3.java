package com.geekbrains.lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {

        replaceOneZero();
        System.out.println("-----");

        createArray(100);
        System.out.println("-----");

        getDoubleLowSix();
        System.out.println("-----");

        fillDiagonalSquare(9);
        System.out.println("-----");

        int[] newArray;
        newArray = createArrayInit(7, 777);
        System.out.println(Arrays.toString(newArray));
        System.out.println("-----");

        findMinMax();
        System.out.println("-----");

        int[] a = {1, 2, 3, 4, 5, 15};
        int[] b = {3, 2, 1, 7};
        int[] err = {1};
        System.out.println(checkSumLeftRight(a));
        System.out.println(checkSumLeftRight(b));
        System.out.println(checkSumLeftRight(err));
        System.out.println("-----");

        int[] shift = {0, 1, 2, 3, 4, 5, 6, 7};
        displaceElements(shift, 11);
    }

    private static void replaceOneZero() {
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
    }

    private static void createArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void getDoubleLowSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void fillDiagonalSquare(int len) {
        int[][] square = new int[len][len];
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
    }

    private static int[] createArrayInit(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    private static void findMinMax() {
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

    private static void displaceElements(int[] array, int num) {
        System.out.println(Arrays.toString(array));
        if (num == array.length | num == 0) {
            System.out.println("Смещения не производится.");
        } else {
            if (Math.abs(num) > array.length) {
                int n = Math.abs(num) % array.length;
                if (num > 0) {
                    getShift(array, n);
                } else {
                    getShift(array, -n);
                }
            } else {
                getShift(array, num);
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void getShift(int[] array, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int finalElement = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = finalElement;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                int firstElement = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = firstElement;
            }
        }
    }
}
