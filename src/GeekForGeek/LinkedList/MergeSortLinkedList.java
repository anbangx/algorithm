package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class MergeSortLinkedList {
	
	ListNode headRef = new ListNode(-1);

	public ListNode mergeSort(ListNode head){
	    if(head == null || head.next == null)
	        return head;

	    ListNode frontRef = new ListNode(-1);
	    ListNode backRef = new ListNode(-1);
	    frontBackSplit(head, frontRef, backRef);
	    
	    System.out.println("Merge sort frontRef:");ListNode.print(frontRef.next);
	    mergeSort(frontRef.next);
	    
	    System.out.println("Merge sort backRef:");ListNode.print(backRef.next);
	    mergeSort(backRef.next);

	    headRef.next = sortedMerge(frontRef, backRef);
	    System.out.println("After sortedMerge:");ListNode.print(headRef.next);
	    return headRef.next;
	}

	public void frontBackSplit(ListNode source, ListNode frontRef, ListNode backRef){
	    ListNode slow = source;
	    ListNode fast =source.next;
	    while(fast != null && fast.next != null){
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    frontRef.next = source;
	    backRef.next = slow.next;
	    slow.next = null;
	}

	public ListNode sortedMerge(ListNode frontRef, ListNode backRef){
	    if(frontRef == null)
	        return backRef;

	    if(backRef == null)
	        return frontRef;

	    ListNode dummy = new ListNode(-1);
	    ListNode cur = dummy; ListNode cur1 = frontRef.next; ListNode cur2 = backRef.next;
	    while(cur1 != null && cur2 != null){
	        if(cur1.val < cur2.val){
	            cur.next = cur1;
	            cur1 = cur1.next;
	            cur = cur.next;
	        } else{
	            cur.next = cur2;
	            cur2 = cur2.next;
	            cur = cur.next;
	        }
	    }
	    while(cur1 != null){
	    	cur.next = cur1;
	    	cur1 = cur1.next;
	    	cur = cur.next;
	    }
	    while(cur2 != null){
	    	cur.next = cur2;
	    	cur2 = cur2.next;
	    	cur = cur.next;
	    }
	    return dummy.next;

	}

	public static void main(String[] args) {
		int[] A = {5, 20, 4, 3, 30};
		int[] B = {5, 20, 4};
		test(A);
	}
	
	public static void test(int[] A){
		MergeSortLinkedList ms = new MergeSortLinkedList();
		System.out.println("Testing...");
		ListNode head1 = ListNode.convertArrayToLinkedList(A);
		ListNode.print(head1);
		ListNode result = ms.mergeSort(head1);
		ListNode.print(result);
	}

}
