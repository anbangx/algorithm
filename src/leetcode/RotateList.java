package leetcode;

public class RotateList {
    
    public ListNode rotateRight(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        if(length == 0)
            return head;
        
        n = n % length;
        if(n == 0 || n == length)
            return head;
        ListNode prev = null; 
        cur = head;
        int i;
        for(i = 0; i < length - n; i++){
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        ListNode newHead = cur; 
        while(cur.next != null)
            cur = cur.next;
        cur.next = head;
        
        return newHead;
    }
    
    public static void main(String[] args) {
        RotateList rl = new RotateList();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
         
        System.out.println(rl.rotateRight(head, 1)); 
    }

}
