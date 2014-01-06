package leetcode.recursive;

public class SpiralMatrix2 {
    
    public int[][] generateMatrix(int n) {
        return genMatrix(n, 1);
    }
    
    public int[][] genMatrix(int n, int startNum){
        int[][] results = new int[n][n];
        if(n == 1){
            results[0][0] = startNum;
            return results;
        }
        
        // up
        for(int j = 0; j < n; j++){
            results[0][j] = startNum++;
        }
        // right
        for(int i = 1; i < n; i++){
            results[i][n - 1] = startNum++;
        }
        // down
        for(int j = n - 2; j >= 0; j--){
            results[n - 1][j] = startNum++;
        }
        // left
        for(int i = n - 2; i > 0; i--){
            results[i][0] = startNum++;
        }
        
        if(n >= 3){
            int[][] subMatrix = genMatrix(n - 2, startNum);
            for(int i = 0; i < subMatrix[0].length; i++){
                for(int j = 0; j < subMatrix.length; j++){
                    results[i + 1][j + 1] = subMatrix[i][j];
                }
            }
        }
        return results;    
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
