package leetcode.secondround;

import java.util.ArrayList;
import java.util.Stack;

import GeekForGeek.Tree.PrintLeftView;

import leetcode.data.TreeNode;

public class PreoderTraversal {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)    return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        return result;
    }
	
	public static void main(String[] args) {
		test("231####");
	}
	
	public static void test(String str){
		PreoderTraversal pt = new PreoderTraversal();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		ArrayList<Integer> result = pt.preorderTraversal(root);
		System.out.println(result);
	}

}
