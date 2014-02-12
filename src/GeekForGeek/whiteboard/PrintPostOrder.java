package GeekForGeek.whiteboard;

import java.util.Stack;

import leetcode.data.TreeNode;

public class PrintPostOrder {
	
	public void printPostOrderIteratively(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		
		TreeNode pre = null;
		while(!stack.isEmpty()){
			TreeNode cur = stack.peek();
			if((cur.left == null && cur.right == null)
					|| (cur.right == null && pre != null && cur.left == pre)
					|| (cur.right != null && pre != null && cur.right == pre)){
				stack.pop();
				System.out.println(cur.val);
			} else {
				if(cur.right != null)
					stack.push(cur.right);
				if(cur.left != null)
					stack.push(cur.left);
			}
			pre = cur;
		}
	}
	
	public static void main(String[] args) {
		PrintPostOrder ppp = new PrintPostOrder();
		TreeNode root = TreeNode.constructTree("124###35##6##");
		ppp.printPostOrderIteratively(root);
		System.out.println("-------------------");
		root = TreeNode.constructTree("135##4##6##");
		ppp.printPostOrderIteratively(root);
	}

}
