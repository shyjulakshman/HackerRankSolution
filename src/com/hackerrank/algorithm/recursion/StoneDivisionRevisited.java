package com.hackerrank.algorithm.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/stone-division-2
 */

public class StoneDivisionRevisited {	
	
	
	private static long findMaximumMoves(long pile, List<Long> set,HashMap<Long,Long> hMap) {	
		if(hMap.containsKey(pile)){
			return hMap.get(pile);
		}
		long maxCount=0;
		for(int i=0;i<set.size();i++){		
			 maxCount=0;
			long setV= set.get(i);
			if(pile!=setV && pile%setV==0){
				maxCount++;		
				long noOfSplits= pile / setV;
				maxCount= maxCount+ noOfSplits * findMaximumMoves(setV,set, hMap);	
				if(hMap.containsKey(pile)){
					if(maxCount>=hMap.get(pile)){
						hMap.put(pile, maxCount);						
					}else{
						maxCount=hMap.get(pile);
					}						
				}else{
					hMap.put(pile, maxCount);					
				}
			}
		}
		
		
		return maxCount;
	}
	

	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);
		int noOfTestCases=scanner.nextInt();

		for(int i=0;i<noOfTestCases;i++){
			long pile=scanner.nextLong();
			int sizeOfSet= scanner.nextInt();		
			List<Long> set= new ArrayList<Long>();
			for(int j=0;j<sizeOfSet;j++){
				set.add(scanner.nextLong());
			}

			Collections.sort(set,Collections.reverseOrder());
			HashMap<Long,Long> hMap=new HashMap<Long,Long>();

			System.out.println(findMaximumMoves(pile,set,hMap));
		}


	}



}
