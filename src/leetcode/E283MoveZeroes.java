/**
 * ychen. Copyright (c) 2018年6月25日.
 */
package leetcode;

import java.util.Arrays;

/**
 * 
 * @author racing
 * @version $Id: E283MoveZeroes.java, v 0.1 2018年6月25日 上午10:04:07 racing Exp $
 */
public class E283MoveZeroes {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 4, 0, 5, 6, 0, 0, 0, 23, 45, 56, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] != 0) i++;
            while (j < i || j < nums.length && nums[j] == 0) j++;
            if (i >= nums.length || j >= nums.length) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j++] = temp;
        }
    }

}
