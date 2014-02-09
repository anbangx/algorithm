package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class SwapKthFromBeginingAndEnd {
	
	/**
	 * Swap Kth node from beginning with Kth node from end in a Linked List
	 */
	public void swap(ListNode head, int n, int k){
	    if(k > n || 2 * k + 1 == n)
	        return;
	    
	    ListNode headRef = new ListNode(-1);
	    headRef.next = head;
	    
	    // find Kth node
	    ListNode pre = null;
	    ListNode cur = headRef;
	    for(int i = 0; i < k; i++){
	        pre = cur;
	        cur = cur.next;
	    }
	    ListNode pre1 = pre;
	    ListNode cur1 = cur;
	    ListNode pre2 = headRef;
	    ListNode cur2 = head;
	    while(cur.next != null){
	        cur = cur.next;
	        pre2 = cur2;
	        cur2 = cur2.next;
	    }
	    
	    // swap
	    pre1.next = cur2;
	    ListNode temp = cur2.next;
	    cur2.next = cur1.next;
	    pre2.next = cur1;
	    cur1.next = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7,8};
		test(A, 8, 2);
	}
	
	public static void test(int[] A, int n, int k){
		System.out.println("Testing...");
		ListNode head = ListNode.convertArrayToLinkedList(A);
		SwapKthFromBeginingAndEnd s = new SwapKthFromBeginingAndEnd();
		ListNode.print(head);
		s.swap(head, n, k);
		ListNode.print(head);
		System.out.println("----------------------------------------");
	}
}
