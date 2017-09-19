package com.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/priyanka-and-toys
 */

public class PriyankaandToys {
	
	private static void findMinimumToys(int[] arr, int n) {
		Arrays.sort(arr);
		int count=1;		
		int prevWeight=arr[0];
		for(int i=1;i<n;i++){			
			if(arr[i]>prevWeight+4){
				prevWeight= arr[i];
				count++;
			}
			
		}
		System.out.println(count);
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scanner.nextInt();
		}	
		findMinimumToys(arr,n);
		scanner.close();		
	}

	
}
