package com.hackerrank.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerisGreater {
	
	/*
	 * https://www.hackerrank.com/challenges/bigger-is-greater	 
	 */
	
	private static String alphabet= " abcdefghijklmnopqrstuvwxyz";
	
	private static int getPos(char c){
		return alphabet.indexOf(c);		
	}
	
	private static String nextLexGreater(String str) {
		int length = str.length();
		char[] arr= str.toCharArray();
		int i=length-1;
		boolean flag=false;
		while(i > 0){		    
			if(getPos(arr[i]) > getPos(arr[i-1])){				
				int pos=i;
				//find value > arr[i] < arr[i-1]
				for(int k=i+1;k<length;k++){
					if(getPos(arr[k])>getPos(arr[i-1]) && getPos(arr[k])< getPos(arr[i])){
						pos=k;
					}
				}				
				//swap
				char temp=arr[i-1];
				arr[i-1]=arr[pos];
				arr[pos]=temp;
				flag=true;				
				Arrays.sort(arr,i,arr.length);				
				break;
			}
			i--;
		}		
		return flag?String.valueOf(arr):"no answer";
	}	
	

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		for(int i=0;i<n;i++){
			String str= scanner.next();
			System.out.println(nextLexGreater(str));
		}
	}

}
