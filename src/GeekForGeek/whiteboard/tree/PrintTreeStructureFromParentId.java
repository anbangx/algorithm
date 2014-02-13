package GeekForGeek.whiteboard.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import leetcode.data.Node;

public class PrintTreeStructureFromParentId {
	
	public void printTreeStructure(ArrayList<Node> nodes){
		HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<Integer, ArrayList<Integer>>();
		HashSet<Integer> nonRoot = new HashSet<Integer>();
		for(Node node : nodes){
			ArrayList<Integer> children = null;
			if(hMap.containsKey(node.id))
				children = hMap.get(node.id);
			else{
				children = new ArrayList<Integer>();
				hMap.put(node.id, children);
			}
			children.add(node.parentId);
			nonRoot.add(node.id);
		}
		
		// find roots
		Set<Integer> roots = hMap.keySet();
		roots.removeAll(nonRoot);

	}
	
	public void bfsPrint(Set<Integer> roots, HashMap<Integer, ArrayList<Integer>> hMap){
		for(Integer root: roots){
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(root);
			while(!q.isEmpty()){
				ArrayList<Integer> levels = new ArrayList<Integer>();
				while(!q.isEmpty()){
					levels.add(q.poll());
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
