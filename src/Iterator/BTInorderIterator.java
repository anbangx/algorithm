package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import leetcode.data.TreeNode;

public class BTInorderIterator implements Iterator<TreeNode>{
    
    Stack<TreeNode> stack;
    TreeNode cur;
    
    public BTInorderIterator(TreeNode root){
        stack = new Stack<TreeNode>();
        cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }
    
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        if(!hasNext())
            throw new NoSuchElementException();
        cur = stack.pop();
        TreeNode ans = cur;
        if(cur.right != null){
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return ans;
    }

    @Override
    public void remove() {
    }
    
    public static void main(String[] args) {
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
        
        BTInorderIterator it = new BTInorderIterator(root);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
