package binary_search_tree;

public class TreeUtil {
	Node root;

	public TreeUtil() {
		root = null;
	}
	
	public boolean contains(Node tmp, int num) {
		if(tmp == null) 
			return false;
		if(num<tmp.data)
			return contains(tmp.lLink, num);
		else if(num > tmp.data)
			return contains(tmp.rLink, num);
		else 
			return true;
	}
	public boolean add(int num, Node tmp) {
		if(root == tmp) {
			root = new Node(num);
			return true;
		}
		if(tmp.data == num)
			return false;
		if(tmp.lLink==null&&tmp.rLink==null) {
			if(num < tmp.data)
				tmp.lLink = new Node(num);
			else if (num > tmp.data)
				tmp.rLink = new Node(num);
			return true;
		}
		else if(tmp.lLink == null) {
			if(tmp.data)
		}
	}

	
	public void printFF(Node tmp) {
		if(tmp!=null) {
			printFF(tmp.lLink);
			System.out.print(tmp.data+" ");
			printFF(tmp.rLink);
		} else {
			System.out.println("");
		}
	}
}
