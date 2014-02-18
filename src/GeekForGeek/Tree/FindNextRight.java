package GeekForGeek.Tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeNode;

public class FindNextRight {

	public TreeNode findNextRight(TreeNode root, TreeNode node) {
		if (node == null)
			return null;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int preLevel = 1;
		int curLevel = 0;
		while (!q.isEmpty()) {
			TreeNode pre = null;
			curLevel = 0;
			while (preLevel != 0) {
				TreeNode cur = q.poll();
				if (cur.val == node.val) {
					return pre;
				}
				if (cur.right != null) {
					q.add(cur.right);
					curLevel++;
				}
				if (cur.left != null) {
					q.add(cur.left);
					curLevel++;
				}
				pre = cur;
			}
			preLevel = curLevel;
		}
		return null;
	}

	public static void main(String[] args) {
		test("521##43###6#87##9##");
	}
	
	public static void test(String str){
		FindNextRight fnr = new FindNextRight();
		TreeNode root = TreeNode.constructTreeByPreorder(str);
		TreeNode.printTree(root);
		TreeNode ans = fnr.findNextRight(root, new TreeNode(2));
		System.out.println(ans.val);
	}

}
