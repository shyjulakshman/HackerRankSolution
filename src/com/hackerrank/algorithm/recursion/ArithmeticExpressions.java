package com.hackerrank.algorithm.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ArithmeticExpressions {
	
	private static boolean findArithmeticExpresssion(int[] arr,int loop,boolean result,int[] ops) {
		long value=arr[0];
		StringBuffer buf=new StringBuffer();
		buf.append(value);
		
		for(int i=1;i<arr.length;i++){			
				if(ops[i-1]==1){
					value= value + arr[i];
					buf.append("+"+arr[i]);
				}else if(ops[i-1]==2){
					value= value - arr[i];
					buf.append("-"+arr[i]);
				}else if(ops[i-1]==3){
					value = value * arr[i];
					buf.append("*"+arr[i]);
				}
		}
		if(value%101==0){			
			result=true;	
			System.out.println(buf.toString());
		}		
		if(!result){
			for(int i=0;i<ops.length;i++){
				long pow = (long)Math.pow(3,i);		
				System.out.println(i+" "+pow);
				long v = loop%pow;
				if(v==0){
					ops[i]=(ops[i]+1)%3==0?ops[i]+1:(ops[i]+1)%3;
				}
			}
			result=findArithmeticExpresssion(arr,loop+1,result,ops);
		}
		return result;		
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scanner.nextInt();
		}
		int[] ops=new int[n-1];
		Arrays.fill(ops, 1);
		findArithmeticExpresssion(arr,1,false,ops);	
		
		for(int i=0;i<2000;i++){
			System.out.println(i+" "+Math.pow(3, i));
		}
	}

	

}
