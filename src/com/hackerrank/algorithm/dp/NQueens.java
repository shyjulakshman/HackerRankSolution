package com.hackerrank.algorithm.dp;

import java.util.Scanner;

public class NQueens {
	
	private static class Position{
		int row;
		int column;
		
		Position(int row,int column){
			this.row=row;
			this.column=column;
		}			
	}
	
	private static boolean isPositionSafe(int row, int col, Position[] positions) {
		//for each of the queens positions,check
		//horizontal--  row num is not same
		//vertical  --  column num is not same
		//diagonal  --   row-column   && row+column is not same		
				
		for(int pos=0;pos<row;pos++){	
			if(positions[pos]!=null){
				int posRow=positions[pos].row;
				int posCol=positions[pos].column;
				if(!(posRow!=row && posCol!=col && ((posRow-posCol)!=(row-col)) 
						&&  ((posRow+posCol)!=(row+col)))){
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean findNQueens(int n,int row,Position[] positions) {
		if(row==n){
			return true;
		}
		//Check each column and find if any safe position is available
		for(int col=0;col<n;col++){
			 if(isPositionSafe(row,col,positions)){
				 Position pos=new Position(row,col);
				// System.out.println("Row "+row+ " Col "+col);
				 positions[row]=pos;
				 //move to next  row
				 if(findNQueens(n,row+1,positions)){
					 return true;
				 }
			 }
		}
		return false;
	}
	
	
	public static void main(String args[]){
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		Position[] positions= new Position[n];
		findNQueens(n,0,positions);
		
		System.out.println("====");
		for(int i=0;i<positions.length;i++){
			if(positions[i]!=null){
				System.out.println(positions[i].row + " "+positions[i].column);
			}
		}		
		
	}



}
