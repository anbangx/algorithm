package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class PrintAncestors {

	public boolean printAncestors(TreeNode root, int target){
		if(root == null)    return false;

		if(root.val == target){
			System.out.println(root.val);
			return true;
		}
		
		if(printAncestors(root.left, target) || printAncestors(root.right, target)){
			System.out.println(root.val);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		test("521##43###6#87##9##");
	}
	
	public static void test(String str){
		PrintAncestors pa = new PrintAncestors();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		pa.printAncestors(root, 4);
	}

}
