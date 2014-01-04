package leetcode.math;

import leetcode.ListNode;

public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode safeGuard = new ListNode(-1);
        ListNode output = safeGuard;
        int carry = 0;
        int ai = 0;
        int bi = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                ai = l1.val;
                l1 = l1.next;
            } else
                ai = 0;
            if(l2 != null){
                bi = l2.val;
                l2 = l2.next;
            } else
                bi = 0;
            int val = (ai + bi + carry) % 10;
            carry = (ai + bi + carry) / 10;
            output.next = new ListNode(val);
            output = output.next;
        }
        if(carry == 1)
            output.next = new ListNode(1);
        return safeGuard.next;
    }
    
    public static void main(String[] args) {

    }

}
