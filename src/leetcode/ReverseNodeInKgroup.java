package leetcode;

public class ReverseNodeInKgroup {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;
        ListNode safeGuard = new ListNode(-1);
        safeGuard.next = head;
        ListNode preCursor = safeGuard;
        ListNode endCursor;
        boolean stop = false;
        while(preCursor.next != null){
            endCursor = preCursor.next;
            for(int i = 1; i < k; i++){
                if(endCursor.next == null){
                    stop = true;
                    break;
                }
                endCursor = endCursor.next;
            }
            if(!stop){
                ListNode start = preCursor.next;
                reverse(preCursor, endCursor, start);
                endCursor = start;
            }
            preCursor = endCursor;
        }
        return safeGuard.next;
    }
    
    public void reverse(ListNode prev, ListNode end, ListNode start){
        ListNode c1 = prev.next;
        ListNode c2 = c1.next;
        ListNode next = end.next;
        
        while(c2 != next){
            ListNode temp = c2.next;
            c2.next = c1;
            c1 = c2;
            c2 = temp;
        }
        
        prev.next = end;
        start.next = next;
    }
    
    public static void main(String[] args) {
        ReverseNodeInKgroup rn = new ReverseNodeInKgroup();
        ListNode prev = new ListNode(-1);
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
//        ListNode c = new ListNode(4);
//        prev.next = head;
        head.next = a;
        a.next = b;
        rn.reverseKGroup(head, 2);
//        b.next = c;
//        rn.reverse(prev, a);
        ListNode cursor = prev.next;
        while(cursor != null){
            System.out.println(cursor.val);
            cursor = cursor.next;
        }
    }

}
