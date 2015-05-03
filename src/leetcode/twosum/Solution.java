package leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum  
 *  //non-sorted 
 * 
 * <pre>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * 
 * Output: index1=1, index2=2
 * </pre>
 * 
 * @author racing
 * @since 05-03-2015
 *
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	Integer firstIndex, interval;
    	for(int i = 0; i < nums.length; i++){
    		firstIndex = map.get(nums[i]);
    		if(firstIndex == null) map.put(nums[i], i);
    		interval = target - nums[i];
    		firstIndex = map.get(interval);
    		
    		if(firstIndex != null && firstIndex < i){
    			System.out.println("index1 = " + (++firstIndex) + ", index2 = " + (++i));
    			return new int[]{firstIndex, i};
    		}
    	}
		return null;
    }
    
    public static void main(String[] args){
    	Solution solution = new Solution();
    	int[] numbers = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
    	int target = 542;
    	solution.twoSum(numbers, target);
    }
}