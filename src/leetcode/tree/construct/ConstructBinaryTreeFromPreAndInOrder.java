package leetcode.tree.construct;

import leetcode.TreeNode;

public class ConstructBinaryTreeFromPreAndInOrder {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int splitIndex = 0;
        for(; splitIndex < inorder.length; splitIndex++){
            if(inorder[splitIndex] == preorder[0])
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
        
        int[] leftPreorder = new int[splitIndex];
        int[] rightPreorder = new int[inorder.length - splitIndex - 1];
        for(int i = 1; i < preorder.length; i++){
            if(i <= splitIndex)
                leftPreorder[i - 1] = preorder[i];
            else
                rightPreorder[i - 1 - splitIndex] = preorder[i];
        }
        
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        
        return root;
    }
    
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreAndInOrder ct = new ConstructBinaryTreeFromPreAndInOrder();
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        ct.buildTree(preorder, inorder);
    }

}
