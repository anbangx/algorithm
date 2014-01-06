package leetcode.list.cyclefinding;

import leetcode.data.ListNode;


public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(true){
            if(fast.next != null)
                fast = fast.next.next; // 2 hops
            else
                return false;
            
            slow = slow.next; // 1 hop
            
            if(slow == null || fast == null)
                return false;
            if(fast == slow)
                return true;
        }
    }
    
    public static void main(String[] args) {

    }

}
