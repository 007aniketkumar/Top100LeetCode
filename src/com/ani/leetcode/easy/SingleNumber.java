/**
 * 
 */
package com.ani.leetcode.easy;

/**
 * @author aniket
 *
 *Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

 *
 *
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int input[] = {4,1,2,1,2};
		System.out.println(singleNumber(input));
	}
	
	public  static int singleNumber(int[] nums) {
        int singleNumber=nums[0];
        if(nums.length==1) {
        	return singleNumber;
        }
		for(int i=1;i<nums.length;i++) {
			//Magic of XOR 
			singleNumber = nums[i]^singleNumber;
		}
    return singleNumber;}

}
