package leetcode.list.reconstruct;

import leetcode.data.ListNode;

public class ReorderList {
    
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null)
            return;
        ListNode p = head;
        int len = 0;
        while(p != null){
            p = p.next;
            len++;
        }
        // step1: Find the middle pointer of the linked list
        int numInsertion = len / 2;
        int numRemaining = len - numInsertion;
        p = head;
        for(int i = 0; i < numRemaining - 1; i++){
            p = p.next;
        }
        // step2: Reverse the second part of the linked list(from middle->next to the end)
        ListNode pre = p;
        ListNode cur = pre.next;
        ListNode post = cur.next;
        while(post != null){
            cur.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = cur.next;
        }
        // step3:  Do the reordering. (inset every element in the second part in between the elements in the first part)
        ListNode reverseHead = p.next;
        p.next = null;
        p = head;
        while(reverseHead != null){
            ListNode temp = reverseHead.next;
            reverseHead.next = p.next;
            p.next = reverseHead;
            reverseHead = temp;
            p = p.next.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
