package Amazon;

import java.awt.List;

import leetcode.data.ListNode;

public class AddTwoNumberRepresentedByLinkedList {
    
    public ListNode addTwoNumber(ListNode head1, ListNode head2){
        if(head1 == null && head2 == null)
            return null;
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;
        while(ptr1 != null && ptr2 != null){
            int val = (ptr1.val + ptr2.val + carry) % 10;
            carry = (ptr1.val + ptr2.val + carry) / 10;
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr1 != null){
            int val = (ptr1.val + carry) % 10;
            carry = (ptr1.val + carry) / 10;
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            int val = (ptr2.val + carry) % 10;
            carry = (ptr2.val + carry) / 10;
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;
            ptr2 = ptr2.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        int[] A = {5, 6, 3, 4};
        int[] B = {8, 4, 8};
        ListNode head1 = ListNode.convertArrayToLinkedList(A);
        ListNode head2 = ListNode.convertArrayToLinkedList(B);
        AddTwoNumberRepresentedByLinkedList atn = new AddTwoNumberRepresentedByLinkedList();
        ListNode.print(atn.addTwoNumber(head1, head2));
    }
}
