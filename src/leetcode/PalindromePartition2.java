package leetcode;

public class PalindromePartition2 {

    public int minCut(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return 0;
        int length = s.length();
        int[][] cuts = new int[length][length + 1];
        for (int i = 0; i < length; i++)
            for(int len = 1; i + len < length + 1; len++)
                cuts[i][len] = len - 1;

        for (int len = 2; len < length + 1; len++) {
            for (int i = 0; i + len < length + 1; i++) {
                if(isPalindrome(s, i, i + len - 1)){
                    cuts[i][len] = 0;
                    continue;
                }
                for (int k = 1; k + i < len + 1; k++) {
                    if (isPalindrome(s, i, k - 1) && isPalindrome(s, i + k, i + len - 1)) {
                        if (cuts[i][len] > cuts[i][k] + cuts[i + k][len - k] + 1)
                            cuts[i][len] = 1 + cuts[i][k] + cuts[i + k][len - k];
                    }
                }
            }
        }
        return cuts[0][length];
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (s == null || s.length() == 0)
            return false;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition2 pp = new PalindromePartition2();
        System.out.println(pp.minCut("aabb"));
    }

}
