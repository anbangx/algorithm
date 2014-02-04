package Amazon;

import leetcode.data.ListNode;


public class ReverseLinkedList {
    
    public ListNode reverseRecursively(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseRecursively(head.next);
        ListNode cur = newHead;
        while(cur.next != null)
            cur = cur.next;
        cur.next = head;
        head.next = null;
        return newHead;
    }
    
    public ListNode reverseIteratively(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = ListNode.convertArrayToLinkedList(A);
        ListNode.print(rll.reverseRecursively(head));
        head = ListNode.convertArrayToLinkedList(A);
        ListNode.print(rll.reverseIteratively(head));
    }
    
}
