package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        
        // BFS
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
        
        return results;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
