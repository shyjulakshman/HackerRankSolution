package com.hackerrank.algorithm.greedy;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/largest-permutation
 */

public class LargestPermutation {
	
	private static void findLargestPermutation(int[] arr, int[] index,int n, int k) {
		int i=0;
		int noOfSwaps=0;
		while(noOfSwaps<k && i<n){	
			int maxIndex=index[n-i];			
			
			if(i!=maxIndex){
				int temp=arr[i];
				arr[i]=arr[maxIndex];
				arr[maxIndex]=temp;
				index[arr[maxIndex]]=maxIndex;
				index[arr[i]]=i;
				noOfSwaps++;
			}		
			i++;
		}
		for(int j=0;j<n;j++){
			System.out.print(arr[j]+" ");
		}
	}
	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] arr= new int[n];
		int[] index=new int[n+1];
		for(int i=0;i<n;i++){
			arr[i]=scanner.nextInt();
			index[arr[i]]=i;
		}
		findLargestPermutation(arr,index,n,k);
		scanner.close();
	}



}
