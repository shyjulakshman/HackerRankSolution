package com.hackerrank.algorithm.dp;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 
 * https://www.hackerrank.com/challenges/abbr
 */

public class Abbreviation {
	private static boolean isAbbreviation(String a, String b) {
		HashMap<Character,Integer> hMapb = new HashMap<Character,Integer>();
		HashMap<Character,Integer> hMapA = new HashMap<Character,Integer>();
		
		for(char c:a.toCharArray()){
			if(hMapA.containsKey(c)){
				hMapA.put(c, hMapA.get(c)+1);
			}else{
				hMapA.put(c, 1);
			}
		}
		boolean flag=true;
		for(Character c: b.toCharArray()){
			Character lowerC= Character.toLowerCase(c);
			if(hMapA.containsKey(c) && hMapA.get(c)>0){
				hMapA.put(c,hMapA.get (c)-1);
			}else if(hMapA.containsKey(lowerC) && hMapA.get(lowerC)>0){
				hMapA.put(lowerC,hMapA.get(lowerC)-1);
			}else{
				flag=false;
				break;
			}
		}
		
		if(flag){
			String s="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for(char c:s.toCharArray()){
				if(hMapA.containsKey(c)&& hMapA.get(c)>0){
					flag=false;
				}
			}
		}
		return flag;
		
	}
	
	public static void main(String args[]){
		
		Scanner scanner =new Scanner(System.in);
		int q=scanner.nextInt();
		for(int i=0;i<q;i++){
			String a= scanner.next();
			String b=scanner.next();
			if(isAbbreviation(a,b)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
		scanner.close();
		
	}

	

}
