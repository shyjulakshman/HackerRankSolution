package com.hackerrank.algorithm.dp;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 */

public class SherlockAndCost {
	
	private static void findMaxCost(int[] arr) {
		long cost=0;
		int prevValue= arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i] < prevValue){
				cost= cost + Math.abs(prevValue-1);
				prevValue=1;
			}else{
				cost= cost + Math.abs(1-arr[i]);
				prevValue=arr[i];
			}			
		}
		System.out.println(cost);
	}
	
	public static void main(String args[]){
		
		Scanner scanner=new Scanner(System.in);
		int testCases=scanner.nextInt();
		for(int i=0;i<testCases;i++){
			int n= scanner.nextInt();
			int[] arr= new int[n];
			for(int j=0;j<n;j++){
				arr[j]=scanner.nextInt();
			}
			findMaxCost(arr);
		}		
	}

	

}
