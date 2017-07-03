package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class TheGridSearch {

	private static String isPatternAvailable(StringBuffer matrix, String[] pattern, int r, int c, int r2, int c2) {
        boolean isAvailable =true;
		for(String p:pattern){
			if(!matrix.toString().contains(p)){				
				isAvailable=false;
				break;
			}else{
				int index= matrix.indexOf(p);
			}
		}
		return isAvailable?"YES":"NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int a0 = 0; a0 < t; a0++){
			int R = in.nextInt();
			int C = in.nextInt();
			// String[] G = new String[R];
			StringBuffer matrix= new StringBuffer();    
			for(int G_i=0; G_i < R; G_i++){
				for(int j=0;j<C;j++){
					//G[G_i] = in.next();
					matrix.append(in.next());
				}
			}
			int r = in.nextInt();
			int c = in.nextInt();

			String[] P = new String[r];
			for(int P_i=0; P_i < r; P_i++){
				StringBuffer pattern= new StringBuffer();
				for(int j=0;j<C;j++){
					//P[P_i] = in.next();
					pattern.append(in.next());
				}
				P[P_i]=pattern.toString();
			}
			System.out.println(isPatternAvailable(matrix,P,R,C,r,c));
		}

	}





}
