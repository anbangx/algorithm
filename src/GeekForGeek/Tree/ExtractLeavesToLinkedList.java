package GeekForGeek.Tree;

import leetcode.data.TreeLinkNode;

public class ExtractLeavesToLinkedList {
	
	public static TreeLinkNode headRef = new TreeLinkNode(-1);
	public TreeLinkNode extractLeaves(TreeLinkNode root){
	    if(root == null)
	        return null;

	    if(root.left == null && root.right == null){
	        if(headRef.next != null)
	            root.next = headRef.next;

	        headRef.next = root;
	        return null;
	    }
	    root.right = extractLeaves(root.right);
	    root.left = extractLeaves(root.left);
	    return root;
	}
	
	public static void main(String[] args) {
		ExtractLeavesToLinkedList el = new ExtractLeavesToLinkedList();
		TreeLinkNode l1 = new TreeLinkNode(1);
		TreeLinkNode l21 = new TreeLinkNode(2);
		TreeLinkNode l22 = new TreeLinkNode(3);
		l1.left = l21; l1.right = l22;
		TreeLinkNode l31 = new TreeLinkNode(4);
		TreeLinkNode l34 = new TreeLinkNode(6);
		l21.left = l31;
		l22.right = l34;
		el.extractLeaves(l1);
		TreeLinkNode cur = headRef.next;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

}
