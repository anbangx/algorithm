package GeekForGeek.Tree;

import leetcode.data.TreeNode;

public class GetDiffBetweenOddEvenLevel {
	
	public static int oddSum = 0;
	public static int evenSum = 0;

	public void getOddEvenSum(TreeNode root, int level){
	    if(root == null)    return;

	    if(level % 2 == 0)
	        evenSum += root.val;
	    else
	        oddSum += root.val;

	    getOddEvenSum(root.left, level + 1);
	    getOddEvenSum(root.right, level + 1);
	}
	
	public static void main(String[] args) {
		test("521##43###6#87##9##");
	}
	
	public static void test(String str){
		GetDiffBetweenOddEvenLevel agv = new GetDiffBetweenOddEvenLevel();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		agv.getOddEvenSum(root, 0);
		System.out.println(Math.abs(oddSum - evenSum));
	}
}
