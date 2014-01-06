package leetcode.dfs;

import java.util.ArrayList;

public class N_Queens {
    
    public ArrayList<String[]> solveNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String[]> results = new ArrayList<String[]>();
        if(n == 0)
            return results;
        int[] A = new int[n];
        dfs(A, 0, n, results);
        return results;
    }
    
    public void dfs(int[] A, int cur, int n, ArrayList<String[]> results){
        if(cur == n){
            String[] output = new String[n];
            for(int i = 0; i < n; i++){
                StringBuffer sb = new StringBuffer(n);
                for(int j = 0; j < n; j++)
                    sb.append(".");
                sb.setCharAt(A[i], 'Q');
                output[i] = sb.toString();
            }
            results.add(output);
            return;
        }
        for(int i = 0; i < n; i++){
            A[cur] = i; 
            if(isValid(A, cur)){
                dfs(A, cur + 1, n, results);
            }
        }
    }
    
    public boolean isValid(int[] A, int cur){
        for(int i = 0; i < cur; i++){
            if(A[i] == A[cur] || Math.abs(A[i] - A[cur]) == cur - i)
                return false;
        }
        return true;
    }
}
