package com.hackerrank.algorithm.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BetweenTwoSets {

	public static int gcdForN(int[] a){

		int res = a[0];
		for(int i=1;i<a.length;i++){
			res= gcd(res, a[i]);
		}
		return res;
	}

	public static int gcd(int a,int b){
		int max = Math.max(a,b);
		int min= Math.min(a, b);

		if(max%min==0)return min;
		int rem=0;

		while(max%min!=0){
			rem= max%min;
			if(rem!=0){
				min =rem;
				max = min;
			}
		}
		return min;
	}

	static int getTotalX(int[] a, int[] b){
        int gcd= gcdForN(b);        
        int count=0;
        Set<Integer> set = new HashSet<Integer>();
        set.add(gcd);
        boolean isMultiple= true;
        for(int i=0;i<a.length;i++){
        	if(gcd%a[i]!=0){        		
        		isMultiple=false;
        	}else{
        		int val= gcd/a[i];
        		set.add(val);
        		while(val%2==0){
        			set.add(val);
        			val=val/2;
        		}
        	}
        	
        }
        if(isMultiple){
        	count=set.size();
        }
        return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for(int b_i=0; b_i < m; b_i++){
			b[b_i] = in.nextInt();
		}
		int total = getTotalX(a, b);
		System.out.println(total);
	}

}
