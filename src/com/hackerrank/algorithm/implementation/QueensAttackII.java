package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class QueensAttackII {
	
	/*
	 * https://www.hackerrank.com/challenges/queens-attack-2	 
	 */

	private static class Position{
		int row;
		int col;

		Position(int row,int col){
			this.row=row;
			this.col=col;
		}
	}

	private static int findAttackPositionCount(int n, int k,int rQueen,int cQueen, Position[] obstacles) {
		int count=0;		
		count+=  checkHorizontalCount(n,k,rQueen,cQueen,obstacles);		
		count+=  checkVerticalCount(n,k,rQueen,cQueen,obstacles);		
		count+=  checkRightDiagonalCount(n,k,rQueen,cQueen,obstacles);
		count+=  checkLeftDiagonalCount(n,k,rQueen,cQueen,obstacles);		
		return count;
	}

	private static int checkLeftDiagonalCount(int n, int k, int rQueen, int cQueen, Position[] obstacles) {		 
		int count=0;
		int maxRow=n;
		int minCol=1;
		int maxCol=n;
		int minRow=1;
		for(Position pos:obstacles){
			if((pos.row - pos.col) == (rQueen-cQueen)){
				if(pos.col > cQueen &&  pos.col<=maxCol){
					maxRow=pos.row -1;	 
					maxCol=pos.col +1;
				}
				if(pos.col < cQueen && pos.col>=minCol){
					minCol=pos.col-1;
					minRow=pos.row +1;
				}
			}
		}
		//Min(n-col,n-row     col-1, row-1
		count +=  Math.min(maxCol-cQueen, maxRow-rQueen) + Math.min(cQueen-minCol, rQueen-minRow);
		return count;
	}

	private static int checkRightDiagonalCount(int n, int k, int rQueen, int cQueen, Position[] obstacles) {		 
		int count=0;
		int maxRow=n;
		int minCol=1;
		int maxCol=n;
		int minRow=1;
		for(Position pos:obstacles){
			if((pos.row + pos.col) == (rQueen+cQueen)){
				if(pos.row > rQueen &&  pos.row<=maxRow){
					maxRow=pos.row-1;	 
					minCol=pos.col-1;
				}
				if(pos.row < rQueen && pos.col<=maxCol){
					maxCol=pos.col+1;
					minRow=pos.row+1;
				}
			}
		}
		//Min((col-1),(n-row))  +  Min(row-1,n-col)
		count +=  Math.min(cQueen-minCol, maxRow-rQueen) + Math.min(rQueen-minRow, maxCol-cQueen);
		return count;
	}

	private static int checkVerticalCount(int n, int k, int rQueen, int cQueen, Position[] obstacles) {		
		int down=0;
		int up=n+1;
		for(Position pos: obstacles){
			if(pos.col==cQueen){
				if(pos.row <rQueen && pos.row>=down){
					down=pos.row;
				}
				if(pos.row>rQueen && pos.row<=up){
					up=pos.row;
				}
			}

		}
		int count=(up-down)+1-3;
		return count;
	}

	private static int checkHorizontalCount(int n, int k, int rQueen, int cQueen, Position[] obstacles) {		
		int left=0;
		int right=n+1;
		for(Position pos: obstacles){
			if(pos.row==rQueen){
				if(pos.col <cQueen && pos.col>=left){
					left=pos.col;
				}
				if(pos.col>cQueen && pos.col<=right){
					right=pos.col;
				}
			}

		}        
		int count=(right-left)+1-3;
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();

		Position[] obstacles= new Position[k];
		for(int a0 = 0; a0 < k; a0++){
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			obstacles[a0]=new Position(rObstacle,cObstacle);	           
		}

		System.out.println(findAttackPositionCount(n,k,rQueen,cQueen,obstacles));
	}

}
