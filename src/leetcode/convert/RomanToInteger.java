package leetcode.convert;

public class RomanToInteger {

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && c2n(s.charAt(i)) > c2n(s.charAt(i - 1))) {
                result += (c2n(s.charAt(i)) - c2n(s.charAt(i - 1)));
            } else {
                result += c2n(s.charAt(i));
            }
        }
        return result;
    }

    public int c2n(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
