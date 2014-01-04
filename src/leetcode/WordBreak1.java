package leetcode;
import java.util.HashSet;
import java.util.Set;


public class WordBreak1 {
    
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || s.length() == 0)
            return false;
        int length = s.length();
        if(length == 1)
            return dict.contains(s);
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
        return seg[0][length];
    }
    
    public static void main(String[] args) {
        WordBreak1 wb = new WordBreak1();
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aa");
        System.out.println(wb.wordBreak("aaaaaaa", dict));
        }

}
