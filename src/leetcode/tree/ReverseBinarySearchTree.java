package leetcode.tree;

import leetcode.data.TreeNode;

public class ReverseBinarySearchTree {
    
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        else{
            inOrder(root.left);
            if(prev == null)
                prev = root;
            else{
                if(prev.val > root.val){
                    if(first == null)
                        first = prev;
                    second = root;
                }
                prev = root;
            }
            inOrder(root.right);
        }
        
    }
    
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public static void main(String[] args) {
        ReverseBinarySearchTree rbst = new ReverseBinarySearchTree();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        rbst.recoverTree(root);
    }

}
