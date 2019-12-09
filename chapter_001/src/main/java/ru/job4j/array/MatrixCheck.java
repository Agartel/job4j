package ru.job4j.array;

public class MatrixCheck {
    public static void printMatrix(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                System.out.print(sign);
            }
            System.out.println();
        }
    }
    public static boolean isWin(char[][] board) {
        boolean result = false;
        int i = 0;
        char sign = 'X';
        while (i < board.length && !result) {
            if (board[i][i] == sign) {
                int direct = (i == 0) ? 1 : -1;
                if (board[i][i+direct] == sign) {
                    for (int index = 0; index < board.length; index++) {
                        if (board[i][index] != sign) {
                            break;
                        }
                        if (index == board.length - 1) {
                            result = true;
                        }
                    }
                } else if (board[i+direct][i] == sign) {
                    for (int index = 0; index < board.length; index++) {
                        if (board[index][i] != sign) {
                            break;
                        }
                        if (index == board.length - 1) {
                            result = true;
                        }
                    }
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        printMatrix(hasWinVertical);
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);

        System.out.println();
        char[][] hasWinVertical2 = {
                {'_', '_', '_', '_', 'X'},
                {'_', '_', '_', '_', 'X'},
                {'_', '_', '_', '_', 'X'},
                {'_', '_', '_', '_', 'X'},
                {'_', '_', '_', '_', 'X'},
        };
        printMatrix(hasWinVertical2);
        boolean win2 = isWin(hasWinVertical2);
        System.out.println("A board has a winner : " + win2);

        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        printMatrix(hasWinHor);
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        printMatrix(notWin);
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);

    }
}