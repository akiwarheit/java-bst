package com.keeboi.dfs.model;

import com.keeboi.dfs.callback.TreeCallback;

public class Tree {
	
	private Node head;
	private TreeCallback cb;
	
	public Tree() {
	}
	
	public Tree(Node head, TreeCallback cb) {
		this.head = head;
		this.cb = cb;
	}
	
	public void addNode(Node child) throws NodeDuplicateValueException {
		head.addChild(child);
	}
	
	public Node dfs(Node node, int x) throws NodeNotFoundException {
		if(node != null) {
			if(node.getX() == x) {
				cb.onNodeFound(node);
				return node;
			}
			if(x < node.getX()) {
				return dfs(node.getLeftChild(), x);
			}
			if(x > node.getX()) {
				return dfs(node.getRightChild(), x);			
			}
		}
		
		cb.onNodeNotFound();
		throw new NodeNotFoundException();

	}
	
	public Node getHead() {
		return head;
	}
	
}
