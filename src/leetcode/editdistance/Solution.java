package leetcode.editdistance;

public class Solution {
    public static int[][] minDistance(String word1, String word2) {
        //        if (word2 == null || word2.length() == 0)
        //            return word1.length();
        //        if (word1 == null || word1.length() == 0)
        //            return word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] result = new int[chars1.length][chars2.length];

        result[chars1.length - 1][chars2.length - 1] = chars1[chars1.length - 1] == chars2[chars2.length - 1] ? 0
            : 1;
        boolean flag = false;
        for (int i = chars1.length - 2; i >= 0; i--) {
            if (chars1[i] == chars2[chars2.length - 1]) {
                if (!flag) {
                    result[i][chars2.length - 1] = result[i + 1][chars2.length - 1];
                    flag = true;
                } else {
                    result[i][chars2.length - 1] = result[i + 1][chars2.length - 1] + 1;
                }
            } else
                result[i][chars2.length - 1] = result[i + 1][chars2.length - 1] + 1;
        }

        flag = false;
        for (int i = chars2.length - 2; i >= 0; i--) {
            if (chars2[i] == chars1[chars1.length - 1]) {
                if (!flag) {
                    result[chars1.length - 1][i] = result[chars1.length - 1][i + 1];
                    flag = true;
                } else {
                    result[chars1.length - 1][i] = result[chars1.length - 1][i + 1] + 1;
                }
            } else
                result[chars1.length - 1][i] = result[chars1.length - 1][i + 1] + 1;
        }

        for (int i = chars1.length - 2; i >= 0; i--) {
            for (int j = chars2.length - 2; j >= 0; j--) {
                if (chars1[i] == chars2[j])
                    result[i][j] = result[i + 1][j + 1];
                else {
                    result[i][j] = Math.min(1 + result[i + 1][j],
                        Math.min(1 + result[i + 1][j + 1], 1 + result[i][j + 1]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        print(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopical"));
    }

    public static void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(String.format("%2d", nums[i][j]) + " ");
                if (j == nums[i].length - 1)
                    System.out.println();
            }
        }
    }
}
