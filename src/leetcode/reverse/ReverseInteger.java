package leetcode.reverse;

public class ReverseInteger {
    
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0) return x;
        boolean neg = x < 0;
        
        if(neg) x = -x;
            
        int y=0;
        while( x > 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return neg ? -y : y;        
    }
}
