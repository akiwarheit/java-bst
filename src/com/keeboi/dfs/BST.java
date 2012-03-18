package com.keeboi.dfs;

import com.keeboi.dfs.callback.TreeCallback;
import com.keeboi.dfs.model.Node;
import com.keeboi.dfs.model.NodeDuplicateValueException;
import com.keeboi.dfs.model.NodeNotFoundException;
import com.keeboi.dfs.model.Tree;

public class BST implements TreeCallback {

	public static void main(String[] args) {
		
		BST myBST = new BST();
		
		Node head = new Node(20);
		Tree bst = new Tree(head, myBST);
	
		Node child = new Node(53);
		Node anotherChild = new Node(54);
		Node anotherChild2 = new Node(18);	
		
		try {
			bst.addNode(child);
			bst.addNode(anotherChild);		
			bst.addNode(anotherChild2);
		} catch (NodeDuplicateValueException e) {
			System.out.println("trying to insert a node with duplicate value.");
			
		}
		
		try {
			bst.dfs(bst.getHead(), 53);
		} catch (NodeNotFoundException e) {
			
		}
	}

	@Override
	public void onNodeFound(Node node) {
		System.out.println("Node found. The value searched for is " + node.getX());
	}

	@Override
	public void onNodeNotFound() throws NodeNotFoundException {
		System.out.println("Node does not exist.");
	}
	
}
