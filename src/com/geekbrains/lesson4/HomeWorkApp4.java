package com.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {
    private static final int SIZE = 5;
    private static final int WIN_LENGTH = 4;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '*';
    private static char map[][];
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        for (; ; ) {
            humanTurn();
            printMap();
            if (isWinner(DOT_X)) {
                System.out.println("Вы победили!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            computerTurn();
            printMap();
            if (isWinner(DOT_O)) {
                System.out.println("AI победил!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }
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

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCeil(x, y));
        map[x][y] = DOT_X;
    }

    private static boolean isValidCeil(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Неверные координаты.");
            return false;
        }
        return map[x][y] == DOT_EMPTY;
    }

    private static void computerTurn() {
        int x;
        int y;
        System.out.println("Ход AI");
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
            System.out.printf("AI ввел координаты %d %d\n", x + 1, y + 1);
        } while (!isValidCeil(x, y));
        map[x][y] = DOT_O;
    }

    private static boolean isMapFull() {
        for (char[] i : map) {
            for (char j : i) {
                if (j == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isWinner(char ch) {
        return isWinLine(ch) || isWinColumn(ch) || isWinDiagonal(ch);
    }

    private static boolean isWinLine(char ch) {
        boolean flag = false;
        for (int i = 0; i < SIZE; i++) {
            int numbers = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == ch) {
                    numbers++;
                    if (numbers == WIN_LENGTH) {
                        flag = true;
                        break;
                    }
                } else {
                    numbers = 0;
                }
            }
        }
        return flag;
    }

    private static boolean isWinColumn(char ch) {
        boolean flag = false;
        for (int i = 0; i < SIZE; i++) {
            int numbers = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == ch) {
                    numbers++;
                    if (numbers == WIN_LENGTH) {
                        flag = true;
                        break;
                    }
                } else {
                    numbers = 0;
                }
            }
        }
        return flag;
    }

    private static boolean isWinDiagonal(char ch) {
        boolean winDiag = false;
        for (int c = 0; c <= SIZE - WIN_LENGTH; c++) {
            for (int d = 0; d <= SIZE - WIN_LENGTH; d++) {
                if (checkStraightDiagonal(ch, c, d) || checkReverseDiagonal(ch, c, d)) {
                    winDiag = true;
                }
            }
        }
        return winDiag;
    }

    private static boolean checkStraightDiagonal(char ch, int c, int d) {
        boolean flag = false;
        int straightNum = 0;
        for (int i = 0; i < WIN_LENGTH; i++) {
            if (map[i + c][i + d] == ch) {
                straightNum++;
                if (straightNum == WIN_LENGTH) {
                    flag = true;
                    break;
                }
            } else {
                straightNum = 0;
            }
        }
        return flag;
    }

    private static boolean checkReverseDiagonal(char ch, int c, int d) {
        boolean flag = false;
        int straightNum = 0;
        for (int i = 0, j = SIZE - 1; i < WIN_LENGTH; i++, j--) {
            if (map[i + c][j - d] == ch) {
                straightNum++;
                if (straightNum == WIN_LENGTH) {
                    flag = true;
                    break;
                }
            } else {
                straightNum = 0;
            }
        }
        return flag;
    }
}
