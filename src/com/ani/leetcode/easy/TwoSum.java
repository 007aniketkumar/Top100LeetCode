/**
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:

		Given nums = [2, 7, 11, 15], target = 9,

		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
 */
package com.ani.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aniket
 *
 *
 *No duplicates
 *looks sorted
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//int[] nums = {2,7,11,15};
		//int[] nums = {0,4,3,0};
		int[] nums = {-3,4,3,90};

		int target = 0;
		//int []result = twoSum(nums, target);
		int []result = twoSumHashMapBased(nums, target);

		System.out.println(Arrays.toString(result));
		
	}
	
	
	public static int[] twoSum(int[] nums, int target) {
        
        int startIndex = 0;
        int lastIndex =  nums.length-1;
        int result[] = new int[2];
        
        //assuming the array is not sorted
        //before sorting you will have to store the indexes of each number , so that the original index can be returned,else the solution
        //will break , hence let's try out a hashmap based solution
       Arrays.sort(nums);
       System.out.println(Arrays.toString(nums));
        for (int i=0;i<nums.length;i++) {
        
        	if (nums[startIndex] + nums[lastIndex] > target) {
        		lastIndex = lastIndex-1;
        		System.out.println(lastIndex);
        } else if(nums[startIndex] + nums[lastIndex] < target) {
        	startIndex = startIndex+1;
        } else {
        	result[0]= startIndex;
        	result[1]= lastIndex;
        	
        	return result;
        	
        }	    
		
    }return null;
  } 
	

//Accepted solution	
	
public static int[] twoSumHashMapBased(int[] nums, int target) {
        
        
        int result[] = new int[2];
        int difference;
        //sorting of array does not matter
        
Map<Integer,Integer> values_keys = new HashMap<Integer, Integer>();        
       System.out.println(Arrays.toString(nums));
        for (int i=0;i<nums.length;i++) {
        
        //	if(nums[i]<=target) {
        	
        difference = target - nums[i];
        if(values_keys.containsKey(difference) && values_keys.get(difference)!=i) {//not the same index
        	result[0]= i;
        	result[1] =  values_keys.get(difference);
        	return result;
        	}
    	values_keys.put(nums[i],i);
//}
        	
        	
        	 } //if value is not found
        return null;


}

}
