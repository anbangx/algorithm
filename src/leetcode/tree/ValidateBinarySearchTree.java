package leetcode.tree;

import leetcode.data.TreeNode;

public class ValidateBinarySearchTree {
    
    public boolean isValidBST(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return true;
        if(root.left != null){
            TreeNode cursor = root.left;
            while(cursor.right != null)
                cursor = cursor.right;
            if(cursor.val >= root.val)
                return false;
        }
        if(root.right != null){
            TreeNode cursor = root.right;
            while(cursor.left != null)
                cursor = cursor.left;
            if(cursor.val <= root.val)
                return false;
        } 
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
