package com.hackerrank.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

public class HackerLandRadioTransmitters {

	
	private static boolean isHousePresent(int val,int[] x,int left, int right) {
		//Binary search

		if(left > right){
			return false;
		}						
		int mid= left + ((right-left)/2);
		if(val==x[mid]){
			return true;
		}
		if( val< x[mid]){
			return isHousePresent(val,x,left,mid-1);			
		}else{
			return isHousePresent(val,x,mid+1,right);
		}		
	}

	private static int findTrasmitterCount(int[] x, int k, int n, int min,
			int max) {
		int count=0;

		while(min<max){						
			int kk =k;			
			while(kk!=0){
				int val = min + kk;
				if(isHousePresent(val,x,0, x.length-1)){
					count++;
					min= val+kk+1;
					while(min<max && !isHousePresent(min,x,0,x.length-1)){
						min=min+1;						
					}
					if(min==max){
						return count+1;
					}
					if(min>max){
						return count;
					}
					break;
				}
				kk--;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int x_i=0; x_i < n; x_i++){
			x[x_i] = in.nextInt();
			if(x[x_i]<min){
				min= x[x_i];
			}
			if(x[x_i]>max){
				max= x[x_i];
			}
		}
		Arrays.sort(x); 
		System.out.println(findTrasmitterCount(x,k,n,min,max));
	}




}
