package com.hackerrank.contests.weekofcode34;
import java.util.Scanner;

public class OnceInaTram {

	static String onceInATram(int x){
		x++;
		while(!isLuckyTicket(x)){
			x++;
		}    	
		return String.valueOf(x);    	
	}

	private static boolean isLuckyTicket(int x) {
		String sX= String.valueOf(x);
		int num[] = new int[sX.length()];
		for (int i = 0; i < sX.length(); i++){
			num[i] = sX.charAt(i) - '0';
		}  
		int firstSum = num[0]+num[1]+num[2];
		int secondSum = num[3]+num[4]+num[5];		

		return (firstSum==secondSum);
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		String result = onceInATram(x);
		System.out.println(result);
	}
}
