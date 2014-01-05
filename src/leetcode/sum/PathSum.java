package leetcode.sum;

import leetcode.TreeNode;

public class PathSum {
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val == sum;
            
        if(root.left != null){
            if(hasPathSum(root.left, sum - root.val))
                return true;
        }
        if(root.right != null){
            if(hasPathSum(root.right, sum - root.val))
                return true;
        }
        
        return false;
    }
}
