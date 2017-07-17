package com.hackerrank.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemSolving {
	
	/*
	 * Incorrect solution
	 */
	
	
	/*public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases =scanner.nextInt();
		for(int i=0;i<noOfTestCases;i++){
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			List<Integer> list =new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				int next=scanner.nextInt();
				updateArr(list,next,k);				
			}
			System.out.println(list.size());
		}
	}

	private static void updateArr(List<Integer> list, int next,int k) {			
		for(int i=0;i<list.size();i++){
			int value= list.get(i);
			if(Math.abs(value-next)>=k){
				list.set(i,next);				
				return;
			}
		}
		list.add(next);		
	}
*/
}
