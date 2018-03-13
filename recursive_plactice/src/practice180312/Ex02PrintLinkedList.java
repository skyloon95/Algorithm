package practice180312;

public class Ex02PrintLinkedList {
	public static void main(String[] args) {
		Node root = null;
        for (int i = 1; i <= 10; ++i)
            root = new Node(i, root);

        Node.printAll(root);
	}
	
	static class Node{
		int value;
		Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public static void printAll(Node tmp){
			System.out.print(tmp.value+ " ");
			if(tmp.next!=null)
				printAll(tmp.next);
		}
	}
}
