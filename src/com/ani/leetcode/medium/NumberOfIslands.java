/**
 * 
 */
package com.ani.leetcode.medium;

import java.util.Stack;

/**
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * 
 * 
 * 
 * 
 * 
 * @author aniket
 *
 */
public class NumberOfIslands {

	static char[][] grid = new char[4][5];//initial problem
	
	public static void main(String[] args) {
		
	
		initializeGrid();
		System.out.println(numIslands(grid));
	}
	
	
	
	
	//create a matrix which represents the islands
	/*
	 * 
	 * 
	 * 11110
	   11010
	   11000
	   00000
	 */
	
	static void initializeGrid() {
		/*grid[0][0] ='1';
		grid[0][1] ='1';
		grid[0][2] ='1';
		grid[0][3] ='1';
		grid[0][4] ='0';
		
		grid[1][0] ='1';
		grid[1][1] ='1';
		grid[1][2] ='0';
		grid[1][3] ='1';
		grid[1][4] ='0';

		grid[2][0] ='1';
		grid[2][1] ='1';
		grid[2][2] ='0';
		grid[2][3] ='0';
		grid[2][4] ='0';

		grid[3][0] ='0';
		grid[3][1] ='0';
		grid[3][2] ='0';
		grid[3][3] ='0';
		grid[3][4] ='0';*/
		
		
		
		
		/*
		 * 
		 * 	11000
			11000
			00100
			00011
		 */


		
		
		grid[0][0] ='1';
		grid[0][1] ='1';
		grid[0][2] ='0';
		grid[0][3] ='0';
		grid[0][4] ='0';
		
		grid[1][0] ='1';
		grid[1][1] ='1';
		grid[1][2] ='0';
		grid[1][3] ='0';
		grid[1][4] ='0';

		grid[2][0] ='0';
		grid[2][1] ='0';
		grid[2][2] ='1';
		grid[2][3] ='0';
		grid[2][4] ='0';

		grid[3][0] ='0';
		grid[3][1] ='0';
		grid[3][2] ='0';
		grid[3][3] ='1';
		grid[3][4] ='1';
		

	}
	
	
	
	
	
	
	public static int numIslands(char[][] grid) {
       
	//iterate on the array and check if the 	
	
		int numberofIslands =0;
		
		
		//iterate over each row , and check if the position is 1, 
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]=='1') {
					islandFound(i,j);
					numberofIslands++;
				}
			}
		}
		
		
    return numberofIslands;}
	
	
	static void islandFound(int i, int j){
		
		Stack<Integer> rows = new Stack<>(); 
		Stack<Integer> columns = new Stack<>();
		//iterate and check if the island exists
		
		
		rows.push(i);
		columns.push(j);
		grid[i][j]=0;

		
		while(!rows.isEmpty() && !columns.isEmpty()) {
		
			
			//Initialize the current node as visited , by marking it as 0, and 
			//check if any of the four valid sides around it are 1 and can be pushed to stack
			
			i= rows.pop();
			j=columns.pop();
			
		
			
			//going up
			if((i-1)>=0 && grid[i-1][j]=='1') {
				
				System.out.println("going up");
				rows.push(i-1);
				columns.push(j);
				grid[i-1][j]=0;
			}
			//going down
			if((i+1)<grid.length && grid[i+1][j]=='1') {
				System.out.println("going down");
				rows.push(i+1);
				columns.push(j);	
				grid[i+1][j]=0;

				} 
			//going left
			if((j-1)>=0 && grid[i][j-1]=='1') {
				System.out.println("going left");
				rows.push(i);
				columns.push(j-1);
				grid[i][j-1]=0;

			}
			
			//going right
			if((j+1)<grid[i].length && grid[i][j+1]=='1') {
				
				System.out.println("going right");
				rows.push(i);
				columns.push(j+1);
				grid[i][j+1]=0;

			}
			
		}
	}

	
	
	
}
