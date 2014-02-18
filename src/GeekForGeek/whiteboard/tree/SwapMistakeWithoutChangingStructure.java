package GeekForGeek.whiteboard.tree;

import leetcode.data.TreeNode;

public class SwapMistakeWithoutChangingStructure {
	
	public TreeNode pre = null;
	public TreeNode big = null;
	public TreeNode small = null;
	public void findMistake(TreeNode root){
		if(root == null)
			return;
		findMistake(root.left);
		if(pre != null && big == null && pre.val > root.val){
			big = pre;
		}
		else if(pre != null && big != null && pre.val > root.val){
			small = root;
			return;
		}
		pre = root;
		findMistake(root.right);
	}
	
	public void swapVal(TreeNode A, TreeNode B){
		int temp = A.val;
		A.val = B.val;
		B.val = temp;
	}
	
	public void swapMistake(TreeNode root){
		findMistake(root);
		swapVal(big, small);
	}
	
	public static void main(String[] args) {
		SwapMistakeWithoutChangingStructure swap = new SwapMistakeWithoutChangingStructure();
//		TreeNode root = TreeNode.constructTree("531##6##4##");
//		swap.swapMistake(root);
		TreeNode root = TreeNode.constructTreeByPreorder("135##4##6##");
		swap.swapMistake(root);
	}

}
