/**
 * ychen. Copyright (c) 2018年6月20日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E198HouseRobber.java, v 0.1 2018年6月20日 上午9:37:12 racing Exp $
 */
public class E198HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2};
        System.out.println(rob(nums));
    }

    /**
     * Accepted
     * 
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] sums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int nni = i + 2;
            int ni = i + 1;
            int nn = 0;
            int n = 0;
            if (nni < nums.length) {
                nn = sums[nni];
            }
            if (ni < nums.length) {
                n = sums[ni];
            }
            int count = nn + nums[i];
            sums[i] = count > n ? count : n;
        }
        return sums[0];
    }

}
