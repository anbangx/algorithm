package leetcode.word;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreak2 {
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> results = new ArrayList<String>();
        if(s == null || s.length() == 0)
            return results;
        int length = s.length();
        if(length == 1){
            if(dict.contains(s)){
                results.add(s);
            }
            return results;
        }
        boolean[][] seg = new boolean[length][length+1];
        for(int len = 1; len < length + 1; len++){
            for(int i = 0; i <= length - len; i++){
                String str = s.substring(i, i + len);
                if(dict.contains(str)){
                    seg[i][len] = true;
                    continue;
                }
                for(int k = 1; k < len; k++){
                    if(seg[i][k] && seg[i+k][len-k]){
                        seg[i][len] = true;
                        break;
                    }
                }
            }
        }   
        
        if(seg[0][length] == false)
            return results;
        
        dfs(s, 0, dict, seg, new StringBuffer(), results);
        return results;
    }
    
    public void dfs(String s, int start, Set<String> dict, boolean[][] seg, StringBuffer sb, ArrayList<String> results){
        if(start == s.length()){
            sb.deleteCharAt(sb.length() - 1);
            results.add(sb.toString());
            return;
        }
        for(int len = 1; len < s.length() - start + 1; len++){
            if(seg[start][len]){
                if(dict.contains(s.substring(start, start + len))){
                    int lenBeforeAppend = sb.length();
                    sb.append(s.substring(start, start + len)).append(" ");
                    dfs(s, start + len, dict, seg, sb, results);
                    sb.delete(lenBeforeAppend, sb.length());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        WordBreak2 wb = new WordBreak2();
        String s = "catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wb.wordBreak(s, dict));
    }

}
