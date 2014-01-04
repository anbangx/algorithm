package leetcode;
import java.util.ArrayList;


public class SpiralMatrix {
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        if(matrix.length == 1 && matrix[0].length == 1){
            result.add(matrix[0][0]);
            return result;
        }
        if(matrix[0].length == 1){
            for(int i = 0; i < matrix.length; i++)
                result.add(matrix[i][0]);
            return result;
        }
        // up
        for(int j = 0; j < matrix[0].length; j++)
            result.add(matrix[0][j]);
        // right
        for(int i = 1; i <= matrix.length - 1; i++)
            result.add(matrix[i][matrix[0].length - 1]);
        if(matrix.length - 1 > 0){
            // down
            for(int j = matrix[0].length - 2; j >= 0; j--)
                result.add(matrix[matrix.length - 1][j]);
            // left
            for(int i = matrix.length - 2; i > 0; i--)
                result.add(matrix[i][0]);
        }
        
        if(matrix.length - 2 <= 0 || matrix[0].length - 2 <= 0)
            return result;
    
        int[][] newMatrix = new int[matrix.length - 2][matrix[0].length - 2];
        for(int i = 1; i < matrix.length - 1; i++){
            for(int j = 1; j < matrix[0].length - 1; j++)
                newMatrix[i-1][j-1] = matrix[i][j];
        }
        result.addAll(spiralOrder(newMatrix));
        
        return result;
    }
    
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {{7}, {9}, {6}};
        System.out.println(sm.spiralOrder(matrix));
    }

}
