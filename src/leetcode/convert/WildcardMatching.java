package leetcode.convert;

public class WildcardMatching {
    
    public boolean isMatch(String s, String p) {
        if(s == null)
            return false;
        
        int len = s.length();
        int cursor_s = 0;
        int cursor_p = 0;
        int ss = -1;
        int star = -1;
        while(cursor_s < len){
//            if(cursor_p == p.length())
//                return false;
            char char_p = cursor_p == p.length() ? ' ' : p.charAt(cursor_p);
            char char_s = s.charAt(cursor_s);
            if(char_p == '?' || char_s == char_p){
                cursor_p++;
                cursor_s++;
            } else if(char_p == '*'){
                star = cursor_p++;
                ss = cursor_s;
            } else{
                if(star != -1){
                    cursor_p = star + 1;
                    cursor_s = ++ss;
                } else
                    return false;
            }
        }
        while(cursor_p < p.length() && p.charAt(cursor_p) == '*')
            cursor_p++;
        return cursor_p == p.length();
    }
    
    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("aa", "aa"));
    }

}
