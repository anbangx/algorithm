package leetcode.secondround;

import leetcode.data.ListNode;

public class ReverseLinkedList2 {
	
	public ListNode reverse(ListNode head, int k){
        if(head == null || head.next == null)   return head;
        if(k == 1)  return head;
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null && k > 0){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        head.next = next;
        return pre;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode reverseHead = head;
        int mm = m;
        while(mm > 1){
            pre = reverseHead;
            reverseHead = reverseHead.next;
            mm--;
        }
        ListNode newHead = reverse(reverseHead, n - m + 1);
        if(pre != null)
            pre.next = newHead;
        else
            head = newHead;
        return head;
    }
    
	public static void main(String[] args) {
		ReverseLinkedList2 rll = new ReverseLinkedList2();
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		head.next = second; second.next = third;
		ListNode newHead = rll.reverseBetween(head, 2, 2);
		ListNode cur = newHead;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

}
