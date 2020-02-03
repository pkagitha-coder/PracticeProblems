package org.abc;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        rotateMartix(matrix);

        Util.printMatrix(matrix);
    }

    private static void rotateMartix(int[][] matrix) {
        final int N = matrix.length;
        int n = N-1;
        for(int r = 0; r< N /2; r++) {
            for(int c = r; c< n -r; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n-c][r];
                matrix[n-c][r] = matrix[n-r][n-c];
                matrix[n-r][n-c] = matrix[c][n-r];
                matrix[c][n-r] = tmp;
            }
        }

    }
}
