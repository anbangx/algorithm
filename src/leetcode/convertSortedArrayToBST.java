package leetcode;

public class convertSortedArrayToBST {
    
    public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num == null || num.length == 0)
            return null;
        int length = num.length;
        int rootIndex = length/2;
        TreeNode root = new TreeNode(num[rootIndex]);
        
        int[] left = new int[rootIndex];
        System.arraycopy(num, 0, left, 0, rootIndex);
        root.left = sortedArrayToBST(left);
        int[] right = new int[length-1-rootIndex];
        System.arraycopy(num, rootIndex+1 , right, 0, length-1-rootIndex);
        root.right = sortedArrayToBST(right);
        
        return root;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
