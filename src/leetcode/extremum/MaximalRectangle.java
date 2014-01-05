package leetcode.extremum;

public class MaximalRectangle {
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        // generate transform
        int[][] t = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            char prev = matrix[i][0];
            t[i][0] = prev == '1' ? 1 : 0;
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == '0')
                    t[i][j] = 0;
                else
                    t[i][j] = t[i][j - 1] + 1;
            }
        }
        
        // calculate area
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (t[i][j]!=0){
                    int h = i-1;
                    int max = t[i][j];
                    int areamax = t[i][j];
                    while(h >= 0){
                        if(t[h][j] == 0)  break;
                        max = max < t[h][j] ? max : t[h][j];
                        areamax = areamax < max * (i-h+1) ? max * (i-h+1): areamax;
                        h--;
                    }
                    if(res < areamax)
                        res = areamax;
                }
            }
        }
        return res;
    }
}
