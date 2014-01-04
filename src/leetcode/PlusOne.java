package leetcode;
import java.util.ArrayList;


public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(digits == null)
            return null;
        int len = digits.length;
        int sum = 0;
        int carry = 1;
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = len - 1; i >= 0; i--){
            sum = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            output.add(sum);
        }
        if(carry == 1)
            output.add(1);
        int[] result = new int[output.size()];
        for(int i = output.size() - 1; i >= 0; i--)
            result[i] = output.get(i);
        return result;
    }
    
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {0};
        System.out.println(po.plusOne(digits));
    }

}
