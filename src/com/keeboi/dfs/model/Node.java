package com.keeboi.dfs.model;

public class Node {
	
	private int x;
	private Node leftChild = null;
	private Node rightChild = null;
	
	public Node(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public void addChild(Node child) throws NodeDuplicateValueException {
		if(child.getX() > x) {
			if(this.getRightChild() == null)
				this.rightChild = child;
			else
				this.getRightChild().addChild(child);
		}
		if(child.getX() < x) {
			if(this.getLeftChild() == null)
				this.leftChild = child;
			else
				this.getLeftChild().addChild(child);
		}
		
		
		if(child.getX() == x)
			throw new NodeDuplicateValueException();
	}
	
}
