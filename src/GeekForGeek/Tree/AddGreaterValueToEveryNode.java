package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class AddGreaterValueToEveryNode {
	
	int preSum = 0;
	public void addGreaterValues(TreeNode root){
	    if(root == null)
	        return;

	    addGreaterValues(root.right);
	    preSum += root.val;
	    root.val = preSum;

	    addGreaterValues(root.left);
	}
	
	public static void main(String[] args) {
		test("21##3##");
	}
	
	public static void test(String str){
		AddGreaterValueToEveryNode agv = new AddGreaterValueToEveryNode();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		agv.addGreaterValues(root);
		TreeNode.printTree(root);
	}
}
