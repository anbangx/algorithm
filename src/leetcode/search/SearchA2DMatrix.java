package leetcode.search;

public class SearchA2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        if(target < matrix[0][0])
            return false;
        int i;
        for(i = 1; i < matrix.length; i++){
            if(target < matrix[i][0])
                break;
        }
        int row = i - 1;
        for(i = 0; i < matrix[0].length; i++){
            if(matrix[row][i] == target)
                return true;
        }
        return false;
    }
}
