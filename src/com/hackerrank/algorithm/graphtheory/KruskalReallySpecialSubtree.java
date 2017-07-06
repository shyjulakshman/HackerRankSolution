package com.hackerrank.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/kruskalmstrsub
 */


public class KruskalReallySpecialSubtree {

	private static class Edge {
		Integer start;
		Integer end;
		Integer weight;

		Edge(Integer start, Integer end, Integer weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}	
	
	

	private static class Graph {
		int noOfNodes;
		int noOfEdges;
		
		Graph(int noOfNodes, int noOfEdges) {
			this.noOfNodes = noOfNodes;
			this.noOfEdges = noOfEdges;			
		}
		
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>(new Comparator<Edge>(){
			@Override
			public int compare(Edge edge1, Edge edge2) {
				if(edge1.weight==edge2.weight){
					Integer first= edge1.start+edge1.weight+edge1.end;
					Integer second= edge2.start+edge2.weight+edge2.end;
					return first.compareTo(second);
				}else{
					return edge1.weight.compareTo(edge2.weight);
				}
			}
			
		});			

		public void addEdge(int a, int b, int weight) {
			Edge edge = new Edge(a,b,weight);
			this.edges.add(edge);
		}
		
		private void findWeightOfMST() {
			//Create disjoint sets
			DisjointSet set= new DisjointSet();
			for(int i=0;i<noOfNodes;i++){
				set.makeSet(i);
			}
			
			List<Edge> resultEdge= new ArrayList<Edge>();
			long weightOfMST=0;
			while(!edges.isEmpty()){
				Edge edge=this.edges.poll();
				int start=edge.start;
				int end=edge.end;
				
				int rootStart=set.findSet(start);
				int rootEnd=set.findSet(end);
				
				if(rootStart==rootEnd){
					continue;
				}else{
					weightOfMST+=edge.weight;
					resultEdge.add(edge);
					set.unionSet(start,end);
				}				
			}	
			System.out.println(weightOfMST);
		}
	}
	
	private static class DisjointSet{
		HashMap<Integer,Node> hMap=new HashMap<Integer,Node>();
		private static class Node{
			int id;
			int rank;
			Node parent;		
		}
		
		public void makeSet(int id){
			Node node=new Node();
			node.id=id;
			node.rank=0;
			node.parent=node;
			hMap.put(id, node);
		}
		
		public int findSet(int id){
			return findSet(hMap.get(id)).id;
		}
		
		private Node findSet(Node node){
			Node parent=node.parent;
			if(parent==node){
				return node;				
			}
			node.parent=findSet(node.parent);
			return node.parent;			
		}
		
		public boolean unionSet(int first,int second){
			
			int firstRoot=findSet(first);
			int secondRoot= findSet(second);
			
			Node firstNode= hMap.get(firstRoot);
			Node secondNode=hMap.get(secondRoot);
			
			if(firstRoot==secondRoot){
				return false;
			}
			
			if(firstNode.rank>=secondNode.rank){
				secondNode.parent=firstNode;
				firstNode.rank= firstNode.rank==secondNode.rank? firstNode.rank+1: firstNode.rank;
			}else{
				firstNode.parent=secondNode;
				secondNode.rank= firstNode.rank==secondNode.rank? secondNode.rank+1: secondNode.rank;
			}
			return false;
		}
	}
	
	

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		Graph graph = new Graph(n,m);
		for(int i=0;i<m;i++){
			int u=scanner.nextInt();
			int v=scanner.nextInt();
			int w=scanner.nextInt();
			graph.addEdge(u-1, v-1, w);			
		}
		
		graph.findWeightOfMST();

	}

	

}
