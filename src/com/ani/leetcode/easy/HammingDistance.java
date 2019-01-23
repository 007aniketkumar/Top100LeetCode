/**
 * The Hamming distance between two integers is the number of positions at which the 
 * corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
package com.ani.leetcode.easy;

/**
 * @author aniket
 *
 */
public class HammingDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hammingDistance(1,5));
	}
	
    public  static int hammingDistance(int x, int y) {
    	int binaryX = 0;
    	int binaryY = 0;
    	
    	//convert to binary
    	int hammingDistance =0;
    	int higherNumber = Math.max(x,y);
    	int lowerNumber = Math.min(x, y);
    while(higherNumber!=0) {
    	binaryX=higherNumber%2;
    	higherNumber= higherNumber/2;
    	binaryY=(lowerNumber<1)?0:lowerNumber%2;
    	lowerNumber=lowerNumber/2;
    	System.out.println("binaryX:" +binaryX +"binaryY: "+ binaryY);
    	if(binaryX!=binaryY)
    		hammingDistance++;
    }
    	
    	
    	
    	 return hammingDistance;
    }
}
