package com.hackerrank.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/icecream-parlor
 */

public class IceCreamParlor {
	
	/*
	 * Not efficient..Misunderstood the problem.
	 */
	
	
	private static int checkIfOtherExists(List<Integer> priceList, int value,int left,int right) {

       if(left>right){
    	   return -1;
       }
       
       int mid= left+((right-left)/2);
       
       if(priceList.get(mid)==value){
    	   return mid;
       }
		
       if(value < priceList.get(mid)){
    	   return checkIfOtherExists(priceList,value,left,mid-1);
       }else{
    	   return checkIfOtherExists(priceList,value,mid+1,right);
       }
	}

	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		int tc= scanner.nextInt();
		for(int i=0;i<tc;i++){
			int m=scanner.nextInt();
			int n= scanner.nextInt();
			//int[] priceList=new int[n];
			int low=0;
			int high=0;
			List<Integer> priceList=new ArrayList<Integer>();
			List<Integer> list=new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				int next= scanner.nextInt();
				list.add(next);
				if( (low==0 && high==0 )|| (next<low || next > high)){
					Collections.sort(priceList);
					int value=checkIfOtherExists(priceList,m-next,0,priceList.size()-1);
					if(value!=-1){
						low= Math.min(next, Math.abs(m-next));
						high=Math.max(next, Math.abs(m-next));
						priceList.remove(value);
					}else{
						priceList.add(next);
					}
				}
			}				
			
			int lowPos=list.indexOf(low)+1;
			int highPos=list.indexOf(high)+1;
			if(low==high){
				highPos=list.subList(lowPos, list.size()).indexOf(high)+1+lowPos;
			}
			System.out.println(Math.min(lowPos, highPos)+" "+Math.max(lowPos, highPos));
		}
		
	}


	

}
