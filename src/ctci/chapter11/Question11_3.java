package ctci.chapter11;

/**
 * 有序数组循环右移了n位，在其中查找某个数
 * @author racing
 * @version $Id: Question11_3.java, v 0.1 Oct 6, 2015 12:25:41 PM racing Exp $
 */
public class Question11_3 {

    public static void main(String[] args) {
        int[] nums = { 16, 18, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14, 15 };
        System.out.println(nums.length - 1);
        System.out.println(solve(nums, 0, nums.length - 1, 20));
        System.out.println(solve(nums, 0, nums.length - 1, 11));
        System.out.println(solve(nums, 0, nums.length - 1, 16));
        System.out.println(solve(nums, 0, nums.length - 1, 19));
        System.out.println(solve(nums, 0, nums.length - 1, 15));
        System.out.println(solve(nums, 0, nums.length - 1, 1));
        System.out.println(solve(nums, 0, nums.length - 1, 14));
    }

    public static int solve(int[] nums, int start, int end, int number) {
        if (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == number)
                return middle;
            if (nums[start] <= nums[middle]) { // 左侧递增
                if (nums[start] <= number && number < nums[middle])
                    return solve(nums, start, middle - 1, number);
                else
                    return solve(nums, middle + 1, end, number);
            } else if (nums[start] > nums[middle]) { // 左侧不递增，右侧递增
                if (nums[middle] < number && number <= nums[end])
                    return solve(nums, middle + 1, end, number);
                else
                    return solve(nums, start, middle - 1, number);
            } else if (nums[start] == nums[middle]) { // 左半边都是重复元素
                if (nums[middle] != nums[end])
                    return solve(nums, middle + 1, end, number);
                else {
                    int result = solve(nums, start, middle - 1, number);
                    if (result == -1)
                        return solve(nums, middle + 1, end, number);
                    else
                        return result;
                }
            }
        }
        return -1;
    }
}
