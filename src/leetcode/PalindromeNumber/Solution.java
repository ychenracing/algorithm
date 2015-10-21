package leetcode.PalindromeNumber;

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 1. 负数不是回文数字
     * 2. 个位为0的不是回文数字
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        x = Math.abs(x);
        int right = 0;
        if (x % 10 == 0)
            return false;
        while (right < x) {
            int remainder = x % 10;
            x /= 10;
            right = right * 10 + remainder;
            if (right > x)
                return false;
            if (right == x)
                return true;
            if (x >= 10) {
                if (right == x / 10) {
                    return true;
                }
            }
        }
        return false;
    }

}
