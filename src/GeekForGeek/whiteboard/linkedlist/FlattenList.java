package GeekForGeek.whiteboard.linkedlist;

public class FlattenList {
	
	public Node merge(Node a, Node b){
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		Node result = null;
		if(a.val < b.val){
			result = a;
			result.down = merge(a.down, b);
		} else{
			result = b;
			result.down = merge(a, b.down);
		}
		return result;
	}
	
	public Node flattenList(Node head){
		if(head == null)
			return null;
		
		return merge(head, flattenList(head.right));
	}
	
	public static void main(String[] args) {
		Node l11 = new Node(5);
		Node l12 = new Node(7);
		l11.down = l12;
		Node l13 = new Node(8);
		l12.down = l13;
		Node l14 = new Node(30);
		l13.down = l14;
		Node l21 = new Node(10);
		l11.right = l21;
		Node l22 = new Node(20);
		l21.down = l22;
		Node l31 = new Node(19);
		l21.right = l31;
		Node l32 = new Node(22);
		l31.down = l32;
		Node l33 = new Node(50);
		l32.down = l33;
		
		FlattenList fl = new FlattenList();
		Node head = fl.flattenList(l11);
		Node cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.down;
		}
	}
}

class Node{
	int val;
	Node down;
	Node right;
	public Node(int val){
		this.val = val;
	}
	
	public String toString(){
		return this.val + ",[" + down + ", " + right + "]"; 
	}
}
