package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class FindDeepestLeftLeaf {

	int deepestLevel = 0;
	public static TreeNode deepestLeftLeaf = null;

	public void findDeepestLeftLeaf(TreeNode root, int level, boolean isLeft) {
		if (root == null)
			return;

		if (root.left == null && root.right == null && isLeft) {
			if (deepestLevel < level) {
				deepestLevel = level;
				deepestLeftLeaf = root;
			}
			return;
		}
		findDeepestLeftLeaf(root.left, level + 1, true);
		findDeepestLeftLeaf(root.right, level + 1, false);
	}

	public static void main(String[] args) {
		test("521##43###6#87##9##");
	}
	
	public static void test(String str){
		FindDeepestLeftLeaf fdll = new FindDeepestLeftLeaf();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		fdll.findDeepestLeftLeaf(root, 0, true);
		System.out.println(deepestLeftLeaf.val);
	}
}
