package GeekForGeek.whiteboard.tree;

import leetcode.data.TreeNode2;

public class InorderSuccessorWithParent {
	
	public TreeNode2 inorderSuccessor(TreeNode2 node){
		if(node.right != null){
			TreeNode2 cur = node.right;
			while(cur.left != null)
				cur = cur.left;
			return cur;
		} else{
			TreeNode2 pre = node;
			TreeNode2 cur = node.parent;
			while(cur != null && cur.left != pre){
				pre = cur;
				cur = cur.parent;
			}
			return cur;
		}
	}
	
	public static void main(String[] args) {
		InorderSuccessorWithParent is = new InorderSuccessorWithParent();
		TreeNode2 l1 = new TreeNode2(20);
		TreeNode2 l21 = new TreeNode2(8);
		TreeNode2 l22 = new TreeNode2(22);
		l1.left = l21;	l21.parent = l1;
		l1.right = l22;	l22.parent = l1;
		TreeNode2 l31 = new TreeNode2(4);
		TreeNode2 l32 = new TreeNode2(12);
		l21.left = l31;	l31.parent = l21;
		l21.right = l32;	l32.parent = l21;
		TreeNode2 l43 = new TreeNode2(10);
		TreeNode2 l44 = new TreeNode2(14);
		l32.left = l43;	l43.parent = l32;
		l32.right = l44;	l44.parent = l32;
		
		TreeNode2 result = is.inorderSuccessor(l31);
		System.out.println(result != null ? result.val : -1);
	}

}
