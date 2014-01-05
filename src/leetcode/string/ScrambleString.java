package leetcode.string;
import java.util.Arrays;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length = s1.length();
        if (length <= 2)
            return sortString(s1).equals(sortString(s2));
        if (length % 2 == 0) {
            String s1_firstHalf = sortString(s1.substring(0, length / 2));
            String s1_secondHalf = sortString(s1.substring(length / 2, length));
            String s2_firstHalf = sortString(s2.substring(0, length / 2));
            String s2_secondHalf = sortString(s2.substring(length / 2, length));
            if (s1_firstHalf.equals(s2_firstHalf) && s1_secondHalf.equals(s2_secondHalf))
                return isScramble(s1.substring(0, length / 2), s2.substring(0, length / 2))
                        && isScramble(s1.substring(length / 2, length), s2.substring(length / 2, length));
        } else {
            String s1_firstHalf1 = sortString(s1.substring(0, length / 2));
            String s1_secondHalf1 = sortString(s1.substring(length / 2, length));
            String s2_firstHalf1 = sortString(s2.substring(0, length / 2));
            String s2_secondHalf1 = sortString(s2.substring(length / 2, length));

            String s1_firstHalf2 = sortString(s1.substring(0, length / 2 + 1));
            String s1_secondHalf2 = sortString(s1.substring(length / 2 + 1, length));
            String s2_firstHalf2 = sortString(s2.substring(0, length / 2 + 1));
            String s2_secondHalf2 = sortString(s2.substring(length / 2 + 1, length));

            if (s1_firstHalf1.equals(s2_firstHalf1) && s1_secondHalf1.equals(s2_secondHalf1)) {
                if (isScramble(s1.substring(0, length / 2), s2.substring(0, length / 2))
                        && isScramble(s1.substring(length / 2, length), s2.substring(length / 2, length)))
                    return true;
            }
            if (s1_firstHalf1.equals(s2_secondHalf2) && s1_secondHalf1.equals(s2_firstHalf2)) {
                if (isScramble(s1.substring(0, length / 2), s2.substring(length / 2 + 1, length))
                        && isScramble(s1.substring(length / 2, length), s2.substring(0, length / 2 + 1)))
                    return true;
            }
            if (s1_firstHalf2.equals(s2_firstHalf2) && s1_secondHalf2.equals(s2_secondHalf2)) {
                if (isScramble(s1.substring(0, length / 2 + 1), s2.substring(0, length / 2 + 1))
                        && isScramble(s1.substring(length / 2 + 1, length), s2.substring(length / 2 + 1, length)))
                    return true;
            }
            if (s1_firstHalf2.equals(s2_secondHalf1) && s1_secondHalf2.equals(s2_firstHalf1)) {
                if (isScramble(s1.substring(0, length / 2 + 1), s2.substring(length / 2, length))
                        && isScramble(s1.substring(length / 2 + 1, length), s2.substring(0, length/2)))
                    return true;
            }
            return false;
        }
        return false;
    }

    public String sortString(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        String s1 = "great";
        String s2 = "rgtae";
        System.out.println(ss.isScramble(s1, s2));
    }

}
