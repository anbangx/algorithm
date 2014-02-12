package leetcode.data;

public class TreeNode2 {
    public int val;
    public TreeNode2 left;
    public TreeNode2 right;
    public TreeNode2(int x) { val = x; }
    
    public TreeNode2 parent;
    
    public String toString(){
        return Integer.toString(val);
    }
    
//    public static TreeNode2 constructTree(String str){
//    	SerializeDeserializeTree sdt = new SerializeDeserializeTree();
//    	return sdt.preorderRead(str);
//    }
}
