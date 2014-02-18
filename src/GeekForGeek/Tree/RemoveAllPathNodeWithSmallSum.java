package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class RemoveAllPathNodeWithSmallSum {
	
	public TreeNode removePathNodes(TreeNode root, int k, Sum sum){
	    if(root == null)     return null;

	    Sum lSum = new Sum(sum.val + root.val);
	    Sum rSum = new Sum(sum.val + root.val);

	    root.left = removePathNodes(root.left, k, lSum);
	    root.right = removePathNodes(root.right, k, rSum);

	    int maxSum = Math.max(lSum.val, rSum.val);
	    if(root.left == null && root.right == null && maxSum < k){
	        root = null;
	    }

	    return root;

	}    
	
	public static void main(String[] args) {
		test("521##43###6#87##9##");
	}
	
	public static void test(String str){
		RemoveAllPathNodeWithSmallSum rpn = new RemoveAllPathNodeWithSmallSum();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		TreeNode res = rpn.removePathNodes(root, 28, new Sum(0));
		TreeNode.printTree(res);
	}

}

class Sum{
	int val;
	public Sum(int val){
		this.val = val;
	}
}