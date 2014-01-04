package leetcode.palindrome;

public class PalindromePartition3 {
    
    public int minCut(String s) {
        int len = s.length();
        if(len == 1)
            return 0;
        int[] D = new int[len + 1];
        boolean[][] P = new boolean[len][len];
        for(int i = 0; i < len; i++)
            D[i] = len - i - 1;
            
        // dp
        for(int i = len - 1; i >= 0; i--){
            P[i][i] = true;
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i > 2 || P[i + 1][j - 1])){
                    P[i][j] = true;
                    D[i] = Math.min(D[i], D[j + 1] + 1);
                }
            }
        }
        
        return D[0];
    }
    
    public static void main(String[] args) {
        PalindromePartition3 pp = new PalindromePartition3();
        System.out.println(pp.minCut("aa"));
    }

}
