package leetcode.dp;

public class UniquePath2 {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        int i;
        // for(i = 0; i < m; i++){
        //     if(obstacleGrid[i][0] == 1)
        //         grid[i][0] = 0;
        //     else
        //         grid[i][0] = 1;
        // }
        // for(i = 0; i < n; i++){
        //     if(obstacleGrid[0][i] == 1)
        //         grid[0][i] = 0;
        //     else
        //         grid[0][i] = 1;
        // }
        if(obstacleGrid[0][0] == 1)
            grid[0][0] = 0;
        for(i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    continue;
                if(obstacleGrid[i][j] == 1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        
        return grid[m-1][n-1];
    }
    
    public static void main(String[] args) {
        UniquePath2 up = new UniquePath2();
        int[][] obstacleGrid = new int[1][2];
        obstacleGrid[0][0] = 0;
        obstacleGrid[0][1] = 0;
        System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
    }

}
