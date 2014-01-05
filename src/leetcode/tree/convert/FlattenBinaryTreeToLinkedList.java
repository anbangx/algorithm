package leetcode.tree.convert;

import leetcode.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    
    public TreeNode flatten(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return null;
        TreeNode rHead = flatten(root.right);
        TreeNode p = root;
        if(root.left != null){
            TreeNode lHead = flatten(root.left);
            root.right = lHead;
            root.left = null;
            while(p.right != null){
                p = p.right;
            }
        }
        p.right = rHead;
        return root;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
