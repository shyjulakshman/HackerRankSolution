package com.hackerrank.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainers {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int n = in.nextInt();
	            int[][] M = new int[n][n];
	            int [] ballsCountInContainer = new int[n];	           
	            int[] typeOfBallsCount= new  int[n];
	            Arrays.fill(typeOfBallsCount, 0);
	            for(int M_i=0; M_i < n; M_i++){
	            	int ballCount=0;
	                for(int M_j=0; M_j < n; M_j++){
	                    M[M_i][M_j] = in.nextInt();
	                    ballCount += M[M_i][M_j];
	                    if(M_j==(n-1)){
	                    	ballsCountInContainer[M_i]=ballCount;
	                    }	                 
	                    typeOfBallsCount[M_j]=typeOfBallsCount[M_j]+  M[M_i][M_j];	                 
	                }
	            }
	            Arrays.sort(ballsCountInContainer);
	            Arrays.sort(typeOfBallsCount);
	            boolean possible=true;
	            for(int i=0;i<n;i++){
	            	if(ballsCountInContainer[i]!=typeOfBallsCount[i]){
	            		possible=false;
	            		break;
	            	}
	            }
	            System.out.println(possible?"Possible":"Impossible");
	            
	        }
	    }

}
