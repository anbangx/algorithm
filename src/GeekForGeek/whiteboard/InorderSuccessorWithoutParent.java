package GeekForGeek.whiteboard;

import leetcode.data.TreeNode;

public class InorderSuccessorWithoutParent {
	
	public TreeNode getInorderSuccessor(TreeNode root, TreeNode node){
		if(root == null)
			return null;
		TreeNode cur = null;
		if(node.right != null){
			cur = node.right;
			while(cur.left != null)
				cur = cur.left;
			return cur;
		}
		
		TreeNode succ = null;
		cur = root;
		while(cur != null){
			if(node.val < cur.val){
				succ = cur;
				cur = cur.left;
			} else if(node.val > cur.val){
				cur = cur.right;
			} else
				break;
		}
		return succ;
	}
	
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(20);
		TreeNode l21 = new TreeNode(8);
		TreeNode l22 = new TreeNode(22);
		l1.left = l21;
		l1.right = l22;
		TreeNode l31 = new TreeNode(4);
		TreeNode l32 = new TreeNode(12);
		l21.left = l31;
		l21.right = l32;
		TreeNode l43 = new TreeNode(10);
		TreeNode l44 = new TreeNode(14);
		l32.left = l43;
		l32.right = l44;
		
		InorderSuccessorWithoutParent is = new InorderSuccessorWithoutParent();
		TreeNode result = is.getInorderSuccessor(l1, l32);
		System.out.println(result);
	}

}
