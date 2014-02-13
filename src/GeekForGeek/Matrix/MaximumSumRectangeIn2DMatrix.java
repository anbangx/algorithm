package GeekForGeek.Matrix;

public class MaximumSumRectangeIn2DMatrix {
	
	public int findMaximumSumSubRectange(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		
		// build areaSum matrix
		int[][] areaSum = new int[m][n];
		areaSum[0][0] = matrix[0][0];
		for(int i = 1; i < m; i++)
			areaSum[i][0] = areaSum[i-1][0] + matrix[i][0];
		for(int j = 1; j < n; j++)
			areaSum[0][j] = areaSum[0][j-1] + matrix[0][j];
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				areaSum[i][j] = areaSum[i-1][j] + areaSum[i][j-1] - areaSum[i-1][j-1] + matrix[i][j];  
			}
		}
		
		// find max
		return 0;
	}
	
	public static void main(String[] args) {
		
	}

}
