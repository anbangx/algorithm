package leetcode.list.remove;

import leetcode.ListNode;

public class RemoveNthNodeFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return null;
        if(head.next == null){
            if(n == 0)
                return head;
            else
                return head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        for(int i = 0; i < n; i++)
            cur = cur.next;
        while(cur != null && cur.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        if(pre != head)
            pre.next = pre.next.next;
        else
            head = head.next;
        return head;
    }
    
    public static void main(String[] args) {
        RemoveNthNodeFromEnd rn = new RemoveNthNodeFromEnd();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        System.out.println(rn.removeNthFromEnd(head, 1));
    }

}
