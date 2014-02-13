package GeekForGeek.whiteboard.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeLinkNode;

public class ConnectNodesAtSameLevel {
	
	public void connect(TreeLinkNode root){
		if(root == null)
			return;
		
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.add(root);
		while(!q.isEmpty()){
			ArrayList<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
			while(!q.isEmpty()){
				level.add(q.poll());
			}
			for(int i = 0; i < level.size(); i++){
				TreeLinkNode cur = level.get(i);
				if(cur.right != null)
					q.add(cur.right);
				if(cur.left != null)
					q.add(cur.left);
			}
			for(int i = 1; i < level.size(); i++){
				level.get(i).next = level.get(i - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeLinkNode l1 = new TreeLinkNode(1);
		TreeLinkNode l21 = new TreeLinkNode(2);
		TreeLinkNode l22 = new TreeLinkNode(3);
		l1.left = l21;
		l1.right = l22;
		TreeLinkNode l31 = new TreeLinkNode(4);
		l21.left = l31;
		TreeLinkNode l34 = new TreeLinkNode(5);
		l22.right = l34;
		ConnectNodesAtSameLevel c = new ConnectNodesAtSameLevel();
		c.connect(l1);
		System.out.println();
	}

}
