package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class BirthdayChocolate {
	
	static int solveNew(int n, int[] s, int days, int month){
		int sum=0;
		int count=0;
		for(int i=0;i<s.length;i++){
			sum += s[i];
			if(count==month){
				count=count-1;
			}
		}
		return 0;
	}
	
	static int solve(int n, int[] s, int days, int month){
        int i=0;        
        int noOfDays=0;
        if(month>s.length){
        	return 0;
        }
         
        if(s.length == month){
        	for(int k=0;k<s.length;k++){
        		noOfDays+= s[k];
        	}
        	if(noOfDays==days){
        		return 1;
        	}else{
        		return 0;
        	}        	
        }
        while(i <= s.length-month){
          int count=0;          
          for(int j=i;j<=(i+month-1);j++){
             count +=s[j];
          }
          if(count==days){
            noOfDays++;
          }
          i++;
        }
      return noOfDays;        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }

}
