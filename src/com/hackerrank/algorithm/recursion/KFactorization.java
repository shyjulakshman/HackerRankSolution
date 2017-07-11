package com.hackerrank.algorithm.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KFactorization {
	
	/* Incomplete*/

	private static List<Long> findMinPath(long n, List<Long> set) {
		int size= set.size();
		int index=0;
		long value=1;
		int count=0;
		List<Long> result= new ArrayList<Long>();
		//int minResSize=Integer.MAX_VALUE;
		result.add(value);
		
		
		while(value<=n){			
			value = value * set.get(index);
			result.add(value);
			count++;
			if(value==n){
				//if(count<=minResSize){					
					//minResSize=count;
					break;
				//}
			}else if(value>n){
				value=value/set.get(index);
				index++;
				if(!result.isEmpty()){
					result.remove(result.size()-1);
				}
			}
		}

		return result;
	}

	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);
		
		long n=scanner.nextLong();
		int sizeOfSet= scanner.nextInt();		
		List<Long> set= new ArrayList<Long>();
		for(int j=0;j<sizeOfSet;j++){
			set.add(scanner.nextLong());
		}

		Collections.sort(set,Collections.reverseOrder());
		HashMap<Long,Long> hMap=new HashMap<Long,Long>();

		System.out.println(findMinPath(n,set));
	}



}
