package leetcode.data;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    
    public static ListNode convertArrayToLinkedList(int[] A){
        if(A == null || A.length == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i = 0; i < A.length; i++){
            ListNode newNode = new ListNode(A[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        return dummy.next;
    }
    
    public static void print(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
    
    public String toString(){
        return Integer.toString(this.val);
    }
}
