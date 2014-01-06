package leetcode.sum;
import java.util.ArrayList;

import leetcode.data.TreeNode;


public class PathSum2 {
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(root.val);
                results.add(result);
            } 
            return results;
        }
          
        if(root.left != null){
            ArrayList<ArrayList<Integer>>  leftResults = pathSum(root.left, sum - root.val);
            if(leftResults.size() != 0){
                for(ArrayList<Integer> result : leftResults){
                    result.add(0, root.val);
                }
                results.addAll(leftResults);
            }
        }
        if(root.right != null){
            ArrayList<ArrayList<Integer>> rightResults = pathSum(root.right, sum - root.val);
            if(rightResults.size() != 0){
                for(ArrayList<Integer> result : rightResults){
                    result.add(0, root.val);
                }
                results.addAll(rightResults);
            }
        }
        return results;
    }
    
    public static void main(String[] args) {
        PathSum2 ps = new PathSum2();
        TreeNode root = new TreeNode(0);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(1);
        root.left = second;
        root.right = third;
        System.out.println(ps.pathSum(root, 1));
    }

}
