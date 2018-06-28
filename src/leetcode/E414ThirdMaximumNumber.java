/**
 * ychen. Copyright (c) 2018年6月28日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E414ThirdMaximumNumber.java, v 0.1 2018年6月28日 下午4:03:32 racing Exp $
 */
public class E414ThirdMaximumNumber {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] { 1, -20, 2 }));
    }

    public static int thirdMax(int[] nums) {
        boolean desc = false;
        int max = nums[0], secondary = nums[0], third = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max || nums[i] == secondary || nums[i] == third) {
                continue;
            }
            if (!desc) {
                if (nums[i] > third) {
                    if (nums[i] > secondary) {
                        if (secondary != max) {
                            secondary = max;
                        }
                        max = nums[i];
                    } else {
                        secondary = nums[i];
                    }
                } else {
                    if (max == secondary || secondary == third) {
                        if (max == secondary) {
                            secondary = third;
                        }
                        third = nums[i];
                    }
                }
                if (max != secondary && secondary != third) {
                    desc = true;
                }
            } else {
                if (nums[i] > third) {
                    if (nums[i] > secondary) {
                        third = secondary;
                        if (nums[i] > max) {
                            secondary = max;
                            max = nums[i];
                        } else {
                            secondary = nums[i];
                        }
                    } else {
                        third = nums[i];
                    }
                }
            }
        }
        if (third == secondary || secondary == max)
            return max;
        return third;
    }

}
