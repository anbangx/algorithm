package GeekForGeek.LinkedList.Merge;

import leetcode.data.ListNode;

public class MergeIntoAnotherListAtAlternatePositions {

	public class Result{
		ListNode head;
		public Result(ListNode head){
			this.head = head;
		}
	}
	/**
	 * Given two linked lists, insert nodes of second list into first list at
	 * alternate positions of first list. For example, if first list is
	 * 5->7->17->13->11 and second is 12->10->2->4->6, the first list should
	 * become 5->12->7->10->17->2->13->4->11->6 and second list should become
	 * empty. The nodes of second list should only be inserted when there are
	 * positions available. For example, if the first list is 1->2->3 and second
	 * list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and
	 * second list to 7->8.
	 */
	public void mergeAlternatePosition(ListNode head1, Result head2){
	    if(head1 == null || head2 == null)
	        return;
	    
	    ListNode pre = null;
	    ListNode cur1 = head1;
	    ListNode cur2 = head2.head;
	    while(cur1 != null && cur2 != null){
	        ListNode temp = cur2.next;
	        cur2.next = cur1.next;
	        cur1.next = cur2;
	        cur1.next = cur2;
	        cur1 = cur2.next;
	        pre = cur2;
	        cur2 = temp;
	    }
	    
	    head2.head = cur2;
	}
	
	public static void main(String[] args) {
		// 5->7->17->13->11 and second is 12->10->2->4->6
		int[] A = {5, 7, 17, 13, 11};
		int[] B = {12, 10, 2, 4, 6};
		
		testLinkedLists(A, B);
 	}
	
	public static void testLinkedLists(int[] A, int[] B){
		System.out.println("Testing...");
		MergeIntoAnotherListAtAlternatePositions m = new MergeIntoAnotherListAtAlternatePositions();
		ListNode head1 = ListNode.convertArrayToLinkedList(A);
		ListNode head2 = ListNode.convertArrayToLinkedList(B);
		ListNode.print(head1);
		ListNode.print(head2);
		Result r2 = m.new Result(head2);
		m.mergeAlternatePosition(head1, r2);
		ListNode.print(head1);
		ListNode.print(r2.head);
		System.out.println("-----------------------------------------------------------");
	}

}
