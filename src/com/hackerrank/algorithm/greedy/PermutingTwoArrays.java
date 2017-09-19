package com.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/two-arrays
 */

public class PermutingTwoArrays {
	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		int q=scanner.nextInt();
		for(int i=0;i<q;i++){
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			Integer[] a=new Integer[n];
			Integer[] b=new Integer[n];
			for(int j=0;j<n;j++){
				a[j]=scanner.nextInt();				
			}
			for(int j=0;j<n;j++){
				b[j]=scanner.nextInt();				
			}
			if(isPermutationExists(a,b,n,k)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		scanner.close();
	}

	private static boolean isPermutationExists(Integer[] a, Integer[] b, int n, int k) {
		Arrays.sort(a);		
		Arrays.sort(b, Collections.reverseOrder());
		boolean flag=true;
		for(int i=0;i<n;i++){
			if(a[i]+b[i]<k){
				flag=false;
				break;
			}
		}
		return flag;			
	}

}
