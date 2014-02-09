package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class PairSwapElements {

	/** Pairwise swap elements of a given linked list by changing links
	input: 1 -> 2 -> 3 -> 4
	output: 2 -> 1 -> 4 ->3 
	**/

	public ListNode swapPairwise(ListNode head){
	    if(head == null || head.next == null)
	        return head;
	    
	    ListNode headRef = new ListNode(-1);
	    headRef.next = head;
	    ListNode pre = headRef;
	    ListNode cur = head;
	    
	    while(cur != null){
	        ListNode temp = cur.next;
	        if(temp == null)
	        	break;
	        cur.next = temp.next;
	        temp.next = cur;
	        pre.next = temp;
	        pre = cur;
	        cur = cur.next;
	    }
	    
	    return headRef.next;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int[] B = {1, 2, 3, 4, 5};
		int[] C = {};
		int[] D = {1};
		testArray(A);
		testArray(B);
		testArray(C);
		testArray(D);
 	}
	
	public static void testArray(int[] array){
		System.out.println("Testing...");
		PairSwapElements psw = new PairSwapElements();
		ListNode head = ListNode.convertArrayToLinkedList(array);
		ListNode.print(head);
		ListNode newHead = psw.swapPairwise(head);
		ListNode.print(newHead);
		System.out.println("-----------------------------");
	}

}
