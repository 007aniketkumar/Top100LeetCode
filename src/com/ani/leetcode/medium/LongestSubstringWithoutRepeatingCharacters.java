/**
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 */
package com.ani.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aniket
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count = lengthOfLongestSubstring("pwwkew");
		System.out.println(count);
	}
	
	
public static int lengthOfLongestSubstring(String s) {
        int count =0;
	Map<String, Integer> characters = new HashMap<String,Integer>();
	for(int i=0,j=0;i<s.length();i++) {//double pointers; pointer i will iterate over the characters and j will take care of count
		if(characters.containsKey(String.valueOf(s.charAt(i)))) {//if the character has already been read.
			//for example at pwwkew
			//why Math.max, check the case abba
			j=Math.max(j, characters.get(String.valueOf(s.charAt(i)))+1);//this is to get the first repetition position , so that you know that you should start from the next point
		}
		
		System.out.println("s.charAt(i)" + s.charAt(i));
		characters.put(String.valueOf(s.charAt(i)),i);
		count = Math.max(count, i-j+1);
		
	}
	

    return count;}

}
