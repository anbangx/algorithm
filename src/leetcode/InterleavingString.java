package leetcode;

public class InterleavingString {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s3.length() != s1.length() + s2.length())
            return false;
        if(s3.length() == 0 || s3 == null)
            return true;
        if(s1.length() > 0 && s3.charAt(0) == s1.charAt(0)){
            int lcpLength = longestCommonPrefix(s1, s3);
            while(lcpLength > 0){
                if(isInterleave(s1.substring(lcpLength), s2, s3.substring(lcpLength)))
                    return true;
                lcpLength--;
            }
        }
        if(s2.length() > 0 && s3.charAt(0) == s2.charAt(0)){
            int lcpLength = longestCommonPrefix(s2, s3);
            while(lcpLength > 0){
                if(isInterleave(s1, s2.substring(lcpLength), s3.substring(lcpLength)))
                    return true;
                lcpLength--;
            }
        }
        return false;
    }
    
    public int longestCommonPrefix(String s1, String s2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int index = 0;
        int size = s1.length() < s2.length() ? s1.length() : s2.length();
        while(index < size){
            if(s1.charAt(index) != s2.charAt(index))
                break;
            index++;
        }
        return index;
    }
    
    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        // testcase1 aadbbcbcac
        System.out.println(interleavingString.isInterleave(s1, s2, "aadbbcbcac"));
        // testcase2 aadbbbaccc
        System.out.println(interleavingString.isInterleave(s1, s2, "aadbbbaccc"));
        // testcase3 
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbcbbcac"));
    }
}
