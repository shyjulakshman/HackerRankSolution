package com.hackerrank.algorithm.search;

import java.util.Scanner;

public class SherlockandArray {
	
	 static String solve(int[] a){
	       int mid= a.length/2;
	       return "";
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        for(int a0 = 0; a0 < T; a0++){
	            int n = in.nextInt();
	            int[] a = new int[n];
	            for(int a_i=0; a_i < n; a_i++){
	                a[a_i] = in.nextInt();
	            }
	            String result = solve(a);
	            System.out.println(result);
	        }
	        in.close();
	    }

}
