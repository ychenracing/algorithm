package companies.didichuxing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输出一个矩阵的所有2*2的子矩阵中，和最大的那个子矩阵的和。
 * @author racing
 * @version $Id: MaxSubMatrix.java, v 0.1 Sep 25, 2015 9:57:22 PM racing Exp $
 */
public class MaxSubMatrix {

    private static int row = 0, column = 0;

    public static void main(String[] args) {
        getMaxSubMatrix();
    }

    public static int[][] getInput() {
        int[][] nums = new int[1000][1000];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            br.close();
        } catch (IOException e) {
        }

        String[] lines = input.split(";");
        column = lines.length;
        int i = 0;
        for (String line : lines) {
            int j = 0;
            String[] numItems = line.split("\\s");
            row = numItems.length;
            for (String item : numItems) {
                if (item != null && !item.equals(""))
                    nums[i][j++] = Integer.parseInt(item);
            }
            i++;
        }
        return nums;
    }

    public static void getMaxSubMatrix() {
        int[][] nums = getInput();
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int temp = nums[i][j] + nums[i + 1][j] + nums[i][j + 1] + nums[i + 1][j + 1];
                if (temp > sum)
                    sum = temp;
            }
        }
        System.out.println(sum);
    }
}
