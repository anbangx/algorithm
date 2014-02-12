package GeekForGeek.whiteboard;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeNode;

public class PrintLevelOrder {
	
	public void printLevelOrder(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode cur = q.poll();
			System.out.println(cur.val);
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null)
				q.add(cur.right);
		}
	}
	
	public static void main(String[] args) {
		PrintLevelOrder p = new PrintLevelOrder();
		TreeNode root = TreeNode.constructTree("124###35##6##");
		p.printLevelOrder(root);
	}

}
