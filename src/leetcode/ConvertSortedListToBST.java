package leetcode;
import java.util.ArrayList;


public class ConvertSortedListToBST {
    
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return null;
        ListNode cursor = head;
        int n = 0;
        while(cursor != null){
            cursor = cursor.next;
            n++;
        }
        ArrayList<ListNode> headReference = new ArrayList<ListNode>(1);
        headReference.add(head);
        TreeNode output = convert(headReference, 0, n-1);
        return output;
    }   
    
    public TreeNode convert(ArrayList<ListNode> headReference, int start, int end){
        if(start > end)
            return null;
        int mid = start + (end - start)/2;
        TreeNode left = convert(headReference, start, mid - 1);
        TreeNode parent = new TreeNode(headReference.get(0).val);
        parent.left = left;
        headReference.set(0, headReference.get(0).next);
        TreeNode right = convert(headReference, mid + 1, end);
        parent.right = right;
        
        return parent;
    }
    
    public static void main(String[] args) {
        ConvertSortedListToBST cs = new ConvertSortedListToBST();
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(8);
        head.next = second;
        second.next = third;
        cs.sortedListToBST(head);
    }

}
