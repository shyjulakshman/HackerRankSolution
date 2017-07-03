package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class Encryption {
	
	/*
	 * https://www.hackerrank.com/challenges/encryption
	 */
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		String message = scanner.next();
		int length =message.length();
		
		int row= (int)Math.floor(Math.sqrt(length));
		int column= (int)Math.ceil(Math.sqrt(length));
		
		if(row*column < length){
			row=row+1;								
		}		
		for(int column_i=0;column_i<column;column_i++){
			StringBuffer str=new StringBuffer();			
			int row_j=column_i;
			while(row_j<length){
				str.append(message.charAt(row_j));
				row_j=row_j+column;
			}			
			String space = column_i==column-1?"":" ";
			System.out.print(str.toString()+space);
		}
	}

}
