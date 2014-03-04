package leetcode.secondround;

public class PalindromePartition {

	public int minCut(String s) {
        int len = s.length();
        boolean[][] P = new boolean[len][len];
        int[] D = new int[len + 1];
        for(int i = 0; i < len + 1; i++)
            D[i] = len - i;
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || P[i + 1][j - 1])){
                    P[i][j] = true;
                    D[i] = Math.min(D[i], D[j + 1] + 1);
                }
            }
        }
        return D[0] - 1;
    }
	
	public static void main(String[] args) {
		PalindromePartition pp = new PalindromePartition();
		System.out.println(pp.minCut("a"));
	}

}
