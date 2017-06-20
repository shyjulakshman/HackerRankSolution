package com.sl;

public class LeastCommonAncestor {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
		}
	    
		public void addLeft(Node left){
			this.left=left;
		}
		
		public void addRight(Node right){
			this.right=right;
		}
		
	}
	
	static class BinaryTree{
		Node root;
		
		public Node findLCA(Node node,int u,int w){
			//check if root is null
			if(node==null){
				return null;
			}
			//if root is either u or v, return root is LCA
			if(node.data==u || node.data==w){
				return node;
			}
			
			Node lcaLeft = findLCA(node.left,u,w);
			Node lcaRight= findLCA(node.right,u,w);
			
			//if left and right is not null, that 
			// means that u is in left subtree and v is in right subtree 
			if(lcaLeft!=null && lcaRight!=null){
				return node;
			}
			return (lcaLeft!=null)?lcaLeft:lcaRight;
		}
		
	}
	
	public static void main(String args[]){
	
		BinaryTree bTree = new BinaryTree();
		bTree.root=new Node(1);
		bTree.root.left=new Node(2);
		bTree.root.right=new Node(3);
		bTree.root.left.left=new Node(4);
		bTree.root.left.right=new Node(5);
		bTree.root.right.left=new Node(6);
		bTree.root.right.right=new Node(7);
		
		System.out.println(bTree.findLCA(bTree.root, 4, 5).data);
		System.out.println(bTree.findLCA(bTree.root, 4, 6).data);
		System.out.println(bTree.findLCA(bTree.root, 4, 3).data);
		System.out.println(bTree.findLCA(bTree.root, 2, 3).data);
		System.out.println(bTree.findLCA(bTree.root, 3, 6).data);
		System.out.println(bTree.findLCA(bTree.root, 3, 8).data);
		
	}

}
