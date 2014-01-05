package leetcode.extremum;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int longestLength = 0;
        for(int i = 0; i < s.length(); i++){
            int curLength = findLongestSubstringFromBeginning(s.substring(i));
            if(curLength > longestLength)
                longestLength = curLength;
        }
        return longestLength;
    }
    
   public int findLongestSubstringFromBeginning(String s){
        Set<Character> uniqueSubstring = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            if(uniqueSubstring.contains(s.charAt(i)))
                break;
            uniqueSubstring.add(s.charAt(i));
        }
        return uniqueSubstring.size();
   } 
   
    public Set<Character> convertToUniqueSet(String s){
        Set<Character> uniqueChars = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++)
            uniqueChars.add(s.charAt(i));
        return uniqueChars;
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lus = new LongestSubstringWithoutRepeatingCharacters();
        // abcabcbb bbbbb
        System.out.println(lus.lengthOfLongestSubstring("abcabcbb"));
    }
}
