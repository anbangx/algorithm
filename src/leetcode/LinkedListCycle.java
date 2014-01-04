package leetcode;

public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null)
            return false;
        if(head.next == head)
            return true;
        head.next = head.next.next;
        return hasCycle(head); 
    }
    
    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        second.next = head;
        System.out.println(llc.hasCycle(head));
    }

}
