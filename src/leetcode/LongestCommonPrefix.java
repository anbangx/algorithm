package leetcode;

public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(strs.length == 0 || strs[0].length() == 0 || strs == null)
            return "";
        char commonChar = strs[0].charAt(0);
        strs[0] = strs[0].substring(1);
        int i;
        for(i = 1; i < strs.length; i++){
            if(strs[i].length() == 0 ||commonChar != strs[i].charAt(0))
                return "";
            strs[i] = strs[i].substring(1);
        }
        return commonChar + longestCommonPrefix(strs);
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"accvab", "accves", "accvo"};
        System.out.println(lcp.longestCommonPrefix(strs));
        // testcase2 
        String[] strs2 = {"",""};
        System.out.println(lcp.longestCommonPrefix(strs2));
    }

}
