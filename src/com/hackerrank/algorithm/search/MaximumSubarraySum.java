package com.hackerrank.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarraySum {
	
	private static void findMaxMod(int[] arr,int n,int m) {
		//1 2 3 4 5
		int maxMod=0;
		int[] sum= new int[n+1];
		Arrays.fill(sum, 0);
		for(int i=0;i<n;i++){
			//int mod= arr[i]%m;
			for(int j=1;j<=i+1;j++){
				//if(i>)
			    sum[j] = sum[j]+arr[i];
			}
			
		}
	}
	
	
	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);
		int tc=scanner.nextInt();
		for(int i=0;i<tc;i++){
			int n= scanner.nextInt();
			int m= scanner.nextInt();
			int[] arr = new int[n];
			for(int j=0;j<n;j++){
				int next=scanner.nextInt();
				arr[j]=next;
			}
			findMaxMod(arr,n,m);
		}
	}

	

}
