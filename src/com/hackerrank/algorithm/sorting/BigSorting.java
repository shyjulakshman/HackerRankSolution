package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/big-sorting
 */

public class BigSorting {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();             
        
        String[] list = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
        	list[unsorted_i]=in.next();
        }
        Arrays.sort(list,new Comparator<String>(){

			@Override
			public int compare(String str1, String str2) {
				if(str1.length()!=str2.length()){
					return str1.length()-str2.length();
				}else{
					return str1.compareTo(str2);
				}
			}
        	
        });
        
        
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
        	sb.append(list[i]);
        	sb.append("\n");        	
        }        
        System.out.println(sb.toString());
    }

}
