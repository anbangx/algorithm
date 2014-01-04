package leetcode;

public class SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(matrix == null)
            return;
        boolean rowZero = false;
        boolean colZero = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                colZero = true;                
                break;
            }
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                rowZero = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;
            }
        }
        if(rowZero){
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if(colZero){
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
    
    public static void main(String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrix = new int[1][2];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        smz.setZeroes(matrix);
    }

}
