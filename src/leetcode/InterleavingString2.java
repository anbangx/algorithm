package leetcode;

public class InterleavingString2 {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null || s3.length() == 0)
            return false;
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len3 != len1 + len2)
            return false;
        
        boolean[][] match = new boolean[len2 + 1][len1 + 1];
        match[0][0] = true;
        for(int j = 1; j <= len1; j++){
            if(s1.charAt(j - 1) == s3.charAt(j - 1))
                match[0][j] |= match[0][j - 1];
            else
                match[0][j] = false;
        }
        for(int i = 1; i <= len2; i++){
            if(s2.charAt(i - 1) == s3.charAt(i - 1))
                match[i][0] |= match[i - 1][0];
            else
                match[i][0] = false;
        }
        
        // dp
        for(int i = 1; i <= len2; i++){
            for(int j = 1; j <= len1; j++){
                match[i][j] = (s3.charAt(i + j - 1) == s1.charAt(j - 1)) && match[i][j-1]
                    ||(s3.charAt(i + j - 1) == s2.charAt(i - 1)) && match[i-1][j];
            }
        }
        
        return match[len2][len1];
    }
    
    public static void main(String[] args) {
        InterleavingString2 is = new InterleavingString2();
        System.out.println(is.isInterleave("ab", "cb", "acbb"));
    }

}
