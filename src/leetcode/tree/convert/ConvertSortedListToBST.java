package leetcode.tree.convert;

import leetcode.data.ListNode;
import leetcode.data.TreeNode;

public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode cursor = head;
        int n = 0;
        while (cursor != null) {
            cursor = cursor.next;
            n++;
        }
        TreeNode output = convert(head, 0, n - 1);
        return output;
    }

    public TreeNode convert(ListNode head, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode left = convert(head, start, mid - 1);
        TreeNode parent = new TreeNode(head.val);
        parent.left = left;
//        head = head.next;
        if (head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        TreeNode right = convert(head, mid + 1, end);
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
