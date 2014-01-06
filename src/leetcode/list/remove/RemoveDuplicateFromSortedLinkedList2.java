package leetcode.list.remove;

import leetcode.data.ListNode;

public class RemoveDuplicateFromSortedLinkedList2 {
    
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        ListNode safeGuard = new ListNode(0);
        safeGuard.next = head;
        
        ListNode n1=safeGuard;
        while(n1.next!=null){
            ListNode n2=n1.next;
            while(n2.next!=null && n2.next.val==n2.val){
                n2=n2.next;
            }
            if(n2!=n1.next){
                n1.next=n2.next;
            }else{
                n1=n1.next;   
            }
        }
        return safeGuard.next;
    }
    
    public static void main(String[] args) {
        RemoveDuplicateFromSortedLinkedList2 rd = new RemoveDuplicateFromSortedLinkedList2();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        head.next = second;
        second.next = third;
        rd.deleteDuplicates(head);
    }

}
