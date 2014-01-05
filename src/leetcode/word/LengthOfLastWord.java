package leetcode.word;

public class LengthOfLastWord {
    
    public int lengthOfLastWord(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null || s.length() == 0)
            return 0;
        
        int len = s.length();
        int i = len - 1;
        while(i >= 0 && s.charAt(i) == ' ')
            i--;
        if(i == -1)
            return 0;
        
        int end = i;
        for(; i >= 0; i--){
            if(s.charAt(i) == ' ')
                break;
        }
        return end - i;
    }
}
