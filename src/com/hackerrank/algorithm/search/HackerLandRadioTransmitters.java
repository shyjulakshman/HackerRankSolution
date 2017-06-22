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
	

	
	private static int findFarthestHouseWithinRange(int k, int[] x,int cur) {
		int house=cur;
		for(int i=k; i>=0;i--){
			house= cur+i;			
			if(isHousePresent(house,x,0,x.length-1)){
				return house;
			}
		}
		return house;
	}
	
	private static int findNextHouse(int farHouse, int k, int[] x) {
		int house=farHouse+k;
		while(house <= x[x.length-1]){
			house ++; 
			if(isHousePresent(house,x,0,x.length-1)){
				return house;
			}
		}
		return house;
	}


	private static int findTrasmitterCount(int[] x, int k, int n, int curHouse,int lastHouse) {
		int count=0;
		
		if(curHouse==lastHouse){
			return 1;
		}
		
		while(curHouse<lastHouse){
			int farHouse= findFarthestHouseWithinRange(k,x,curHouse);
			count++;
			
			curHouse = findNextHouse(farHouse,k,x);
			
			if(curHouse==lastHouse){
				return count+1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];		
		for(int x_i=0; x_i < n; x_i++){
			x[x_i] = in.nextInt();			
		}
		Arrays.sort(x); 
		System.out.println(findTrasmitterCount(x,k,n,x[0],x[n-1]));
	}




}
