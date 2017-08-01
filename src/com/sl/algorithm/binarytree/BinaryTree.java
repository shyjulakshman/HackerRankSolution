package com.sl.algorithm.binarytree;

class Node{
	Node left;
	Node right;
	int data;
	
	public Node(int data){
		this.data=data;
		left=null;
		right=null;					
	
	}
}

public class BinaryTree {
	
	private Node root;

	public int sizeOfBinaryTree(Node root){
		if(root==null){
			return 0;
		}
		int leftSize= sizeOfBinaryTree(root.left);
		int rightSize= sizeOfBinaryTree(root.right);
		return leftSize+rightSize+1;
	}
	
	public int heightOfBinaryTree(Node root){
		if(root==null){
			return 0;
		}
		int leftHeight= heightOfBinaryTree(root.left);
		int rightHeight= heightOfBinaryTree(root.right);
		
		return Math.max(leftHeight,rightHeight)+1;
	}

}
