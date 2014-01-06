package leetcode.sum;

import leetcode.data.TreeNode;

public class SumRootToLeafNum {
    
    public int sumNumbers(TreeNode root) {
        return generateSum(root, 0);
    }
    
    public int generateSum(TreeNode root, int prePathSum){
        // best case
        if(root == null)
            return 10 * prePathSum;
        if(root.left == null && root.right == null)
            return 10 * prePathSum + root.val;
        
        int curSum = 10 * prePathSum + root.val;
        int leftSum = 0;
        int rightSum = 0;
        if(root.left != null)
            leftSum = generateSum(root.left, curSum);
        if(root.right != null)
            rightSum = generateSum(root.right, curSum);
        return leftSum + rightSum;
    }
    
    public static void main(String[] args) {
        SumRootToLeafNum srtl = new SumRootToLeafNum();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(srtl.sumNumbers(root));
    }

}
