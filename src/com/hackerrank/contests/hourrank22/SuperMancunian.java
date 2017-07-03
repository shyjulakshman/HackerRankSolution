package com.hackerrank.contests.hourrank22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperMancunian {
	
	public static class Node{
		int id;
		private List<Integer> neighbours = new ArrayList<Integer>();
		
		Node(int id){
			this.id=id;
		}
		
		public List<Integer> getNeighbours(){
			return this.neighbours;
		}
		
		public void addNeighbour(int neighbour){
		   this.getNeighbours().add(neighbour);
		}
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            // Write Your Code Here
        }
    }

}
