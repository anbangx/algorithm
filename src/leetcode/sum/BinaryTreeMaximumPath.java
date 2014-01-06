package leetcode.sum;

import java.util.ArrayList;
import java.util.Stack;

import leetcode.data.TreeNode;

public class BinaryTreeMaximumPath {

    public int maxPathSum(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null)
            return Integer.MIN_VALUE;
        ArrayList<Integer> maxAcrossRoot = new ArrayList<Integer>(1);
        maxAcrossRoot.add(Integer.MIN_VALUE);
        int maxEndByRoot = getMax(root, maxAcrossRoot);
        return maxAcrossRoot.get(0) > maxEndByRoot ? maxAcrossRoot.get(0) : maxEndByRoot;
    }

    public int getMax(TreeNode root, ArrayList<Integer> maxAcrossRoot) {
        if (root == null)
            return 0;
        int left = getMax(root.left, maxAcrossRoot);
        int right = getMax(root.right, maxAcrossRoot);
        int cMax = root.val;
        if (left > 0)
            cMax += left;
        if (right > 0)
            cMax += right;
        maxAcrossRoot.set(0, Math.max(cMax, maxAcrossRoot.get(0)));

        int partialMax = Math.max(left + root.val, right + root.val);
        int maxEndByRoot = Math.max(partialMax, root.val);
        return maxEndByRoot;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPath btmp = new BinaryTreeMaximumPath();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(0);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        //        c.left = f;
        //        d.left = g;
        System.out.println(btmp.maxPathSum(a));
        Stack<String> stack = new Stack<String>();
        stack.clear();

    }
}
