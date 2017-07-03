package com.hackerrank.algorithm.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
	
	/*	  
	 * https://www.hackerrank.com/challenges/extra-long-factorials	  
	 */
	
	private static BigInteger factorial(int num) {		
		BigInteger bigNum=BigInteger.valueOf(num);
		for(int i=num-1;i>0;i--){
			bigNum= bigNum.multiply(BigInteger.valueOf(i));			
		}
		return bigNum;
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int num=scanner.nextInt();
		System.out.println(factorial(num));
	}	

}
