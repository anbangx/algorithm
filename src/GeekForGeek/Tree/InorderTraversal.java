package GeekForGeek.Tree;

import java.util.Stack;

import leetcode.data.TreeNode;

public class InorderTraversal {
    
    public void inorderTraversalIteratively(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()){
            cur = stack.pop();
            System.out.println(cur.val);
            if(cur.right != null){
                cur = cur.right;
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        InorderTraversal it = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode level1_1 = new TreeNode(2);
        TreeNode level1_2 = new TreeNode(3);
        root.left = level1_1;
        root.right = level1_2;
        TreeNode level2_1 = new TreeNode(4);
        TreeNode level2_2 = new TreeNode(5);
        level1_1.left = level2_1;
        level1_1.right = level2_2;
        TreeNode level2_3 = new TreeNode(6);
        TreeNode level2_4 = new TreeNode(7);
        level1_2.left = level2_3;
        level1_2.right = level2_4;
        TreeNode level3_5 = new TreeNode(8);
        level2_3.left = level3_5;
        it.inorderTraversalIteratively(root);
    }

}
