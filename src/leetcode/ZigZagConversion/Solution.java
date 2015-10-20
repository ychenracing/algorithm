package leetcode.ZigZagConversion;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convert("AB", 3));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2)
            return s;
        if (numRows < 2)
            return s;
        StringBuilder sb = new StringBuilder();
        int n = (int) Math.ceil((double) s.length() / (numRows * 2 - 2));
        int column = (numRows - 1) * n;
        char[][] chars = new char[numRows][column];
        int index = 0, col = 0;
        for (int i = 0; i < n; i++) {
            for (int row = 0; row < numRows && index < s.length(); row++) {
                chars[row][col] = s.charAt(index++);
            }
            for (int row = numRows - 2; row > 0 && index < s.length(); row--) {
                chars[row][++col] = s.charAt(index++);
            }
            col++;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                if (chars[i][j] != '\u0000')
                    sb.append(chars[i][j]);
            }
        }
        return sb.toString();
    }
}
