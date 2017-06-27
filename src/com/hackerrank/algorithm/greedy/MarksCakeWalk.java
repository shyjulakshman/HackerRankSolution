package com.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarksCakeWalk {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] calories = new int[n];
	        for(int calories_i=0; calories_i < n; calories_i++){
	            calories[calories_i] = in.nextInt();
	        }
	        Arrays.sort(calories);
	        
	        int cupCakesEaten=0;
	        long miles=0;	
	        int index=0;
	        for(int i=(n-1);i>=0;i--){	        	
	        	miles= miles + (calories[i] *(long)Math.pow(2,cupCakesEaten));
	        	cupCakesEaten++;
	        }
	        System.out.println(miles);

	    }

}
