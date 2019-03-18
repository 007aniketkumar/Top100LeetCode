/**
 * 
 * You're given strings J representing the types of stones that are jewels, and S 
 * representing the stones you have.  Each character in S is a type of stone you have.  
 * You want to know how many of the stones you have are also jewels.

	The letters in J are guaranteed distinct, and all characters in J and S are letters. 
	Letters are case sensitive, so "a" is considered a different type of stone from "A".

	Example 1:

	Input: J = "aA", S = "aAAbbbb"
	Output: 3
	
	Example 2:

	Input: J = "z", S = "ZZ"
	Output: 0
	
Note:

	S and J will consist of letters and have length at most 50.
	The characters in J are distinct.
 
 */
package com.ani.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aniket
 *
 */
public class JewelsandStones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		String jewels = "aA";
		String stones = "aAAbbbb";
		System.out.println(numJewelsInStones(jewels,stones));
	}
	
	
    public  static int numJewelsInStones1(String J, String S) {

    	char[]jewels = J.toCharArray();
    	char[] stones = S.toCharArray();
    	int count=0;
    	
    	for(int i=0;i<jewels.length;i++) {
    	
    		for(int j=0;j<stones.length;j++) {
    			if(jewels[i]==stones[j])
    				count ++;
    		}
    	}

    	
    return count;}
    
    
    //The above solution has mn time complexity, this is not ideal this 
    //can be solved using a hashset instead
    
    public  static int numJewelsInStones(String J, String S) {

    	int count=0;
    	Set setofJewels = new HashSet();

    	char[]jewels = J.toCharArray();
    	for(char jewel : jewels)
    	setofJewels.add(jewel);

    	char[] stones = S.toCharArray();
    	
    	//put all the stones in a hashset
    	for(char stone:stones) {
    		if(setofJewels.contains(stone)) {
    			count++;
    		}
    	}
    	
    	
    	
    return count;}
}
