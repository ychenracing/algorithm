/**
 * ychen. Copyright (c) 2018年6月19日.
 */
package leetcode;

import java.util.Arrays;

/**
 * 
 * @author racing
 * @version $Id: E189RotateArray.java, v 0.1 2018年6月19日 下午7:34:55 racing Exp $
 */
public class E189RotateArray {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Accepted
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (k >= nums.length)
            k %= nums.length;
        if (k == 0)
            return;
        int totalCount = maxMove(nums.length, k);
        for (int i = 0; i < totalCount; i++) {
            int start = i;
            int target = (start + k) % nums.length;
            int cur = nums[start];
            while (target != i) {
                int temp = nums[target];
                nums[target] = cur;
                cur = temp;
                start = target;
                target = (target + k) % nums.length;
            }
            nums[target] = cur;
        }
    }

    private static int maxMove(int a, int b) {
        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        int re = a % b;
        while (re != 0) {
            a = b;
            b = re;
            re = a % b;
        }
        return b;

    }

}
