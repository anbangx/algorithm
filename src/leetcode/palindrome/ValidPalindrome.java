package leetcode.palindrome;
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s == null || s.length() == 0)
            return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                sb.append("#").append(s.charAt(i));
            }
        }
        String read = sb.append("#").toString().toLowerCase();
        int mid = read.length() / 2;
        for (int i = 1; i <= mid; i++) {
            if (read.charAt(mid - i) != read.charAt(mid + i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("1a2"));
    }

}
