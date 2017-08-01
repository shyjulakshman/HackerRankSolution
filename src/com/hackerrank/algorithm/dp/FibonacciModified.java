package com.hackerrank.algorithm.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */

public class FibonacciModified {

	private static BigInteger fibonnaciModified(int n,HashMap<Integer,BigInteger> hMap) {
		if(hMap.containsKey(n)){
			return hMap.get(n);
		}		
		BigInteger bt= fibonnaciModified(n-2,hMap).add((fibonnaciModified(n-1,hMap).pow(2)));
		hMap.put(n, bt);
		return bt;
	}

	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);

		int t1= scanner.nextInt();
		int t2=scanner.nextInt();
		int n=scanner.nextInt();

		HashMap<Integer,BigInteger> hMap = new HashMap<Integer,BigInteger>();
		hMap.put(1, new BigInteger(String.valueOf(t1)));
		hMap.put(2, new BigInteger(String.valueOf(t2)));
		BigInteger bt=fibonnaciModified(n,hMap);				
		System.out.println(bt.toString());
		scanner.close();		
	}

}
