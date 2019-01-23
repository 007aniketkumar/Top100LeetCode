/**
 * n a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?

Example:

	Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    Output: 35
	Explanation: 
	The grid is:
		[ [3, 0, 8, 4], 
  		  [2, 4, 5, 7],
          [9, 2, 6, 3],
          [0, 3, 1, 0] ]

	The skyline viewed from top or bottom is: [9, 4, 8, 7]
	The skyline viewed from left or right is: [8, 7, 9, 3]

The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

Notes:

	1 < grid.length = grid[0].length <= 50.
	All heights grid[i][j] are in the range [0, 100].
	All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism.
 * 
 * 
 */

package com.ani.leetcode.medium;

import java.util.Arrays;

/**
 * @author aniket
 *
 */
public class MaxSkyLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//create a 2 D array first
		
		int [][]grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

		//int [][]grid = {{3,0,4},{2,5,7},{9,6,3}};
		/*
		 * [3 0 4]
		 * [2 5 7]
		 * [9 6 3]
		 * 
		 * 
		 * maxRows = [4 7 9]
		 * maxColumns=[9 6 7]
		 * 
		 * 
		 * 
		 */
		System.out.println(maxIncreaseKeepingSkyline(grid));
		//System.out.println(grid.length);//will tell the number of rows
		//print the contents
		
		/*for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.println(grid[i][j]);
			}
		}*/
		
		
	}
	
	
    public static int maxIncreaseKeepingSkyline(int[][] grid) {

    	//iterate over the grid and find the maximum value at row=column
    	//find max
    	int maxColumns[] = new int[grid[0].length];int k=0;int r=0;int max;
    	int maxRows[] = new int[grid.length];
    	
    	int columnLength =  grid[0].length;
    	
    	for(int i=0;i<grid.length;i++) {
    		max=0;
    		for(int j=0;j<grid[i].length;j++) {
    			//find the maximum in every row
    			max = Math.max(max, grid[i][j]);
    		}
    		maxRows[k++] = max;
    	}
    	
    	for(int col=0;col<columnLength;col++) {
    		max=0;
    		for(int j=0;j<grid.length;j++) {
    			max = Math.max(max, grid[j][col]);

    		}
    		maxColumns[r++]=max;
    	}
    	
Arrays.stream(maxRows).forEach(row-> System.out.println(row));
System.out.println("columns"+ maxColumns[0]);
Arrays.stream(maxColumns).forEach(col->System.out.println(col));

//let's iterate over the array and do an inplace swap
int sum =0;
for(int row=0;row<grid.length;row++) {
	for(int col=0;col<grid[row].length;col++) {
		
		sum  =  sum + Math.min(maxColumns[col], maxRows[row]) - grid[row][col];
	}
}


    return sum;}
}
