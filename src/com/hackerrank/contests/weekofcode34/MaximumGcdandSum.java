package com.hackerrank.contests.weekofcode34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MaximumGcdandSum {

	public static class FastReader {

		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static int gcd(int a,int b){	

		BigInteger bigA= new BigInteger(String.valueOf(a));
		BigInteger bigB= new BigInteger(String.valueOf(b));
		BigInteger gcd= bigA.gcd(bigB);		
		return gcd.intValue();
	}	

	//static int maximumGcdAndSum(SortedSet<Integer> A, SortedSet<Integer> B) {
	static int maximumGcdAndSum(List<Integer> A, List<Integer> B) {
		
		Collections.sort(A,Collections.reverseOrder());
		Collections.sort(B,Collections.reverseOrder());

		int maxGCD=0;
		int maxGCDsum=0;
		
		List<Integer> maxList= null;
		List<Integer> minList= null;
		if(A.size()>=B.size()){
			maxList=A;
			minList=B;
		}else{
			maxList=B;
			minList=A;
		}
		
		int i=0;
		while(i<maxList.size()){			
			for(int k=0;k<=i;k++){
				int a= maxList.get(k);
				if(a<maxGCD){
					break;
				}
				int end= i<minList.size()?i:minList.size()-1;
				for(int j=0;j<=end;j++ ){
					int b= minList.get(j);	
					if(b<maxGCD){
						break;
					}
					int gcd=gcd(a,b);
					int gcdSum= a+b;
					if(gcd>=maxGCD){							
						if(gcd>maxGCD || (gcd==maxGCD && gcdSum>maxGCDsum)){
							maxGCDsum=gcdSum;
						}
						maxGCD=gcd;
					}
				}
			}
			i++;			
		}
		return maxGCDsum;
	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		int n = in.nextInt();
		//int[] A = new int[n];
		List<Integer> A = new ArrayList<Integer>();
		//SortedSet<Integer> A= new TreeSet<Integer>(Collections.reverseOrder());
		for(int A_i = 0; A_i < n; A_i++){
			A.add(in.nextInt());
		}
		List<Integer> B = new ArrayList<Integer>();
		//SortedSet<Integer> B = new TreeSet<Integer>(Collections.reverseOrder());
		//int[] B = new int[n];
		for(int B_i = 0; B_i < n; B_i++){
			B.add(in.nextInt());
		}	
		
		
		int res = maximumGcdAndSum(A, B);
		System.out.println(res);

	}

}
