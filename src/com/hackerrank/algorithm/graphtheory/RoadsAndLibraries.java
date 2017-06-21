package com.hackerrank.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {
	
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
	
	public static class Graph{
		int noOfNodes;
		Node[] nodes;
		
		Graph(int noOfNodes){
			this.noOfNodes=noOfNodes;
			nodes= new Node[noOfNodes+1];
			for(int i=1;i<=noOfNodes;i++){
				nodes[i]=new Node(i);
			}
		}
		
		public void addEdge(int a,int b){
			this.nodes[a].addNeighbour(b);
			this.nodes[b].addNeighbour(a);			
		}

		public long minCostForLibrary(long costLib, long costRoad, int noOfCities, int noOfRoads) {		
			long cost=0;
			int[] visited = new int[noOfCities+1];
            Arrays.fill(visited, -1);
            
			for(int i=1;i<=noOfCities;i++){
				if(visited[i]!=1){					
					int sizeOfCluster = dfs(i,visited,1);					
					cost += costLib;					
					
					if(costRoad>=costLib){
						cost += costLib*sizeOfCluster ;
					}else{
						cost += costLib+ costRoad*(sizeOfCluster-1);
					}
				}
			}
			return cost;
		}

		private int dfs(int i,int[] visited,int size) {
			visited[i]=1;			
			for(int node: this.nodes[i].getNeighbours()){
				if(visited[node]!=1){
					size = 1+ dfs(node,visited,size);
				}
			}
			return size;
		}
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int noOfCities = in.nextInt();
            Graph graph = new Graph(noOfCities);
            int noOfRoads = in.nextInt();
            long costLib = in.nextLong();
            long costRoad = in.nextLong();
            for(int a1 = 0; a1 < noOfRoads; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                graph.addEdge(city_1, city_2);
            }
            
            System.out.println(graph.minCostForLibrary(costLib,costRoad,noOfCities,noOfRoads));
        }
    }

}
