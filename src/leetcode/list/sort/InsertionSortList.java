package leetcode.list.sort;

import leetcode.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        
        ListNode safeGuard = new ListNode(-1);
        safeGuard.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        
        while(next != null){
            if(cur.val > next.val){
                // find insert position
                ListNode preInsert = safeGuard;
                ListNode insert = safeGuard.next;
                while(insert.val < next.val){
                    preInsert = preInsert.next;
                    insert = insert.next;
                }
                cur.next = next.next;
                next.next = insert;
                preInsert.next = next;
                next = cur.next;
            } else {
                cur = next;
                next = next.next;
            }
        }
        return safeGuard.next;
    }
    
    public ListNode covertToLinkedList(int[] array){
        ListNode safeGuard = new ListNode(-1);
        ListNode cursor = safeGuard;
        for(int i = 0; i < array.length; i++){
            ListNode temp = new ListNode(array[i]);
            cursor.next = temp;
            cursor = cursor.next;
        }
        return safeGuard.next;
    }
    
    public void printLinkedList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        int[] array = {4,19,14,5,-3,1,8,5,11,15};
        isl.printLinkedList(isl.insertionSortList(isl.covertToLinkedList(array)));
    }

}
