package com.hackerrank.algorithm.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/missing-numbers
 */
public class MissingNumbers {
	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		
		int an=scanner.nextInt();
		HashMap<Integer,Integer> hMap= new HashMap<Integer,Integer>();
		for(int i=0;i<an;i++){
			int a =scanner.nextInt();
			if(hMap.containsKey(a)){
				hMap.put(a, hMap.get(a)+1);
			}else{
				hMap.put(a, 1);
			}
		}
		int bn=scanner.nextInt();
		for(int i=0;i<bn;i++){
			int b =scanner.nextInt();
			if(hMap.containsKey(b)){
				hMap.put(b, hMap.get(b)-1);
			}
		}
		scanner.close();
	}

}
