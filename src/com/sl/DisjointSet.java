package com.sl;

import java.util.HashMap;

public class DisjointSet {
	
	/*
	 * Disjoint set with union by rank and path compression
	 * 
	 * makeSet
	 * union
	 * find
	 */
	
	private HashMap<Integer,Node> hMap = new HashMap<Integer,Node>();
	
	private class Node{
		int id;
		int rank;
		Node parent;
		
		Node(int id,int rank,Node parent){
			this.id=id;
			this.rank=rank;
			this.parent=parent;
					
		}		
	}
	
	/**
	 * Create a new set and add to map.
	 * rank is set to 0
	 * and parent to itself
	 */
	public void makeSet(int id){
		Node node = new Node(id,0,null);
		node.parent=node;
		hMap.put(id, node);		
	}
	
	
	public int findSet(int id){
		return findSet(hMap.get(id)).id;		
	}	
	
	private Node findSet(Node node){
		Node parent=node.parent;
		if(parent== node){
			return node;
		}
		node.parent= findSet(node.parent);
		return node.parent;
	}
	
	public boolean union(int a,int b){
		
	    Node parent1= findSet(hMap.get(a));
	    Node parent2= findSet(hMap.get(b));
	    //if belongs to same set do nothing
	    if(parent1.id==parent2.id){
	    	return false;	
	    }
	    
	   //find rank of both nodes. the one with higher rank becomes parent of other
	    
	    if(parent1.rank>=parent2.rank){
	    	parent2.parent=parent1;
	    	parent1.rank=(parent1.rank==parent2.rank)?(parent1.rank+1) : (parent1.rank);	    	
	    }else{
	    	parent1.parent=parent2;
	    	parent2.rank=(parent1.rank==parent2.rank)?(parent2.rank+1) : (parent2.rank);
	    }	    
		return true;
		
	}
	
	public static void main (String args[]){
		DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
	}

}
