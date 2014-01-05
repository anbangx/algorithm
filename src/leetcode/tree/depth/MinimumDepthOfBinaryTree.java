package leetcode.tree.depth;

import leetcode.TreeNode;

public class MinimumDepthOfBinaryTree {
    
    public int minDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left == null && root.right != null)
            return right + 1;
        else if(root.left != null && root.right == null)
            return left + 1;
        else if(root.left != null && root != null)
            return (left < right ? left : right) + 1;
        else
            return 1;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
