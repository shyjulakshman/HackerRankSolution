package com.hackerrank.algorithm.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/dijkstrashortreach
 */

public class DijkstraShortestReach {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

	}

	private static class Edge {
		Node start;
		Node end;
		int weight;

		Edge(Node start, Node end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	private static class Node {
		int id;
		List<Node> neighbours = new ArrayList<Node>();
		List<Edge> edges = new ArrayList<Edge>();
		Integer distanceToSoure = Integer.MAX_VALUE;

		Node(int id) {
			this.id = id;
		}

		public void addNeighbour(Node neighbour, int weight) {
			this.getNeighbours().add(neighbour);
			Edge e = new Edge(this, neighbour, weight);
			List<Edge> edges= this.getEdges();

			boolean containsEdge=false;
			int prevWeight=0;
			for(Edge edge: edges){
				if(edge.end.equals(neighbour)){
					containsEdge=true;
					prevWeight=edge.weight;
					break;
				}
			}
			if(edges.isEmpty() || !containsEdge || (containsEdge && prevWeight>weight)){					
				this.getEdges().add(e);
			}

		}

		public List<Node> getNeighbours() {
			return this.neighbours;
		}

		public List<Edge> getEdges() {
			return this.edges;
		}

		public Integer getDistancetoSource() {
			return distanceToSoure;
		}

		public void setDistanceToSource(Integer distance) {
			this.distanceToSoure = distance;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == this){
				return true;
			}
			if(!(obj instanceof Node)){
				return false;
			}
			Node node= (Node)obj;
			if(node.id==this.id){
				return true;
			}else{
				return false;
			}
		}
	}

	private static class Graph {
		int noOfNodes;
		int noOfEdges;
		Node[] nodes;

		Graph(int noOfNodes, int noOfEdges) {
			this.noOfNodes = noOfNodes;
			this.noOfEdges = noOfEdges;
			nodes = new Node[noOfNodes];
			for (int i = 0; i < noOfNodes; i++) {
				nodes[i] = new Node(i);
			}
		}

		public void addEdge(int a, int b, int weight) {
			this.nodes[a].addNeighbour(this.nodes[b], weight);
			this.nodes[b].addNeighbour(this.nodes[a], weight);
		}

		private Node findNodeWithMinDistance(HashSet<Node> unsettled) {
			int min=Integer.MAX_VALUE;
			Node minNode=null;
			for(Node node:unsettled){
				if(node.getDistancetoSource()<min){
					min=node.getDistancetoSource();
					minNode=node;
				}
			}			
			return minNode;
		}



		private String shortestPathDijkstras(int source) {

			this.nodes[source].distanceToSoure = 0;

			HashSet<Node> settled= new HashSet<Node>();
			HashSet<Node> unsettled= new HashSet<Node>();

			unsettled.add(this.nodes[source]);

			int[] shortestPath = new int[this.noOfNodes];
			Arrays.fill(shortestPath, Integer.MAX_VALUE);

			shortestPath[source] = 0;

			while (!unsettled.isEmpty()) {				
				//Node cur=queue.poll();
				Node cur= findNodeWithMinDistance(unsettled);
				unsettled.remove(cur);
				settled.add(cur);

				for(Edge edge:cur.getEdges()){
					if(!settled.contains(edge.end)){						
						// check new distance if  less than cur distance update
						if( shortestPath[cur.id] + edge.weight  < shortestPath[edge.end.id] ){
							shortestPath[edge.end.id]= shortestPath[cur.id] + edge.weight;
							this.nodes[edge.end.id].distanceToSoure=shortestPath[edge.end.id];							
							unsettled.add(edge.end);
						}
					}

				}

			}
			StringBuffer buffer = new StringBuffer();

			for(int i=0;i<noOfNodes;i++){
				if(i!=source){
					if(shortestPath[i]<0 ||shortestPath[i]==Integer.MAX_VALUE){
						buffer.append("-1 ");
					    //System.out.print("-1 ");
					}else{
						//System.out.print(shortestPath[i]+" ");
						buffer.append(shortestPath[i]+" ");
					}
				}
			}			
			return buffer.toString();
			//System.out.println("");

		}	

		/*private void shortestPathDijkstras(int source) {

			this.nodes[source].distanceToSoure = 0;
			PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
				public int compare(Node a, Node b) {
					return a.distanceToSoure.compareTo(b.distanceToSoure);
				}

			});

			int[] shortestPath = new int[this.noOfNodes];
			Arrays.fill(shortestPath, Integer.MAX_VALUE);

			shortestPath[source] = 0;

			boolean[] settled=new boolean[this.noOfNodes];
			Arrays.fill(settled,false);
			
			queue.add(this.nodes[source]);

			while (!queue.isEmpty()) {				
				Node cur=queue.poll();				
				if(settled[cur.id]){
					continue;
				}
				settled[cur.id]=true;
				for(Edge edge:cur.getEdges()){
					if(!settled[edge.end.id]){
					//if(queue.contains(edge.end)){						
						// check new distance if  less than cur distance update
						if( shortestPath[cur.id] + edge.weight  < shortestPath[edge.end.id] ){
							shortestPath[edge.end.id]= shortestPath[cur.id] + edge.weight;
							this.nodes[edge.end.id].distanceToSoure=shortestPath[edge.end.id];							
							queue.add(edge.end);
						}
					}

				}

			}

			for(int i=0;i<noOfNodes;i++){
				if(i!=source){
					if(shortestPath[i]<0 ||shortestPath[i]==Integer.MAX_VALUE){
						System.out.print("-1 ");
					}else{
						System.out.print(shortestPath[i]+" ");
					}
				}
			}
			System.out.println("");

		}*/

	}




	public static void main(String args[]) {
		//Scanner scanner = new Scanner(System.in);
		FastReader scanner = new FastReader();
		int noOfTestCases = scanner.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int noOfNodes = scanner.nextInt();
			int noOfEdges = scanner.nextInt();
			Graph graph = new Graph(noOfNodes, noOfEdges);
			for (int edge_i = 0; edge_i < noOfEdges; edge_i++) {
				int first = scanner.nextInt();
				int second = scanner.nextInt();
				int weight = scanner.nextInt();
				graph.addEdge(first-1, second-1, weight);
			}
			int source = scanner.nextInt();
			System.out.println(graph.shortestPathDijkstras(source - 1));
		}
	}

}
