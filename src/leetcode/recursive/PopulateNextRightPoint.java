package leetcode.recursive;

import leetcode.data.TreeLinkNode;

public class PopulateNextRightPoint {

    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // base case
        if(root == null)
            return;
        if(root.left == null || root.right == null)
            return;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

}
