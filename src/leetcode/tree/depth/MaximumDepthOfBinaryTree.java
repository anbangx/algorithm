package leetcode.tree.depth;

import leetcode.data.TreeNode;

public class MaximumDepthOfBinaryTree {
    
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // base case
        if(root == null)
            return 0;
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        return 1 + (maxLeftDepth > maxRightDepth ? maxLeftDepth : maxRightDepth); 
    }
    
    public static void main(String[] args) {

    }

}
