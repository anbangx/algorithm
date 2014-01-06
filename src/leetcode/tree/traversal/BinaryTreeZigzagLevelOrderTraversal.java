package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.Stack;

import leetcode.data.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        Stack<TreeNode> curStack;
        Stack<TreeNode> nextStack = new Stack<TreeNode>();
        nextStack.push(root);
        int step = 1; // odd: right to left
        while(true){
            curStack = (Stack<TreeNode>) nextStack.clone();
            nextStack.clear();
            if(curStack.isEmpty())
                break;
            ArrayList<Integer> candidate = new ArrayList<Integer>();
            while(!curStack.isEmpty()){
                TreeNode p = curStack.pop();
                candidate.add(p.val);
                if(step % 2 == 0){ // right to left
                    if(p.right != null)
                        nextStack.push(p.right);
                    if(p.left != null)
                        nextStack.push(p.left);
                } else {
                    if(p.left != null)
                        nextStack.push(p.left);
                    if(p.right != null)
                        nextStack.push(p.right);
                }
            } 
            results.add(candidate);
            step++;
        }
        return results;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
