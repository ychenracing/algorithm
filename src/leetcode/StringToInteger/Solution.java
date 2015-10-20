package leetcode.StringToInteger;

public class Solution {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        int result = 0;
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == ' ')
                index++;
            else
                break;
        }
        int sign = 1;
        int up = Integer.MAX_VALUE / 10;
        if (index < str.length()) {
            if (str.charAt(index) == '-')
                sign = -1;
            if (str.charAt(index) == '-' || str.charAt(index) == '+')
                index++;
            while (index < str.length()) {
                if (str.charAt(index) == ' ') {
                    index++;
                    continue;
                }
                if (Character.isDigit(str.charAt(index))) {
                    int cur = str.charAt(index) - '0';
                    if (result > up) {
                        return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    } else if (result == up) {
                        if (sign > 0) {
                            if (cur >= 7)
                                return Integer.MAX_VALUE;
                        } else {
                            if (cur >= 8)
                                return Integer.MIN_VALUE;
                        }
                    }
                    result = result * 10 + cur;
                    index++;
                    continue;
                }
                break;
            }
        }
        return result * sign;
    }
}
