package leetcode.merge;

import leetcode.data.ListNode;

public class MergeTwoSortedLists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode head = null;
        if(l1 == null && l2 == null)
            return head;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        if(l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else{
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
    
    public static void main(String[] args) {
    }

}
