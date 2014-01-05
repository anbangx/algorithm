package leetcode.tree;

import leetcode.TreeNode;

public class SymmetricTree {
    
    public boolean isSymmetric(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return true;

        return compareSym(root.left, root.right);
    }
    
    public boolean compareSym(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        
        return compareSym(left.left, right.right) && compareSym(left.right, right.left);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
