package leetcode;
import java.util.ArrayList;


public class UniqueBinarySearchTree2 {
    
    public ArrayList<TreeNode> generateTrees(int n) {
        return genTrees(n, 0);
    }
    
    public ArrayList<TreeNode> genTrees(int n, int startNum){
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if(n == 0){
            TreeNode root = null;
            results.add(root);
            return results;
        }
        if(n == 1){
            TreeNode root = new TreeNode(startNum + 1);
            results.add(root);
            return results;
        }
        if(n == 2){
            TreeNode root1 = new TreeNode(startNum + 1);
            TreeNode leave1 = new TreeNode(startNum + 2);
            root1.right = leave1;
            TreeNode root2 = new TreeNode(startNum + 2);
            TreeNode leave2 = new TreeNode(startNum + 1);
            root2.left = leave2;
            results.add(root1);
            results.add(root2);
            return results;
        }
        
        for(int i = 0; i < n; i++){
            ArrayList<TreeNode> lefts = genTrees(i, startNum);
            ArrayList<TreeNode> rights = genTrees(n - 1 - i, startNum + i + 1);
            for(int l = 0; l < lefts.size(); l++){
                for(int r = 0; r < rights.size(); r++){
                    TreeNode root = new TreeNode(startNum + i + 1);
                    root.left = lefts.get(l);
                    root.right = rights.get(r);
                    results.add(root);
                }
            }
        }
        
        return results;
    }
    
    public void printTree(TreeNode root){
        if(root == null)
            return;
        
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTree2 ubs = new UniqueBinarySearchTree2();
        int n = 1;
        for(TreeNode root : ubs.generateTrees(4)){
            System.out.println("Tree " + n + ":");
            ubs.printTree(root);
            n++;
        }
    }

}
