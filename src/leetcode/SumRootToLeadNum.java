package leetcode;

public class SumRootToLeadNum {
    
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return generateSum(root, 0);
    }
    
    public int generateSum(TreeNode root, int path){
        // best case
        if(root == null)
            return 10 * path;
        if(root.left == null && root.right == null)
            return 10 * path + root.val;
        
        int curSum = 10 * path + root.val;
        int leftSum = 0;
        int rightSum = 0;
        if(root.left != null)
            leftSum = generateSum(root.left, curSum);
        if(root.right != null)
            rightSum = generateSum(root.right, curSum);
        return leftSum + rightSum;
    }
    
    public static void main(String[] args) {
        SumRootToLeadNum srtl = new SumRootToLeadNum();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(srtl.sumNumbers(root));
    }

}
