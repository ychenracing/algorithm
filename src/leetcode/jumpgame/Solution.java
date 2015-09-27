package leetcode.jumpgame;

public class Solution {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 4 };
        canJump(nums);
        System.out.println(canJump2(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        int interval = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < interval) {
                interval++;
                continue;
            } else {
                interval = 1;
            }
        }
        if (interval > 1)
            return false;
        return true;
    }

    public static boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int jump = nums[i] + i;
            max = jump > max ? jump : max;
        }
        if (max >= nums.length - 1)
            return false;
        return true;
    }
}
