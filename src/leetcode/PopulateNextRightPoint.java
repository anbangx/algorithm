package leetcode;

import leetcode.data.TreeLinkNode;

public class PopulateNextRightPoint {

    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // base case
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            if (root.right != null)
                root.left.next = root.right;
            else {
                TreeLinkNode cursor = root;
                while (cursor.next != null) {
                    if (cursor.next.left != null) {
                        root.left.next = cursor.next.left;
                        break;
                    } else if (cursor.next.right != null) {
                        root.left.next = cursor.next.right;
                        break;
                    }
                    cursor = cursor.next;
                }
            }
        }
        if (root.right != null) {
            TreeLinkNode cursor = root;
            while (cursor.next != null) {
                if (cursor.next.left != null) {
                    root.right.next = cursor.next.left;
                    break;
                } else if (cursor.next.right != null) {
                    root.right.next = cursor.next.right;
                    break;
                }
                cursor = cursor.next;
            }
        }
        connect(root.left);
        connect(root.right);
    }

}
