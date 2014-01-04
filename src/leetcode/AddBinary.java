package leetcode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class AddBinary {
    
    public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int aLen = a.length();
        int bLen = b.length();
        int maxL = aLen > bLen ? aLen : bLen;
        int carry = 0;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuffer output = new StringBuffer();
        for(int i = 0; i < maxL; i++){
            int ai = i < aLen ? a.charAt(i) - '0' : 0;
            int bi = i < bLen ? b.charAt(i) - '0' : 0;
            int val = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            output.insert(0, String.valueOf(val));
        }
        if(carry == 1)
            output.insert(0, '1');
        return output.toString();
    }
    
    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("1010", "1011"));
    }

}
