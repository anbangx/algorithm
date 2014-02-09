package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class QuickSortSinglyLinkedList {
	
	class Result{
		ListNode newHead = null;
		ListNode newTail = null;
	}
	
	public ListNode quickSort(ListNode head, ListNode tail){
	    if(head == null || head.next == null || head == tail)
	        return head;
	    
	    Result r = new Result();
	    ListNode pivot = partition(head, tail, r);
	    if(r.newHead != null){
		    ListNode firstTail = findTail(r.newHead, pivot);
		    quickSort(r.newHead, firstTail);
	    }
	    quickSort(pivot.next, r.newTail);
	    return r.newHead;
	}

	public ListNode partition(ListNode head, ListNode tail, Result r){
	    ListNode pivot = tail;
	    ListNode pre = null;
	    ListNode cur = head;
	    while(cur != pivot){
	        if(cur.val < pivot.val){
	            if(r.newHead == null)
	                r.newHead = cur;
	            pre = cur;
	            cur = cur.next;
	        }
	        else{
	            if(pre != null){
	                pre.next = cur.next;
	            }
	            ListNode temp = cur.next;
	            if(r.newTail == null){
	            	cur.next = pivot.next;
	                pivot.next = cur;
	            } else{
	            	cur.next = r.newTail.next;
	                r.newTail.next = cur;
	            }
	            r.newTail = cur;
	            cur = temp;  
	        }
	    }
	    return pivot;
	}

	public static ListNode findTail(ListNode head){
	    ListNode cur = head;
	    while(cur.next != null)
	        cur = cur.next;
	    return cur;
	}
	
	public static ListNode findTail(ListNode head, ListNode pivot){
	    ListNode cur = head;
	    while(cur.next != pivot)
	        cur = cur.next;
	    return cur;
	}
	
	public static void main(String[] args) {
		int[] A = {5, 20, 4, 3, 30};
		int[] B = {5, 20, 4};
		test(B);
	}
	
	public static void test(int[] A){
		QuickSortSinglyLinkedList qs = new QuickSortSinglyLinkedList();
		System.out.println("Testing...");
		ListNode head1 = ListNode.convertArrayToLinkedList(A);
		ListNode.print(head1);
		ListNode result = qs.quickSort(head1, findTail(head1));
		ListNode.print(result);
	}

}
