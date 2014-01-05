package leetcode.kmp;

public class StrStr {
    
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle ==null || (haystack.length() == 0 && needle.length() != 0)){
            return null;
        }
        if(haystack.length() == 0 && needle.length() == 0)
            return "";
        if(needle.length() == 0)
            return haystack;
        
        int lenHaystack = haystack.length();
        int lenNeedle = needle.length();
        int[] next = computeNextfunction(needle);
        int i = 0;
        int j = 0;
        while(i < lenHaystack){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(j == lenNeedle - 1)
                    return haystack.substring(i-j);
                i++;
                j++;
            } else if(j > 0){
                j = next[j-1];
            } else
                i++;
        }
        return null;
    }
    
    public int[] computeNextfunction(String p){
        int len = p.length();
        int[] next = new int[len];
        next[0] = 0;
        
        int i = 1;
        int j = 0;
        while(i < len){
            if(p.charAt(i) == p.charAt(j)){
                next[i] = j + 1;
                i++;
                j++;
            } else{
                if(j > 0){
                    j = next[j - 1];
                } else{
                    next[i] = 0;
                    i++;
                }
            }
        }
        return next;
    }
    
    public static void main(String[] args) {
        StrStr ss = new StrStr();
        System.out.println(ss.strStr("mississippi", "issip"));
    }

}
