package leetcode;
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();
        
    }

}
