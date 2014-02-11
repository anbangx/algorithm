package GeekForGeek.Interview;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.TreeNode;

public class SerializeDeserializeTree {
	
	TreeNode deserialize(String input) {
		TreeNode root = null;
	    int level = 0;
	    Queue<TreeNode> preParents = new LinkedList<TreeNode>();
	    Queue<TreeNode> curParents = new LinkedList<TreeNode>();
	    TreeNode parent;
	    int len = input.length();
	    int index = 0;
	    while(index < len){
	        int count = 0;
	        if(preParents.isEmpty())
	            parent = null;
	        else
	            parent = preParents.poll();
	        for(int i = 0; i < Math.pow(2, level); i++){
	        	count++;
	            if(count > 2){
	                count = 1;
	                parent = preParents.poll();
	            }
	            char read = input.charAt(index);
	            index++;
	            if(read == '#')
	            	continue;
	            TreeNode newNode = new TreeNode(read - '0');
	            if(parent == null)
	                root = newNode;
	            else{
	                if(i % 2 == 0)
	                    parent.left = newNode;
	                else
	                    parent.right = newNode;
	            }
	            curParents.add(newNode);
	        }
	        preParents = new LinkedList<TreeNode>(curParents);
	        curParents.clear();
	        level++;
	    }
	    
	    return root;
	}
	
	public void preorderWrite(TreeNode root, StringBuilder sb){
		if(root == null)
			sb.append("#");
		else{
			sb.append(root.val);
			preorderWrite(root.left, sb);
			preorderWrite(root.right, sb);
		}
	}
	
	int idx = 0;
	public TreeNode preorderRead(TreeNode root, String str){
		if(idx == str.length())
			return root;
		char c = str.charAt(idx);
		idx++;
		if(c != '#'){
			root = new TreeNode(c - '0');
			preorderRead(root.left, str);
			preorderRead(root.right, str);
		}
		return root;
	}
	
	public static void main(String[] args) {
		SerializeDeserializeTree sdt = new SerializeDeserializeTree();
//		sdt.deserialize("12345#6");
		
		TreeNode l1 = new TreeNode(1);
		TreeNode l21 = new TreeNode(2);
		TreeNode l22 = new TreeNode(3);
		l1.left = l21; l1.right = l22;
		TreeNode l31 = new TreeNode(4);
		l21.left = l31;
		TreeNode l33 = new TreeNode(5);
		TreeNode l34 = new TreeNode(6);
		l22.left = l33;
		l22.right = l34;
		StringBuilder sb = new StringBuilder();
		sdt.preorderWrite(l1, sb);
		String s = sb.toString();
		System.out.println(s);
		
		TreeNode root = sdt.preorderRead(null, s);
		
		System.out.println(root);
	}

}
