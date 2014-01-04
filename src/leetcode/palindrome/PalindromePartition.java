package leetcode.palindrome;
import java.util.ArrayList;


public class PalindromePartition {
    
    public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0)
            return results;
        dfs(s, 0, new ArrayList<String>(), results);
        return results;
    }
    
    public void dfs(String s, int start, ArrayList<String> candidate, ArrayList<ArrayList<String>> results){
        if(start == s.length()){
            results.add(new ArrayList<String>(candidate));
            return;
        }
        for(int len = 1; len < s.length() - start + 1; len++){
            if(isPalindrome(s, start, start + len - 1)){
                String str = s.substring(start, start + len);
                candidate.add(str);
                dfs(s, start + len, candidate, results);
                candidate.remove(candidate.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        if(s == null || s.length() == 0)
            return false;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++; end--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        PalindromePartition pp = new PalindromePartition();
        System.out.println(pp.partition("aab"));

    }

}
