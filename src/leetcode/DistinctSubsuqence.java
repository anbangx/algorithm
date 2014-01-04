package leetcode;

public class DistinctSubsuqence {
    
    public int numDistinct(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int t = T.length();
        int s = S.length();
        if(s < t)
            return 0;
        if(s == t){
            if(S.equals(T))
                return 1;
            else
                return 0;
        }
        int[][] dp = new int[t + 1][s + 1];
        // initiate
        for(int i = 0; i < t + 1; i++)
            dp[i][0] = 0;
        for(int j = 0; j < s + 1; j++)
            dp[0][j] = 1;
        for(int i = 1; i < t + 1; i++){
            for(int j = 1; j < s + 1; j++){
                dp[i][j] = dp[i][j-1];
                if(S.charAt(j-1) == T.charAt(i-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[t][s];
    }
    
    public static void main(String[] args) {
        DistinctSubsuqence ds = new DistinctSubsuqence();
        System.out.println(ds.numDistinct("ccc", "c"));
    }

}
