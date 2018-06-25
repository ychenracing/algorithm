/**
 * ychen.
 * Copyright (c) 2018年4月19日.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author racing
 * @version $Id: E1TwoSum.java, v 0.1 2018年4月19日 上午11:32:18 racing Exp $
 */
public class E1TwoSum {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {1, 3, 5, 7, 8, 14, 15}, 13)));
    }
    
    /**
     * find two sum in non-sorted integer array
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if (map.containsKey(complete)) {
                return new int[] {map.get(complete), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
    
    /**
     * find two sum in sorted integer array
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumSorted(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j;) {
            if (nums [i] == target - nums[j]) {
                return new int[] {i, j};
            }
            if (nums [i] <= target - nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {};
    }

}
