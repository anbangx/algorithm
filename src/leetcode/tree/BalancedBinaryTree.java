package leetcode.tree;

import leetcode.TreeNode;

public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
            
        return getBalanced(root) != -1;
    }
    
    public int getBalanced(TreeNode root){
        if(root == null)
            return 0;
        
        // left, right record the height of a node if balanced, otherwise record fail
        int left = getBalanced(root.left);
        int right = getBalanced(root.right);
        if(left == -1 || right == -1)  return -1;
        if(left - right > 1 || right - left > 1)
            return -1;
        return left > right ? left + 1 : right + 1;  
    }
    
    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(6);
        TreeNode left2 = new TreeNode(8);
        TreeNode right = new TreeNode(10);
        root.left = left;
        root.right = right;
        root.left.left = left2;
        System.out.println(bbt.getBalanced(root));
    }

}
