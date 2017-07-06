package com.hackerrank.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class JourneyToTheMoon {

	/*
	 * https://www.hackerrank.com/challenges/journey-to-the-moon
	 */	

	private static class Node{
		int id;
		List<Integer> neighbours=new ArrayList<Integer>();

		Node(int id){
			this.id=id;
		}

		public void addNeighbour(int n){
			this.getNeighbours().add(n);

		}		
		public List<Integer> getNeighbours(){
			return this.neighbours;
		}
	}

	private static class Graph{
		int noOfNodes;
		Node[] nodes;

		Graph(int noOfNodes){
			this.noOfNodes = noOfNodes;
			nodes=new Node[noOfNodes];
			for(int i=0;i<noOfNodes;i++){
				nodes[i]= new Node(i);
			}
		}
		public void addEdge(int a,int b){
			this.nodes[a].addNeighbour(b);
			this.nodes[b].addNeighbour(a);			
		}

		public HashMap<Integer,Integer> findClusters(){
			int[] visited= new int[noOfNodes];
			Arrays.fill(visited, 0);
			HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
			int countryIndex=0;
			for(int i=0;i<noOfNodes;i++){
				if(visited[i]!=1){
					int sizeOfCluster = dfs(i,visited,1);			
					hMap.put(countryIndex++,sizeOfCluster);					
				}
			}
			return hMap;

		}

		public int dfs(int i, int[] visited, int size){
			visited[i]=1;
			for(int neighbour:nodes[i].getNeighbours()){
				if(visited[neighbour]!=1){
					size = 1 + dfs(neighbour,visited,size);
				}
			}
			return size;			
		}

	}



	private static long findCombinations(HashMap<Integer,Integer> hMap) {
		long combinations=0;
		int noOfCountries=hMap.size();		
		int sumOfValue=0;
		for(int i=0;i<noOfCountries-1;i++){			
			sumOfValue= sumOfValue+hMap.get(i);
			combinations = combinations + sumOfValue*hMap.get(i+1);
		
		}
		return combinations;
	}


	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int p=  scanner.nextInt();

		Graph graph= new Graph(n);
		for(int i=0;i<p;i++){
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			graph.addEdge(a, b);
		}

		HashMap<Integer,Integer> hMap=graph.findClusters();		
		System.out.println(findCombinations(hMap));
	}	

}
