package leetcode.list.cyclefinding;

import leetcode.data.ListNode;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(true){
            if(fast.next != null)
                fast = fast.next.next; // 2 hops
            else
                return null;
            
            slow = slow.next; // 1 hop
            
            if(slow == null || fast == null)
                return null;
            if(fast == slow){
                break;
            }
        }
        fast = head;
        while(true){
            if(fast == slow)
                return slow;
            fast = fast.next;
            slow = slow.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
