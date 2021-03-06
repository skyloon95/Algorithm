package binary_search_tree;

public class Node {
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data) {
		this.value = data;
		this.left = null;
		this.right = null;
	}
	
	public void print() {
        if (left != null) left.print();
        System.out.printf("%d ", value);
        if (right != null) right.print();
    }
	
	public boolean contains(int value) {
		if(this.value>value)
			return left !=null && left.contains(value);
		else if(this.value<value)
			return right !=null && right.contains(value);
		return true;
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
	
	public void remove(Node parent, int value) {
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
	
	public int getLeftMostValue() {
		if(this.left != null) return this.left.getLeftMostValue();
		return this.value;
	}
}
