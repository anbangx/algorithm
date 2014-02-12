package leetcode.data;

import GeekForGeek.Interview.SerializeDeserializeTree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    
    public String toString(){
        return Integer.toString(val);
    }
    
    public static TreeNode constructTree(String str){
    	SerializeDeserializeTree sdt = new SerializeDeserializeTree();
    	return sdt.preorderRead(str);
    }
}
