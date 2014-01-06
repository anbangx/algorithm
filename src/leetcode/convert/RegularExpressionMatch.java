package leetcode.convert;
import java.util.ArrayList;

public class RegularExpressionMatch {

    public boolean isMatch(String s, String p) {
        if (s == null)
            return false;

        // preprocess p
        StringBuilder sb = new StringBuilder("");
        ArrayList<Boolean> star = new ArrayList<Boolean>();
        for (int i = 0; i < p.length(); i++) {
            sb.append(p.charAt(i) != '*' ? p.charAt(i) : "");
            if (i == p.length() - 1) {
                if(p.charAt(i) != '*')
                    star.add(false);
                continue;
            }
            if(p.charAt(i) != '*'){
                if (p.charAt(i + 1) == '*') {
                    star.add(true);
                } else {
                    star.add(false);
                }
            }
        }
        String new_p = sb.toString();
        
        // get valid array, the last few chars are '*'
        boolean[] valid = new boolean[new_p.length()];
        int i = new_p.length() - 1;
        while (i >= 0 && star.get(i)) {
            valid[i--] = true;
        }

        return match(s, 0, new_p, 0, star, valid);
    }

    public boolean match(String s, int sm, String p, int pm, ArrayList<Boolean> star, boolean[] valid) {
        int sLen = s.length();
        int pLen = p.length();
        if (sm < sLen && pm == pLen) {
            return false;
        }
        if (sm >= sLen) {
            return pm == valid.length || valid[pm];
        }
        if (s.charAt(sm) != p.charAt(pm) && p.charAt(pm) != '.') { //if current elements not equal
            if (star.get(pm)) { //if there can be zero p[pm].
                return match(s, sm, p, pm + 1, star, valid); //search the next element
            } else {
                return false;
            }
        }
        if (s.charAt(sm) == p.charAt(pm) || p.charAt(pm) == '.') { //if current elements equal
            if (star.get(pm)) { //if there can be 0 or more p[pm]
                if (pm + 1 < pLen && p.charAt(pm) == p.charAt(pm + 1) && star.get(pm + 1)) { //if the next element is the same and also followed by *
                    return match(s, sm + 1, p, pm + 1, star, valid);
                } else {
                    ////////////////////search zero or more p[pm]///////////////////////
                    return match(s, sm, p, pm + 1, star, valid) || match(s, sm + 1, p, pm, star, valid);
                    ////////////////////////////////////////////////////////////////////
                }
            } else {
                return match(s, sm + 1, p, pm + 1, star, valid);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatch rem = new RegularExpressionMatch();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(rem.isMatch(s, p));
    }

}
