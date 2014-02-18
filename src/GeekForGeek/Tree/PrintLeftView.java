package GeekForGeek.Tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeNode;

public class PrintLeftView {

	public void printLeftView(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int preLevel = 1;
		int curLevel = 0;
		while (!q.isEmpty()) {
			boolean print = false;
			curLevel = 0;
			while (preLevel != 0) {
				TreeNode cur = q.poll();
				if (!print){
					System.out.println(cur.val);
					print = true;
				}
				if (cur.left != null) {
					q.add(cur.left);
					curLevel++;
				}
				if (cur.right != null) {
					q.add(cur.right);
					curLevel++;
				}
				preLevel--;
			}
			preLevel = curLevel;
		}
	}
	
	public static void main(String[] args) {
		test("521##43###6#87##9##");
	}
	
	public static void test(String str){
		PrintLeftView plv = new PrintLeftView();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		plv.printLeftView(root);
	}

}
