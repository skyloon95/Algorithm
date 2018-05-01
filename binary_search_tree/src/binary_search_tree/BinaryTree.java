package binary_search_tree;

public class BinaryTree {
	Node root;
	
	public void add(int value) {
		if(root != null) root.add(value);
		else root = new Node(value);
	}
	
	public void print() {
		if(root != null) root.print();
		System.out.println();
	}
	
	public boolean contains(int value) {
		return root!=null && root.contains(value);
	}
	
	public void remove(int value) {
		Node dummy = new Node(Integer.MAX_VALUE);
		dummy.left = root;
		root.remove(dummy, value);
		if(dummy.left != root) root = dummy.left;
	}
	
	public void removeWithoutDummy(int value) {
		if( root == null) return;
		if( (value == root.value) && 
				(root.left==null || root.right==null)) {
			this.root = (root.left == null) ? root.right : root.left;
		} else {
			root.remove(null, value);
		}
	}
}
