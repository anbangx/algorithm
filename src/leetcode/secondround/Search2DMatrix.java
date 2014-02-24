package leetcode.secondround;

public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)    return false;
        
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int i = 0;
        for(; i < rowSize; i++){
            if(matrix[i][0] == target)
                return true;
            if(matrix[i][0] > target){
                i--;
                break;
            }
        }
        if(i < 0) return false;
        if(i == rowSize)	i--;
        int left = 0; int right = columnSize - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[i][mid] == target)
                return true;
            else if(matrix[i][mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] x = {1, 3};
		int[][] matrix = new int[1][2];
		matrix[0] = x;
		test(matrix, 3);
	}
	
	public static void test(int[][] matrix, int target){
		Search2DMatrix sm = new Search2DMatrix();
		System.out.println(sm.searchMatrix(matrix, target));
	}
}
