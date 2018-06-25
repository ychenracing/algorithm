/**
 * ychen. Copyright (c) 2018年6月25日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E303RangeSumQueryImmutable.java, v 0.1 2018年6月25日 下午2:51:37 racing Exp $
 */
public class E303RangeSumQueryImmutable {
    
    private int[] sums = null;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        E303RangeSumQueryImmutable i = new E303RangeSumQueryImmutable(nums);
        System.out.println(i.sumRange(0,2));
        System.out.println(i.sumRange(2,5));
        System.out.println(i.sumRange(0,5));
    }

    public E303RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
