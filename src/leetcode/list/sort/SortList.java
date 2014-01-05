package leetcode.list.sort;

import leetcode.ListNode;

public class SortList {
    
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        int len = 0;
        ListNode cursor = head;
        while(cursor != null){
            len++;
            cursor = cursor.next;
        }
        return sort(head, len);
    }
    
    public ListNode sort(ListNode head, int len){
        if(len == 1){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
        // partition
        ListNode nextHalf = head;
        for(int i = 0; i < len/2; i++)
            nextHalf = nextHalf.next;
        ListNode leftHead = sort(head, len/2);
        ListNode rightHead = sort(nextHalf, len - len/2);
        // merge
        ListNode mergedHead = merge(leftHead, rightHead);
        
        return mergedHead;
    }
    
    public ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode mergedHead = new ListNode(0);
        ListNode cursor = mergedHead;
        while(leftHead != null || rightHead != null){
            if(leftHead == null){
                ListNode temp = new ListNode(rightHead.val);
                cursor.next = temp;
                cursor = temp;
                rightHead = rightHead.next;
            } else if(rightHead == null){
                ListNode temp = new ListNode(leftHead.val);
                cursor.next = temp;
                cursor = temp;
                leftHead = leftHead.next;
            } else if(leftHead.val < rightHead.val){
                ListNode temp = new ListNode(leftHead.val);
                cursor.next = temp;
                cursor = temp;
                leftHead = leftHead.next;
            } else {
                ListNode temp = new ListNode(rightHead.val);
                cursor.next = temp;
                cursor = temp;
                rightHead = rightHead.next;
            }               
        }
        return mergedHead.next;
    }
    
    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head = new ListNode(2);
        ListNode first = new ListNode(1);
        head.next = first;
        System.out.println(sl.sortList(head));
    }

}
