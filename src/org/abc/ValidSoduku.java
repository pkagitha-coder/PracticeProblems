package org.abc;

import java.util.HashSet;
import java.util.Set;

public class ValidSoduku {

    public static void main(String[] args) {
        /*System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));*/

        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean result = true;
        for (int r = 0; r < board.length; r++) {
            if (!validateRow(board, r)) {
                result = false;
                break;
            }
        }

        if (result) {
            for (int c = 0; c < board[0].length; c++) {
                if (!validateColumn(board, c)) {
                    result = false;
                    break;
                }
            }
        }

        if (result) {
            for (int r = 0; r < board.length; r += 3) {
                for (int c = 0; c < board.length; c += 3) {
                    if (!validateGrid(board, r, c)) {
                        result = false;
                        break;
                    }
                }
            }

        }
        return result;
    }

    private static boolean validateGrid(char[][] board, int r, int c) {
        int r1 = r + 3;
        int c1 = c + 3;
        Set<Integer> set = new HashSet<>();
        boolean result = true;
        for (int r2=r; r2 < r1; r2++) {
            for (int c2=c; c2 < c1; c2++) {
                if (!validateCell(board, r2, c2, set)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean validateColumn(char[][] board, int c) {
        Set<Integer> set = new HashSet<>();
        boolean result = true;
        for (int r = 0; r < board.length; r++) {
            if (!validateCell(board, r, c, set)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean validateCell(char[][] board, int r, int c, Set<Integer> set) {
        if (board[r][c] == '.') {
            return true;
        }
        int val = board[r][c] - '0';
        if (val <= 0 || val > 9) {
            return false;
        }
        if (!set.add(val)) {
            return false;
        }
        return true;
    }

    private static boolean validateRow(char[][] board, int r) {
        Set<Integer> set = new HashSet<>();
        boolean result = true;
        for (int c = 0; c < board[r].length; c++) {
            if (!validateCell(board, r, c, set)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
