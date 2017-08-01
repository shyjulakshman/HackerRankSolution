package com.sl.algorithm.binarytree;

public class IsBinarySearchTree {	
	
	/*
	 * Method to check if the binary Tree is a Binary Search tree
	 */
	
	class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public boolean checkIsBST(Node root){
		return checkIsBSTRecursive(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean checkIsBSTRecursive(Node root,int min,int max){
		if(root==null){
			return true;			
		}		
		
		if(root.data<=min || root.data>max){
			return false;
		}		
	    return (checkIsBSTRecursive(root.left,min,root.data)&& (checkIsBSTRecursive(root.right,root.data,max)));
	}
}
