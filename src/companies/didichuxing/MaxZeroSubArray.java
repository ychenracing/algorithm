package companies.didichuxing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入整数数组，数字为负数、正数、零，要求输出最长的和为0的子数组。
 * <pre>
 * input: 1 2 3 4 5 -1 -2 -3 -4 -5 6 -6 7 8 -9 -6 0 10 2
 * output: 1 2 3 4 5 -1 -2 -3 -4 -5 6 -6 7 8 -9 -6 0
 * </pre>
 * @author racing
 * @version $Id: MaxZeroSubArray.java, v 0.1 Sep 25, 2015 9:55:30 PM racing Exp $
 */
public class MaxZeroSubArray {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            br.close();
        } catch (IOException e) {
        }

        String[] numString = input.split("\\s");
        int[] nums = new int[numString.length];
        for (int i = 0; i < numString.length; i++) {
            nums[i] = Integer.parseInt(numString[i]);
        }

        getZero(nums, nums.length);
    }

    public static void getZero(int[] nums, int n) {
        int sum[] = new int[n];

        sum[0] = nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];

        int maxInterval = 0, startIndex = 0, endIndex = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0, j = n - 1; i <= j;) {

            if (sum[i] == 0 && i > maxInterval) {
                startIndex = 0;
                endIndex = i;
                maxInterval = i;
            }

            if (sum[j] == 0 && j > maxInterval) {
                startIndex = 0;
                endIndex = j;
                maxInterval = j;
            }
            if (map.containsKey(sum[i])) {
                int end = map.get(sum[i]);
                int start = i + 1;
                if (end - start > maxInterval) {
                    startIndex = start;
                    endIndex = end;
                    maxInterval = end - start - 1;
                }
            }
            map.put(sum[i], i);
            i++;

            if (map.containsKey(sum[j])) {
                int start = map.get(sum[j]) + 1;
                int end = j;

                if (end - start > maxInterval) {
                    startIndex = start;
                    endIndex = end;
                    maxInterval = end - start - 1;
                }
            }
            map.put(sum[j], j);
            j--;
        }

        for (int k = startIndex; k <= endIndex; k++) {
            System.out.print(nums[k] + " ");
        }
    }
}
