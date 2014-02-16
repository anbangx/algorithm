package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class DeleteFromAPointer {
	
	ListNode node = null;
	public void delete(){
	    if(node.next == null){
	        node = null;
	        return;
	    }
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		test(A);
	}
	
	public static void test(int[] A){
		System.out.println("Testing...");
		ListNode head = ListNode.convertArrayToLinkedList(A);
		DeleteFromAPointer dan = new DeleteFromAPointer();
		ListNode.print(head);
		dan.node = head;
		dan.delete();
		ListNode.print(head);
		System.out.println("----------------------------------------");
	}
}
