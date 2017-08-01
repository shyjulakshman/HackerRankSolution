package com.hackerrank.contests.weekofcode34;

import java.util.Scanner;

public class MagicCards {
	
	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);
		int n=scanner.nextInt();
		int back=scanner.nextInt();
		int q=scanner.nextInt();
		
		for(int i=0;i<n;i++){
			int m=scanner.nextInt();
			int[] arr= new int[m];
			for(int j=0;j<m;j++){
				arr[j]=scanner.nextInt();
			}
		}
		scanner.close();
	}
}
