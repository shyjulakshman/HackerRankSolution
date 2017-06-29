package com.hackerrank.algorithm.recursion;

import java.util.HashMap;
import java.util.Scanner;

public class PowerSum {
	
	/* 
	 * https://www.hackerrank.com/challenges/the-power-sum
	 */
	
	private static long findWays(long num, long curNum, int pow,HashMap<String,Long> hMap) {
						
		long valueWithTemp= 0;
		long ways=0;		
		
		if(num==0){
			return 1;
		}
		
		if(Math.pow(curNum, pow) > num){
			return 0;
		}
		
		String key = num+"-"+curNum;
		if(hMap.containsKey(key)){
			return hMap.get(key);
		}
		
		long i=curNum;
		
		while(valueWithTemp <= num){
			long remaining = num-valueWithTemp;			
			ways += findWays(remaining,i+1,pow,hMap);			
			valueWithTemp += Math.pow(i, pow);
			i++;
		}		
		
		hMap.put(key, ways);
		return ways;
	}
	
	
	
	
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int pow= scanner.nextInt();		
		System.out.println(findWays(num,1,pow,new HashMap<String,Long>()));
		
	}

	

}
