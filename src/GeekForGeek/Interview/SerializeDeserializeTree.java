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

	public static void main(String[] args) {
		SerializeDeserializeTree sdt = new SerializeDeserializeTree();
		sdt.deserialize("12345#6");
	}

}
