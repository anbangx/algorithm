package leetcode.reverse;

import leetcode.data.ListNode;

public class ReverseLinkedList {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode safeGuard = new ListNode(-1);
        safeGuard.next = head;
        // step1: Find the start pointer of reversion
        ListNode pre = safeGuard;
        ListNode cur = head;
        for(int i = 0; i < m - 1; i++){
            pre = pre.next;
            cur = cur.next;
        }
        // step2: reverse
        ListNode post = cur.next;
        for(int i = 0; i < n - m; i++){
            post = post.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = post;
        }
        return safeGuard.next;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
