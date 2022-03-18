package com.geekbrains.lesson4;

public class HomeWorkApp4 {
    private static final int SIZE = 3;
    private static final char DOT_X = 'X';
    private static final char DOT_Y = 'Y';
    private static final char DOT_EMPTY = '*';
    private static char map[][];

    public static void main(String[] args) {
        initMap();
        printMap();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
