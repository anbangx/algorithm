package leetcode;

public class UniquePath {
    
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] grid = new int[m][n];
        int i;
        for(i = 0; i < m; i++)
            grid[i][0] = 1;
        for(i = 0; i < n; i++)
            grid[0][i] = 1;
        for(i = 1; i < m; i++){
            for(int j = 1; j < n; j++)
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
        }
        
        return grid[m-1][n-1];
    }
    
    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath(); 
        // testcase 1
        System.out.println(uniquePath.uniquePaths(3, 7));
    }

}
