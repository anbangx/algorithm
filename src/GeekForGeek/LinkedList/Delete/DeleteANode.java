package GeekForGeek.LinkedList.Delete;

import leetcode.data.ListNode;

public class DeleteANode {
	
//	1. Using dummy
    public boolean delete(ListNode head, ListNode node){
        if(head == null)
            return false;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy; ListNode cur = head;
        while(cur != null && cur.val != node.val){
        	pre = cur;
            cur = cur.next;
        }

        if(cur != null)
            pre.next = cur.next;
        return cur != null;

    }

//	2. No dummy
    public boolean deleteWithoutDummy(ListNode head, ListNode node){
        if(head == null)
            return false;

        if(head.val == node.val){
        	int temp = head.val;
            head.val = head.next.val;
            head.next.val = temp;
            head.next = head.next.next;
            return true;
        }

        ListNode pre = null; ListNode cur = head;
        while(cur != null && cur.val != node.val){
        	pre = cur;
            cur = cur.next;
        }

        if(cur != null)
            pre.next = cur.next;
        return cur != null;
    }

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		test(A, new ListNode(1));
	}
	
	public static void test(int[] A, ListNode node){
		System.out.println("Testing...");
		ListNode head = ListNode.convertArrayToLinkedList(A);
		DeleteANode dan = new DeleteANode();
		ListNode.print(head);
		dan.delete(head, node);
		ListNode.print(head);
		System.out.println("----------------------------------------");
	}


}
