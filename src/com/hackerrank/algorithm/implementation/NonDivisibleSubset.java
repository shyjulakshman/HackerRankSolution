package com.hackerrank.algorithm.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonDivisibleSubset {
	
	/*	 
	 * https://www.hackerrank.com/challenges/non-divisible-subset
	 */
	
	//Incorrect solution
	
	public static void isDivisible(List<Integer> subList,int num){
		boolean isDivisible=false;
		if(subList.isEmpty() && num%3!=0){
			subList.add(num);
		}else{
			for(Integer i:subList){
				if((num+i)%3==0){
					isDivisible=true;
					break;
				}
			}
			if(!isDivisible){
				subList.add(num);
			}
		}
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n= scanner.nextInt();
		int k = scanner.nextInt();		
		List<Integer> subList= new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int num=scanner.nextInt();
			isDivisible(subList,num);
		}
		System.out.println(subList.size());
		
	}

}
