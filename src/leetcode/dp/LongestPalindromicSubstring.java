package leetcode.dp;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        int maxL = 0;
        int start = 0;
        int end = 0;
        for(int j = 1; j < len; j++){
            for(int i = 0; i <= j; i++){
                if(i == j){
                    dp[i][j] = true;
                    break;
                }
                if(i == j - 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if(dp[i][j] && maxL < (j - i + 1)){
                    maxL = j - i + 1;
                    start = i;  
                    end = j;
                }  
            }
        }
        return s.substring(start, end + 1);
    }
    
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")); 
    }   

}
