package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return checkHorizontal(board) || checkVertical(board);
    }

    public static boolean checkHorizontal(int[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (board[0][i] == 1) {
                for (int j = 0; j < size; j++)
                    if (board[j][i] != 1) {
                        return false;
                    }
                return true;
            }
        }
        return false;
    }

    public static boolean checkVertical(int[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (board[i][0] == 1) {
                for (int j = 0; j < size; j++)
                    if (board[i][j] != 1) {
                        return false;
                    }
                return true;
            }
        }
        return false;
    }
}
