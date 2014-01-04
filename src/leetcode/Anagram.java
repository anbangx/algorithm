package leetcode;
import java.util.ArrayList;


public class Anagram {
    
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> results = new ArrayList<String>();
        if(strs == null || strs.length == 0){
            results.add("");
            return results;
        }
        
        for(String str : strs){
            if(isAnagram(str))
                results.add(str);
        }
        return results;
    }
    
    public boolean isAnagram(String str){
        if(str == null || str.length() == 0)
            return true;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Anagram a = new Anagram();
        String[] strs = {""};
        System.out.println(a.anagrams(strs));
    }

}
