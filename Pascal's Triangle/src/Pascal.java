//-Najm Sheikh
//-11/19/14
//-Create a program to populate a two dimensional array with the first 10 rows of Pascal's triangle.

import java.util.Scanner;

class Pascal{
    @SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many rows long should the Pascal triangle be?");
		int rows = sc.nextInt();
        int[][] nums = new int[rows][rows];

        for(int row=0;row<nums.length;row++){
        	nums[row] = new int[row+1];
        	nums[row][0] = 1;
        	nums[row][row] = 1;
        	for (int col=1;col<row;col++) {
        		nums[row][col] = nums[row-1][col-1]+nums[row-1][col];
        	}
        }

        for(int row=0;row<nums.length;row++){
        	for (int col=0;col<nums[row].length;col++) 
        		System.out.format(nums[row][col]+" ");
        	System.out.println("");
        }
	}
}