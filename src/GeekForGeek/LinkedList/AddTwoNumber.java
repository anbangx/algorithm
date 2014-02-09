package GeekForGeek.LinkedList;

import leetcode.data.ListNode;

public class AddTwoNumber {

	class IntResult{
		int val;
	}
	
	class Result{
		ListNode head = null;
	}
	/**
	 * Add two numbers represented by linked lists
	 * 5 -> 6 -> 3 // 563
	 * 8 -> 4 -> 2 // 842
	 * 1 -> 4 -> 0 -> 5 // 1405
	 */
	public ListNode addTwoNumberWithSameSize(ListNode head1, ListNode head2, IntResult carry){
	    if(head1 == null)
	        return null;
	    
	    if(head1.next == null){
	        ListNode newNode = new ListNode((head1.val + head2.val + carry.val) % 10);
	        carry.val = (head1.val + head2.val + carry.val) / 10;
	        return newNode;
	    }
	    
	    ListNode suffixHead = addTwoNumberWithSameSize(head1.next, head2.next, carry);
	    ListNode newNode = new ListNode((head1.val + head2.val + carry.val) % 10);
	    carry.val = (head1.val + head2.val + carry.val) / 10;
	    newNode.next = suffixHead;
	    return newNode;
	}

	public ListNode addTwoNumber(ListNode head1, ListNode head2){
	    ListNode result = null;
	    int size1 = getSize(head1);
	    int size2 = getSize(head2);
	    IntResult carry = new IntResult();
	    if(size1 == size2){
	        result = addTwoNumberWithSameSize(head1, head2, carry);
	        if(carry.val != 0){
	        	ListNode newNode = new ListNode(carry.val);
	        	newNode.next = result;
	        	result = newNode;
	        }
	    	return result;
	    }
	    else{
	        int diff = Math.abs(size1 - size2);
	        if(size1 < size2){
	        	ListNode temp = head1;
	        	head1 = head2;
	        	head2 = temp;
	        }
	        
	        ListNode cur = head1;
	        while(diff > 0){
	            cur = cur.next;
	            diff--;
	        }
	        result = addTwoNumberWithSameSize(cur, head2, carry);
	        Result r = new Result();
	        addCarryToRemaining(head1, cur, carry, r);
	        
	        return r.head;
	    }
	}
	
	public void addCarryToRemaining(ListNode head, ListNode cur, IntResult carry, Result result){
		int sum;
		
		if(head != cur){
			addCarryToRemaining(head.next, cur, carry, result);
			
			sum = result.head.val + carry.val;
			carry.val = sum/10;
			sum %= 10;
			
			ListNode newNode = new ListNode(sum);
			newNode.next = result.head;
			result.head = newNode;
		}
	}
	
	public int getSize(ListNode head){
		ListNode cur = head;
		int count = 0;
		while(cur != null){
			count++;
			cur = cur.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 5, 6, 3};
		int[] B = {8, 4, 2};
		test(A, B);
	}
	
	public static void test(int[] A, int[] B){
		AddTwoNumber atn = new AddTwoNumber();
		ListNode head1 = ListNode.convertArrayToLinkedList(A);
		ListNode head2 = ListNode.convertArrayToLinkedList(B);
		ListNode newHead = atn.addTwoNumber(head1, head2);
		ListNode.print(newHead);
	}
}
