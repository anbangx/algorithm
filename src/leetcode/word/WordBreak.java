package leetcode.word;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || s.equals(""))
            return true;
        boolean match = false;
        for(String word : dict){
            int l = word.length();
            if(s.length() >= l && s.substring(0,l).equals(word)){
                match = wordBreak(s.substring(l), dict);
                if(match)
                    break;
            } 
        }
        return match;
    }
    
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "";
        Set<String> dict = new HashSet<String>();
        // testcase 1
        s = "leetcode";
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak.wordBreak(s, dict));
        // testcase 2
        dict.clear();
        dict.add("lee");
        dict.add("t");
        dict.add("code");
        System.out.println(wordBreak.wordBreak(s, dict));
        // testcase 3
        dict.clear();
        dict.add("lee");
        dict.add("t");
        dict.add("co");
        dict.add("de");
        System.out.println(wordBreak.wordBreak(s, dict));
        // testcase 4
        s = "bb";
        dict.clear();
        dict.add("a");
        dict.add("b");
        dict.add("bb");
        dict.add("bbbb");
        System.out.println(wordBreak.wordBreak(s, dict));
        
        // testcase 5
        s = "aaaaaaa";
        dict.clear();
        dict.add("aaaa");
        dict.add("aaa");
        System.out.println(wordBreak.wordBreak(s, dict));
    }

}
