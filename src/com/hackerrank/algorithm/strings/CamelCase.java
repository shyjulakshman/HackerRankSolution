package com.hackerrank.algorithm.strings;

import java.util.Scanner;

public class CamelCase {
	
	
	public static void main(String[] args) {
		String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count=0;
        for(char i:s.toCharArray()){
        	if(upperCase.indexOf(String.valueOf(i))>-1){
        		count++;
        	}
        }
        System.out.println(count+1);
    }

}
