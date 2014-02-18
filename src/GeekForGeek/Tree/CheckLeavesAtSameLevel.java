package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class CheckLeavesAtSameLevel {
	
	int leafLevel = -1;

	public boolean checkAtSameLevel(TreeNode root, int level){
	    if(root  == null)    return true;

	    if(root.left == null && root.right == null){
	        if(leafLevel == -1){
	        	leafLevel = level;
	    		return true;
        	}
	        else{
	            return leafLevel == level;
	        }
	    }
	    return checkAtSameLevel(root.left, level + 1) && checkAtSameLevel(root.right, level + 1);
	}
	    
	    
	public static void main(String[] args) {
		test("543###6#7##");
		test("543###6##");
	}
	
	public static void test(String str){
		CheckLeavesAtSameLevel clas = new CheckLeavesAtSameLevel();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		System.out.println(clas.checkAtSameLevel(root, 0));
	}
}
