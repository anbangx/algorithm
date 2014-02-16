package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class DeleteNodesHaveGreatValOnRight {
	
	public static ListNode headRef = new ListNode(-1);

	public void delete(ListNode head){

	    headRef.next = head;

	    // reverse
	    headRef.next = reverse(headRef.next);

	    // delete the nodes whose value less than pre val
	    deleteNodes(headRef.next);

	    // reverse the reversed Linked List
	    headRef.next = reverse(headRef.next);
	}

	public ListNode reverse(ListNode head){

	    if(head == null || head.next == null)
	        return head;

	    ListNode newHead = reverse(head.next);
	    head.next.next = head;
	    head.next = null;
	    return newHead;
	}

	public void deleteNodes(ListNode head){

	    if(head == null || head.next == null)
	        return;

	    ListNode pre = head; ListNode cur = head.next;
	    while(cur != null){
	        if(pre.val > cur.val){
	            pre.next = cur.next;
	        } else
	        	pre = cur;
	        cur = cur.next;
	    }
	}
	
	public static void main(String[] args) {
		int[] A = {6,4,5,2,3};
		test(A);
	}
	
	public static void test(int[] A){
		System.out.println("Testing...");
		ListNode head = ListNode.convertArrayToLinkedList(A);
		DeleteNodesHaveGreatValOnRight d = new DeleteNodesHaveGreatValOnRight();
		ListNode.print(head);
		d.delete(head);
		ListNode.print(headRef.next);
		System.out.println("----------------------------------------");
	}
}
