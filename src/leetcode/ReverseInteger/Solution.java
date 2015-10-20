package leetcode.ReverseInteger;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        if (x == 0)
            return x;
        int up = Integer.MAX_VALUE / 10;

        int pn = x > 0 ? 1 : -1;
        x = Math.abs(x);

        int num = 0;
        while (x > 0) {
            int remainder = x % 10;
            x /= 10;
            if (num == up) {
                if (pn > 0) {
                    if (remainder >= 7)
                        return Integer.MAX_VALUE;
                } else {
                    if (remainder >= 8)
                        return Integer.MIN_VALUE;
                }
            }
            if (num > up) {
                return pn > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + remainder;
        }
        return num * pn;
    }
}
