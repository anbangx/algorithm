package leetcode.sum;
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] minPathSumGrid = new int[grid.length][grid[0].length];
        // step1: initiate the first column
        for (int i = 0; i < grid.length; i++){
            if(i == 0)
                minPathSumGrid[i][0] = grid[i][0];
            else
                minPathSumGrid[i][0] = minPathSumGrid[i-1][0] + grid[i][0];
        }
        // step2: initiate the first row
        for (int j = 1; j < grid[0].length; j++){
            if(j == 0)
                minPathSumGrid[0][j] = grid[0][j];
            else
                minPathSumGrid[0][j] = minPathSumGrid[0][j-1] + grid[0][j];
        }
        // step3: iterate over all the grids
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                minPathSumGrid[i][j] = (minPathSumGrid[i - 1][j] < minPathSumGrid[i][j - 1] ? minPathSumGrid[i - 1][j]
                        : minPathSumGrid[i][j - 1]) + grid[i][j];
            }
        }
        return minPathSumGrid[grid.length - 1][grid[0].length - 1];
    }

    public int[][] removeRow(int[][] grid, int rowNum) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        if (rowNum > totalRows - 1)
            throw new IllegalArgumentException("The input row num is bigger than totalRows");
        int[][] result = new int[totalRows - 1][totalColumns];
        int result_i = 0;
        int result_j = 0;
        for (int i = 0; i < totalRows; i++) {
            if (i == rowNum)
                continue;
            result_j = 0;
            for (int j = 0; j < totalColumns; j++) {
                result[result_i][result_j] = grid[i][j];
                result_j++;
            }
            result_i++;
        }
        return result;
    }

    public int[][] removeColumn(int[][] grid, int columnNum) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        if (columnNum > totalColumns - 1)
            throw new IllegalArgumentException("The input column num is bigger than totalColumns");
        int[][] result = new int[totalRows][totalColumns - 1];
        int result_i = 0;
        int result_j = 0;
        for (int i = 0; i < totalRows; i++) {
            result_j = 0;
            for (int j = 0; j < totalColumns; j++) {
                if (j == columnNum)
                    continue;
                result[result_i][result_j] = grid[i][j];
                result_j++;
            }
            result_i++;
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
        System.out.println(mps.minPathSum(grid));
    }

    public static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("[");
            for (int j = 0; j < grid[0].length; j++) {
                if (j != grid[0].length - 1)
                    System.out.print(grid[i][j] + ",");
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println("]");
        }

    }
}
