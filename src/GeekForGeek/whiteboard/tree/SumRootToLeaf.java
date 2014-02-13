package GeekForGeek.whiteboard.tree;

import leetcode.data.TreeNode;

public class SumRootToLeaf {
	
	public static int totalSum = 0;
	public void sumRootToLeaf(TreeNode root, int curSum){
		if(root == null)
			return;
		curSum = 10 * curSum + root.val;
		if(root.left == null && root.right == null){
			totalSum += curSum;
			return;
		}
		if(root.left != null)
			sumRootToLeaf(root.left, curSum);
		if(root.right != null)
			sumRootToLeaf(root.right, curSum);
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree("632##57##4##5#4##");
		SumRootToLeaf s = new SumRootToLeaf();
		s.sumRootToLeaf(root, 0);
		System.out.println(totalSum);
	}

}
