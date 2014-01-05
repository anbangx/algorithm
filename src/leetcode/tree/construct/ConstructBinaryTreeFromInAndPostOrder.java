package leetcode.tree.construct;

import leetcode.TreeNode;

public class ConstructBinaryTreeFromInAndPostOrder {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0)
            return null;
        int postLen = postorder.length;
        TreeNode root = new TreeNode(postorder[postLen - 1]);
        int splitIndex = 0;
        for(; splitIndex < inorder.length; splitIndex++){
            if(inorder[splitIndex] == postorder[postLen - 1])
                break;
        }
        
        int[] leftInorder = new int[splitIndex];
        int[] rightInorder = new int[inorder.length - splitIndex - 1];
        for(int i = 0; i < inorder.length; i++){
            if(i <= splitIndex - 1)
                leftInorder[i] = inorder[i];
            else if(i > splitIndex)
                rightInorder[i - splitIndex - 1] = inorder[i];
        }
        
        int[] leftPostorder = new int[splitIndex];
        int[] rightPostorder = new int[inorder.length - splitIndex - 1];
        for(int i = 0; i < inorder.length - 1; i++){
            if(i <= splitIndex - 1)
                leftPostorder[i] = postorder[i];
            else
                rightPostorder[i - splitIndex] = postorder[i];
        }
        
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        
        return root;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
