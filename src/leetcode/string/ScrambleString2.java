package leetcode.string;
import java.util.Arrays;


public class ScrambleString2 {
    
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        
        if(s1.length() != s2.length())
            return false;
        
        int len = s1.length();
        if(len == 1){
            return s1.equals(s2);
        }
        
        if(!sortString(s1).equals(sortString(s2)))
            return false;

        // int[] A = new int[26];
        // int base = Character.getNumericValue('a');
        // for(int i = 0; i < len; i++){
        //     A[Character.getNumericValue(s1.charAt(i)) - base]++;
        //     A[Character.getNumericValue(s2.charAt(i)) - base]--;
        // }
        // for(int i = 0; i < 26; i++){
        //     if(A[i] != 0)
        //         return false;
        // }
        
        for(int i = 1; i < len; i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        
        return false;
    }
    
    public String sortString(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
    
    public static void main(String[] args) {
        ScrambleString2 ss = new ScrambleString2();
        System.out.println(ss.isScramble("abc", "bca"));
    }

}
