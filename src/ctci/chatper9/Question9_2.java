package ctci.chatper9;

import java.util.Arrays;
import java.util.Random;

public class Question9_2 {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[][] matrix = new int[9][10];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 0);
        }

        // 模拟出障碍
        for (int i = 0; i < 10; i++) {
            int row = random.nextInt(9);
            int column = random.nextInt(10);
            matrix[row][column] = 2;
        }

        print(matrix);

        System.out.println();
        System.out.println();

        if (getSum(matrix, 0, 0, 9, 10))
            print(matrix);
        else
            System.out.println("There is no any path!");

    }

    /**
     * 找出一条从左上到右下的路径
     * @param matrix
     * @param row
     * @param column
     * @param sumRow
     * @param sumColumn
     * @return
     */
    public static boolean getSum(int[][] matrix, int row, int column, int sumRow, int sumColumn) {
        if (row == sumRow || column == sumColumn || matrix[row][column] == 2)
            return false;

        if (row + 1 == sumRow && column + 1 == sumColumn) {
            matrix[row][column] = 1;
            return true;
        }

        if (getSum(matrix, row, column + 1, sumRow, sumColumn)) {
            matrix[row][column] = 1;
            return true;
        } else if (getSum(matrix, row + 1, column, sumRow, sumColumn)) {
            matrix[row][column] = 1;
            return true;
        }

        return false;
    }

    /**
     * 打印出该矩阵
     * @param matrix
     */
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                if (j + 1 == matrix[i].length)
                    System.out.println();
            }
        }
    }
}
