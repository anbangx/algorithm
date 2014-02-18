package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class FindDeepestOddLevelLeaf {

	int deepestLevel = 0;
	TreeNode deepestLeftLeaf = null;

	public void findDeepestLeftLeaf(TreeNode root, int level){
	    if(root == null)
	        return;

	    if(root.left == null && root.right == null && level%2 == 1){
	        if(deepestLevel < level){
	            deepestLevel = level;
	            deepestLeftLeaf = root;
	        }
	        return;
	    }

	    findDeepestLeftLeaf(root.left, level + 1);
	    findDeepestLeftLeaf(root.right, level + 1);

	}

	public static void main(String[] args) {

	}

}
