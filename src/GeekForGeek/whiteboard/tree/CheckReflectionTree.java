package GeekForGeek.whiteboard.tree;

import leetcode.data.TreeNode;

public class CheckReflectionTree {
	
	public boolean checkReflectionTree(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		if((root1 == null && root2 != null)
				|| (root1 != null && root2 == null))
			return false;
	
		if(root1.val != root2.val)
			return false;
		if(!checkReflectionTree(root1.left, root2.right))
			return false;
		if(!checkReflectionTree(root1.right, root2.left))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root1 = TreeNode.constructTreeByPreorder("12#3###");
		TreeNode root2 = TreeNode.constructTreeByPreorder("1#23###");
		CheckReflectionTree crt = new CheckReflectionTree();
		System.out.println(crt.checkReflectionTree(root1, root2));
	}

}
