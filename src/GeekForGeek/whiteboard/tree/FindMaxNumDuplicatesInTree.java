package GeekForGeek.whiteboard.tree;

import leetcode.data.TreeNode;

public class FindMaxNumDuplicatesInTree {
	
	public TreeNode pre = null;
	public static int maxCount = Integer.MIN_VALUE;
	public static int maxNumVal = Integer.MIN_VALUE;
	
	public void inorder(TreeNode root, int curCount){
		if(root == null)
			return;
		inorder(root.left, curCount);
		if(pre != null && pre.val == root.val){
			curCount++;
			if(curCount > maxCount){
				maxCount = curCount;
				maxNumVal = root.val;
			}
		}
		pre = root;
		inorder(root.right, curCount);
	}
	
	public static void main(String[] args) {
		FindMaxNumDuplicatesInTree fmn = new FindMaxNumDuplicatesInTree();
		TreeNode root = TreeNode.constructTreeByPreorder("554##5##87##9##");
		fmn.inorder(root, 0);
		System.out.println(maxNumVal);
	}

}
