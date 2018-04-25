package test;

public class Node {
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data) {
		this.value = data;
		this.left = null;
		this.right = null;
	}
	
	public void add(int value) {
		if(this.value>value) {
			if(left==null) 
				left = new Node(value);
			else
				left.add(value);
		} else if(this.value<value) {
			if(right==null)
				right = new Node(value);
			else
				right.add(value);
		}
	}
	
	public int getLeftMostValue() {
//		System.out.printf(" %d", this.value);
		if(this.left != null) return this.left.getLeftMostValue();
		return this.value;
	}
	
	public void remove(Node parent, int value) {
		System.out.printf(" %d", this.value);
		if(this.value>value) {
			if(left!=null) left.remove(this, value);
		} else if(this.value<value) {
			if(right!=null) right.remove(this, value);
		} else {
			if(left!=null&&right!=null) {
				int lMV = right.getLeftMostValue();
				this.value = lMV;
				right.remove(this, lMV);
			} else {
				Node child = (left != null) ? left : right;
				if(parent.left == this) parent.left = child;
				else parent.right = child;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {25, 22, 29, 21, 23, 27};
		Node root = new Node(20);
		for(int i = 0; i<a.length ; ++i) {
			root.add(a[i]);
		}
		root.remove(null, 25);
	}
}
