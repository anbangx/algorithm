package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class DeleteNAfterM {
	
	/**
	 * Delete N nodes after M nodes of a linked list
	 */

	public void deleteNAfterM(ListNode head, int m, int n){
		ListNode pre = null;
	    ListNode cur = head;
	    while(true){
	    	int mm = m;
	    	int nn = n;
		    while(cur != null && mm > 0){
		    	pre = cur;
		        cur = cur.next;
		        mm--;
		    }
		    if(cur == null)
		        return;
		    while(cur != null && nn > 0){
		        pre.next = cur.next;
		        cur = cur.next;
		        nn--;
		    }
		    if(cur == null)
		    	return;   
	    }
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7,8};
		test(A, 2, 2);
		int[] B = {1,2,3,4,5,6,7,8,9,10};
		test(B, 3, 2);
		test(B, 1, 1);
		int[] C = {1,2,3};
		test(C, 4, 2);
		test(C, 1, 5);
	}
	
	public static void test(int[] A, int m, int n){
		System.out.println("Testing...");
		ListNode head = ListNode.convertArrayToLinkedList(A);
		DeleteNAfterM dbam = new DeleteNAfterM();
		ListNode.print(head);
		dbam.deleteNAfterM(head, m, n);
		ListNode.print(head);
		System.out.println("----------------------------------------");
	}

}
