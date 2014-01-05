package leetcode.tree.traversal;

import java.util.ArrayList;

import leetcode.TreeNode;

public class BinaryTreePreorderTraversal {
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(root == null)
            return results;
        results.add(root.val);
        results.addAll(preorderTraversal(root.left));
        results.addAll(preorderTraversal(root.right));
        return results;
    }
    
    public static void main(String[] args) {

    }

}
