package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curLevel = 0;
        int nextLevel = 1;
        TreeNode cur;
        
        while(nextLevel > 0){
            curLevel = nextLevel;
            nextLevel = 0;
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 0; i < curLevel; i++){
                cur = queue.poll();
                result.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                    nextLevel++;
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    nextLevel++;
                }
            }
            results.add(result);
        }
        
        ArrayList<ArrayList<Integer>> reverseResults = new ArrayList<ArrayList<Integer>>();
        for(int i = results.size() - 1; i >= 0; i--)
            reverseResults.add(results.get(i));
        return reverseResults;
    }
    
    public static void main(String[] args) {

    }

}
