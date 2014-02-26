package leetcode.secondround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        
        int rowSize = triangle.size();
        int columnSize = triangle.get(rowSize - 1).size();
        int[][] dp = new int[rowSize][columnSize];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < rowSize; i++){
            ArrayList<Integer> row = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + row.get(0);
            for(int j = 1; j < row.size(); j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j] + row.get(j));
            }
        }
        return dp[rowSize - 1][columnSize - 1];
    }
	
	public static void main(String[] args) {
		Triangle t = new Triangle();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(-10);
		triangle.add(firstRow);
		System.out.println(t.minimumTotal(triangle));
	}

}
