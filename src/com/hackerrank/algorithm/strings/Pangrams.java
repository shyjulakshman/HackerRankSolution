package com.hackerrank.algorithm.strings;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pangrams {
	
	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);
		List<Character> list =new ArrayList<Character>();
		String str= scanner.nextLine();		
		boolean isPangram=false;
		for(Character c:str.toCharArray()){
			Character lower =Character.toLowerCase(c);
			if(!list.contains(lower) && !lower.equals(' ')){
				list.add(lower);
			}
			if(list.size()==26){
				isPangram=true;
				break;
			}						
		}
		if(isPangram){
			System.out.println("pangram");
		}else{
			System.out.println("not pangram");
		}
		scanner.close();
	}

}
