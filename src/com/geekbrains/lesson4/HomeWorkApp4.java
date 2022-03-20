package com.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {
    private static final int SIZE = 3;
    private static final int WIN_LENGTH = 3;
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
            if (isWinner(DOT_X, WIN_LENGTH)) {
                System.out.println("Вы победили!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            computerTurn();
            printMap();
            if (isWinner(DOT_O, WIN_LENGTH)) {
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

//    private static void computerTurn() {            Версия хода AI без логики блокировки хода человеку.
//        int x;
//        int y;
//        System.out.println("Ход AI");
//        do {
//            x = random.nextInt(SIZE);
//            y = random.nextInt(SIZE);
//            System.out.printf("AI ввел координаты %d %d\n", x + 1, y + 1);
//        } while (!isValidCeil(x, y));
//        map[x][y] = DOT_O;
//    }

    private static void computerTurn() {
        int x = 0;
        int y = 0;
        int[] line, column, straightDiagonal, reverseDiagonal;
        boolean move = false;
        System.out.println("Ход AI");
        if (map[Math.round(SIZE - 1) / 2][Math.round(SIZE - 1) / 2] == DOT_EMPTY) {
            map[Math.round(SIZE - 1) / 2][Math.round(SIZE - 1) / 2] = DOT_O;
            move = true;
            System.out.printf("AI ввел координаты %d %d\n", x + 1, y + 1);
        }
        if (isWinLine(DOT_X, 2) & !move) {
            line = blockLine();
            x = line[0];
            y = line[1];
            if (isValidCeil(x, y)) {
                map[x][y] = DOT_O;
                move = true;
                System.out.printf("AI мешает по строке - %d %d\n", x + 1, y + 1);
            }
        }
        if (isWinColumn(DOT_X, 2) & !move) {
            column = blockColumn();
            x = column[0];
            y = column[1];
            if (isValidCeil(x, y)) {
                map[x][y] = DOT_O;
                move = true;
                System.out.printf("AI мешает по столбцу - %d %d\n", x + 1, y + 1);
            }
        }
        if (isWinDiagonal(DOT_X, 2) & !move) {
            straightDiagonal = blockStraightDiagonal();
            x = straightDiagonal[0];
            y = straightDiagonal[1];
            if (isValidCeil(x, y)) {
                map[x][y] = DOT_O;
                move = true;
                System.out.printf("AI мешает по прямой диагонали - %d %d\n", x + 1, y + 1);
            }
        }
        if (isWinDiagonal(DOT_X, 2) & !move) {
            reverseDiagonal = blockReverseDiagonal();
            x = reverseDiagonal[0];
            y = reverseDiagonal[1];
            if (isValidCeil(x, y)) {
                map[x][y] = DOT_O;
                move = true;
                System.out.printf("AI мешает по обратной диагонали - %d %d\n", x + 1, y + 1);
            }
        }
        if (!move) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
                System.out.printf("AI ввел рандомно координаты - %d %d\n", x + 1, y + 1);
            } while (!isValidCeil(x, y));
            map[x][y] = DOT_O;
        }
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

    private static boolean isWinner(char ch, int WIN_LENGTH) {
        return isWinLine(ch, WIN_LENGTH) || isWinColumn(ch, WIN_LENGTH) || isWinDiagonal(ch, WIN_LENGTH);
    }

    private static boolean isWinLine(char ch, int WIN_LENGTH) {
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

    private static boolean isWinColumn(char ch, int WIN_LENGTH) {
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

    private static boolean isWinDiagonal(char ch, int WIN_LENGTH) {
        boolean winDiag = false;
        for (int c = 0; c <= SIZE - WIN_LENGTH; c++) {
            for (int d = 0; d <= SIZE - WIN_LENGTH; d++) {
                if (checkStraightDiagonal(ch, c, d, WIN_LENGTH) || checkReverseDiagonal(ch, c, d, WIN_LENGTH)) {
                    winDiag = true;
                }
            }
        }
        return winDiag;
    }

    private static boolean checkStraightDiagonal(char ch, int c, int d, int WIN_LENGTH) {
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

    private static boolean checkReverseDiagonal(char ch, int c, int d, int WIN_LENGTH) {
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

    private static int[] blockLine() {
        int count = 0;
        int column = 0;
        int[] line = new int[2];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    count++;
                    if (count == 2) {
                        column = j;
                        line[0] = i;
                        break;
                    }
                }
            }
            count = 0;
        }
        if (column == 2) {
            line[1] = 0;
        } else if (column == 1) {
            line[1] = 2;
        }
        return line;
    }

    private static int[] blockColumn() {
        int count = 0;
        int line = 0;
        int[] column = new int[2];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_X) {
                    count++;
                    if (count == 2) {
                        line = j;
                        column[1] = i;
                        break;
                    }
                }
            }
            count = 0;
        }
        if (line == 2) {
            column[0] = 0;
        } else if (line == 1) {
            column[0] = 2;
        }
        return column;
    }

    private static int[] blockStraightDiagonal() {
        int ceil = 0;
        int straightNum = 0;
        int[] straightDiagonal = new int[2];
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == DOT_X) {
                straightNum++;
                if (straightNum == 2) {
                    ceil = i;
                    break;
                }
            } else {
                straightNum = 0;
            }
        }
        if (ceil == 1) {
            straightDiagonal[0] = 2;
            straightDiagonal[1] = 2;
        }
        return straightDiagonal;
    }

    private static int[] blockReverseDiagonal() {
        int ceil = 0;
        int straightNum = 0;
        int[] reverseDiagonal = new int[2];
        for (int i = 0, j = SIZE - 1; i < WIN_LENGTH; i++, j--) {
            if (map[i][j] == DOT_X) {
                straightNum++;
                if (straightNum == 2) {
                    ceil = i;
                    break;
                }
            } else {
                straightNum = 0;
            }
        }
        if (ceil == 1) {
            reverseDiagonal[0] = 2;
            reverseDiagonal[1] = 0;
        } else if (ceil == 2) {
            reverseDiagonal[0] = 0;
            reverseDiagonal[1] = 2;
        }
        return reverseDiagonal;
    }
}