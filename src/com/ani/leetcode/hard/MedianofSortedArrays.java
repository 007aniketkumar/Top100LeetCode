/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
package com.ani.leetcode.hard;

/**
 * @author aniket
 *
 */
public class MedianofSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create 2 arrays
		int[] array1 = { 1, 3 };// 1,2,5,6,7,8
		int[] array2 = { 2 }; // 3,9,10,11- 1,2,3,5,6,7,8,9,10,11

		double median = findMedianSortedArrays(array1, array2);

		System.out.println(median);
	}
	
	/*
	 * 
	 * This solution is pretty bad because of the time it takes which is around O(m+n).
	 * Will share a better version which has log(m+n)
	 */

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int i = 0, j = 0, l = 0;
		int k = nums1.length + nums2.length;
		System.out.println("k :" + k);
		int[] resultArray = new int[k];

		while (nums1.length > i && nums2.length > j) {
			if (nums1[i] < nums2[j]) {
				resultArray[l] = nums1[i];
				System.out.println(nums1[i]);
				i++;
				l++;
			} else {
				resultArray[l] = nums2[j];
				j++;
				l++;

			}
		}

		// check if we reached the end of 1 array
		while (i < nums1.length) {
			resultArray[l] = nums1[i];
			l++;
			i++;
		}

		while (j < nums2.length) {
			System.out.println("j" + j + "nums2[j]" + nums2[j]);

			resultArray[l] = nums2[j];
			l++;
			j++;
		}

		// let's print the content of the sorted array
		for (int m = 0; m < k; m++) {
			System.out.println(resultArray[m]);

		}
		double median;
		if (k % 2 != 0) {
			median = new Double(resultArray[k / 2]);
		} else {

			median = (new Double(resultArray[k / 2 - 1]) + new Double(resultArray[k / 2])) / 2;

		}
		return median;

	}
}
