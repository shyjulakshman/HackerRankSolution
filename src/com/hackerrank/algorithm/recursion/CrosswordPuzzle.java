package com.hackerrank.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CrosswordPuzzle {
	
	
	private static class Position{
		int index;
		int start;
		int end;	
		String value="";
		
		Position(int index,int start,int end){
			this.index=index;
			this.start=start;
			this.end=end;
		}
		
		public int getCount(){
			return end-start+1;
		}
	}
	
	private static void findOverlapLocations(List<Position> horizontalPos, List<Position> verticalPos, List<String> namesList,List<String> mappedNames) {
		List<Position> overlapPositions= new ArrayList<Position>();
		for(Position hPos:horizontalPos){
			for(Position vPos:verticalPos){
				if((vPos.index>=hPos.start && vPos.index<=hPos.end) &&  (hPos.index>=vPos.start && hPos.index<=vPos.end)){
					
					Position overlapPos=new Position(hPos.index,hPos.index,vPos.index);
					overlapPositions.add(overlapPos);					
					
					//find names which can fit this place
					findNameForOverlap(hPos,vPos,namesList,mappedNames);
				}
			}			
		}
	}
	
	private static void findNameForOverlap(Position hPos, Position vPos,List<String> namesList,List<String> mappedNames) {

		boolean found=false;
		
		for(String name: namesList){
			if(found){
				break;
			}
			if(name.length()==hPos.getCount()){
				for(String anotherName:namesList){
					if(!anotherName.equals(name) && anotherName.length()==vPos.getCount() 
							&&  name.charAt(vPos.index-hPos.start)==anotherName.charAt(hPos.index-vPos.start)){  //assuming no duplicate names
						//match found
						if(hPos.value.isEmpty()){
							hPos.value=name;
						}
						if(vPos.value.isEmpty()){
							vPos.value=anotherName;
						}
						mappedNames.add(name);
						mappedNames.add(anotherName);
						found=true;			
						break;
					}					
				}
			}		
		}	
	}

	private static void solvePuzzle(List<Position> horizontalPos, List<Position> verticalPos, String[] namesArr) {		
		List<String> namesList=new ArrayList<String>();
		namesList.addAll(Arrays.asList(namesArr));
		List<String> foundNames = new ArrayList<String>();
		findOverlapLocations(horizontalPos,verticalPos,namesList,foundNames);		
		mapRemaining(horizontalPos,verticalPos,namesList,foundNames);
		printResult(horizontalPos,verticalPos);
	}
	
	private static void printResult(List<Position> horizontalPos, List<Position> verticalPos) {
	  char[][] result = new char[10][10];
	  for(int i=0;i<10;i++){
		  for(int j=0;j<10;j++){
			 result[i][j]='+';
		  }		 
	  }
	  
	  for(Position pos:horizontalPos){
		  int start=pos.start;
		  for(int i=0;i<pos.getCount();i++){			  
			  result[pos.index][start]=pos.value.charAt(i);
			  start++;
		  }
		  
	  }
	  for(Position pos:verticalPos){
		  int start=pos.start;
		  for(int i=0;i<pos.getCount();i++){			  
			  result[start][pos.index]=pos.value.charAt(i);
			  start++;
		  }
		  
	  }
	  
	  for(int i=0;i<10;i++){
		  for(int j=0;j<10;j++){
			  System.out.print(result[i][j]);
		  }
		  System.out.println("");
	  }
		
	}

	private static void  findName(Position pos, List<String> namesList,
			List<String> foundNames){
		if(pos.value==null || pos.value.isEmpty()){
			for(String name:namesList){
				if(!foundNames.contains(name)){
					if(name.length()==pos.getCount()){
						pos.value=name;
						foundNames.add(name);
					}
				}
			}
		}
		
	}
	

	private static void mapRemaining(List<Position> horizontalPos, List<Position> verticalPos, List<String> namesList,
			List<String> foundNames) {		
		for(Position pos:horizontalPos){
			findName(pos,namesList,foundNames);
		}
		for(Position pos:verticalPos){
			findName(pos,namesList,foundNames);
		}				
	}

	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		List<Position> horizontalPos= new ArrayList<Position>();
		List<Position> verticalPos= new ArrayList<Position>();
		Character[][] input=  new Character[10][10];
		for(int i=0;i<10;i++){
			int start=-1;			
			String next= scanner.next();
			for(int j=0;j<10;j++){
				input[i][j]=next.charAt(j);
				boolean flag=false;
				if(input[i][j]=='-'){
					if(start==-1){
						start=j;
					}
					if(j==9){
						flag=true;
					}
				}
				if(input[i][j]=='+' || flag){
					if(start>-1 && j-start>1){		
						int end = flag?j:j-1;
						Position position = new Position(i,start,end);
						horizontalPos.add(position);						
					}
					start=-1;						
				}					

			}
		}
		
		String names= scanner.next();
		String[] namesArr=names.split(";");
		
		for(int i=0;i<10;i++){
			int start=-1;
			boolean flag=false;
			for(int j=0;j<10;j++){				
				if(input[j][i]=='-'){
					if(start==-1){
						start=j;
					}
					if(j==9){						
						flag=true;
					}
				}
				if(input[j][i]=='+' || flag){
					if(start>-1 && j-start>1){		
						int end = flag?j:j-1;
						Position position = new Position(i,start,end);
						verticalPos.add(position);						
					}
					start=-1;						
				}					

			}
		}
		solvePuzzle(horizontalPos,verticalPos,namesArr);				
	}

}
