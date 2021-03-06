package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class MatrixLayerRotation {
	
	
	public static int rotateByN(int row,int column,int rowCount,int colCount, int[][] matrix,int noOfRotations){
		//System.out.println("Row= "+row+" Col= "+ column+" "+matrix[row][column]);
		int topRow=0;
		int rightCol=colCount-1;
		int leftCol=0;
		int bottomRow=rowCount-1;
		
		if(!(row==0 || column==0 || row==rowCount-1 || column==colCount-1)){
			
			if(column<row){
				topRow=column;				
			}else if(column==row){
				 topRow=row;
			}else if(column>row){
				 topRow=colCount-1-column;				 
			}
			leftCol=topRow;
			rightCol=colCount-1-leftCol;			
			bottomRow=rowCount-1-topRow;
			
			
			/*topRow= (rowCount-1-row)==row? (row-1):Math.min(rowCount-1-row, row-0);
			bottomRow=(rowCount-1-row)==row? (row+1):Math.max(rowCount-1-row, row-0);
			leftCol=(colCount-1-column)==column? (column-1): Math.min(colCount-1-column, column-0);
			rightCol=(colCount-1-column)==column? (column+1):Math.max(colCount-1-column, column-0);*/

			rowCount= rightCol-leftCol+1;
			colCount= bottomRow-topRow+1;
		}
		
		System.out.println("Row== "+row+" Column="+column+" "+topRow+" "+bottomRow+" "+leftCol+" "+rightCol+" "+rowCount+" "+colCount);
	
		
		/*int maxPossibleRotations=  (rowCount*2)+(colCount*2)-4;
		noOfRotations= noOfRotations>maxPossibleRotations? noOfRotations%maxPossibleRotations:noOfRotations;
		
		while(noOfRotations!=0){
			
			//if top row 
			if(row==topRow && column<rightCol){			
				if(column+noOfRotations>rightCol){
					noOfRotations -=rightCol-column;
					column=rightCol;					
				}else{
					column=column+noOfRotations;
					noOfRotations=0;
				}
			}	
			
			//if right col 
			else if(column==rightCol &&  row<bottomRow){
				if(row+noOfRotations>bottomRow){
					noOfRotations -=bottomRow-row;
					row=bottomRow;					
				}else{
					row=row+noOfRotations;
					noOfRotations=0;
				}
			}
			
			//if bottom row
			else if(row==bottomRow && column>leftCol){
				if(column-noOfRotations<leftCol){
					noOfRotations-=column-leftCol;
					column=leftCol;					
				}else{
					column=column-noOfRotations;
					noOfRotations=0;
				}
			}
			
			//if leftCol
			else if(column==leftCol && row>topRow){				
				if(row-noOfRotations<topRow){
					noOfRotations-=row-topRow;
					row=topRow;										
				}else{
					row=row-noOfRotations;
					noOfRotations=0;
				}
			}	
			
		}*/
		return matrix[row][column];
	}
	
	public static void rotateByOne(int row,int column,int rowCount,int colCount, int[][] matrix){
		System.out.println(row+" "+ column+" "+matrix[row][column]);
		int topRow=0;
		int rightCol=colCount-1;
		int leftCol=0;
		int bottomRow=rowCount-1;
				
		//if top row 
		if(row==topRow && column<rightCol){
			column=column+1;
		}		
		
		//if last column 
		else if(column==rightCol &&  row<bottomRow){
			row=row+1;
		}
		
		//if bottom row
		else if(row==bottomRow && column>leftCol){
			column=column-1;
		}
		
		//if leftCol
		else if(column==leftCol && row>topRow){
			row= row-1;
		}	
		
		System.out.println(row+" "+ column+" "+matrix[row][column]);
	}
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		int rowCount= scanner.nextInt();
		int columnCount=scanner.nextInt();
		int noOfRotations=scanner.nextInt();
		int[][] matrix= new int[rowCount][columnCount];
		
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<columnCount;j++){
				matrix[i][j]=scanner.nextInt();				
			}
		}
		
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<columnCount;j++){				
				String space= j==columnCount-1?"":" ";
				//System.out.print(rotateByN(i,j,rowCount,columnCount,matrix,noOfRotations)+space);
				rotateByN(i,j,rowCount,columnCount,matrix,noOfRotations);
			}
			System.out.println();
		}
	}

}
