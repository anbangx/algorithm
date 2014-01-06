package leetcode.list.remove;

import leetcode.data.ListNode;

public class RemoveDuplicateFromSortedLinkedList {
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        
        int lastItem = head.val;
        ListNode cursor = head;
        while(cursor.next != null){
            if(cursor.next.val == lastItem)
                cursor.next = cursor.next.next;
            else{
                cursor = cursor.next;
                lastItem = cursor.val;
            }                
        }
        return head;
    }
    
    public static void main(String[] args) {
    }

}
