package leetcode;

public class DecodeWay {
    
    public int numDecodings(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // base case
        if(s == null || s.length() == 0){
            return 0;    
        }
        if(s.length() == 1)
            return check(s.charAt(0));
        if(s.charAt(0) == '0')
            return 0;
        
        int count1 = check(s.charAt(0));
        int count2 = check(s.charAt(0), s.charAt(1)) + (s.charAt(1) == '0' ? 0 : count1);
        if(s.length() == 2)
            return count2;
        int curcount = 0;
        for(int i = 2; i < s.length(); i++){
            if(check(s.charAt(i)) == 1)
                curcount = count2;
            else
                curcount = 0;
            if(check(s.charAt(i-1), s.charAt(i)) == 1)
                curcount += count1;
            count1 = count2;
            count2 = curcount;
            if(curcount == 0)
                return 0;
        }
        return count2;
    }
    
    public int check(char c){
        return c != '0' ? 1 : 0;
    }
    
    public int check(char c1, char c2){
        return c1 == '1' || (c1 == '2' && c2 <= '6') ? 1 : 0; 
    }
    
    public static void main(String[] args) {
        DecodeWay dw = new DecodeWay();
        System.out.println(dw.numDecodings("5243"));
    }

}
