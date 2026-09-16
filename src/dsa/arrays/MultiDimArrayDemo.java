package dsa.arrays;

import java.util.Arrays;

public class MultiDimArrayDemo {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        //printWavePattern(matrix);
        //transposeOfMatrix(matrix);

        int[][] a = {{1,2,3},{4,5,6}};
        int[][] b = {{1,4},{2,5},{3,6}};
        multiplyMatrix(a, b);
    }

    // Print wave pattern
    // if even col number print top to bottom
    // else print bottom to top
    static void printWavePattern(int[][] matrix) {
        for (int c = 0; c < matrix[0].length; c++) {
            if (c % 2 == 0) {
                // print downwards
                for (int r = 0; r < matrix.length; r++) {
                    System.out.print(matrix[r][c] + " ");
                }
            } else {
                // print upwards
                for (int r = matrix.length - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c] + " ");
                }
            }
        }

        System.out.println();
    }

    // transpose of matrix
    // interchange rows to cols
    // matrix[x][y] = matrix[y][x]
    static void transposeOfMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] transpose = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }

        for (int i = 0; i < c; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }
    }

    // matrix multiplication
    static void multiplyMatrix(int[][] a, int[][] b) {
        int r1 = a.length, c1 = a[0].length;
        int r2 = b.length, c2 = b[0].length;

        int[][] ans = new int[r1][c2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    int temp = a[i][k] * b[k][j];
                    sum += temp;
                }

                ans[i][j] = sum;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
