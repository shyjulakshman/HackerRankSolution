package com.hackerrank.algorithm.implementation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TheGridSearch {
	
	/*
	 * https://www.hackerrank.com/challenges/the-grid-search
	 */

	private static String isPatternAvailable(StringBuffer matrix, String[] pattern, int c) {
        boolean isAvailable =false;
        int patternLength=pattern[0].length();
        int skipPos=c-patternLength+1;
        StringBuffer regex=new StringBuffer();        
        for(int i=0;i<pattern.length;i++){
        	regex.append(pattern[i]);
        	if(i!=pattern.length-1){
        		regex.append("[0-9-]{"+skipPos+"}");
        	}
        } 
              
        Pattern ptn= Pattern.compile(regex.toString());
        Matcher matcher= ptn.matcher(matrix.toString());
        if(matcher.find()){
        	isAvailable=true;
        }		
		return isAvailable?"YES":"NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int a0 = 0; a0 < t; a0++){
			int R = in.nextInt();
			int C = in.nextInt();
			StringBuffer matrix= new StringBuffer();    
			for(int G_i=0; G_i < R; G_i++){	
				matrix.append(in.next());
				matrix.append("-");
			}
			 
			int r = in.nextInt();
			int c = in.nextInt();

			String[] P = new String[r];
			for(int P_i=0; P_i < r; P_i++){						
				P[P_i]=in.next();
			}
			System.out.println(isPatternAvailable(matrix,P,C));
		}

	}





}
