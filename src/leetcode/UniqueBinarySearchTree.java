package leetcode;

public class UniqueBinarySearchTree {
    
    public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n == 0 || n == 1 || n == 2)
            return n;
        int[] c = new int[n + 1];
        c[2] = 2;
        c[3] = 5;
        for(int i = 4; i < n + 1; i++){
            for(int j = 2; j < i; j++)
                c[i] += 2 * (c[j]);
        }
        return c[n];
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
        System.out.println(ubst.numTrees(4));
    }

}
