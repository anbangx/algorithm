package leetcode.tree.traversal;

import java.util.ArrayList;

import leetcode.data.TreeNode;

public class BinaryTreePostorderTraversal {
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(root == null)
            return results;
        results.addAll(postorderTraversal(root.left));
        results.addAll(postorderTraversal(root.right));
        results.add(root.val);
        return results;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
