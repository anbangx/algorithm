package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class DeleteAlternativeNodes {
	
	public void deleteAlternativeIteratively(ListNode head){
	    if(head == null || head.next == null)   
	        return;
	    
	    ListNode pre = head;
	    ListNode cur = head.next;
		while(cur != null){
			pre.next = cur.next;
			pre = cur.next;
			cur = pre != null ? pre.next : null;
		}
	}

	public void deleteAlternativeRecursively(ListNode head){
		if(head == null || head.next == null)
			return;
		
		deleteAlternativeRecursively(head.next.next);
		head.next = head.next.next;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		int[] B = {1,2,3,4,5};
		int[] C = {1};
		test(A);
		test(B);
		test(C);
	}
	
	public static void test(int[] A){
		System.out.println("Testing...");
		ListNode head = ListNode.convertArrayToLinkedList(A);
		DeleteAlternativeNodes dan = new DeleteAlternativeNodes();
		ListNode.print(head);
		dan.deleteAlternativeRecursively(head);
		ListNode.print(head);
		System.out.println("----------------------------------------");
	}

}
