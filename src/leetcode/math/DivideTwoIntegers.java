package leetcode.math;

public class DivideTwoIntegers {
    
    public int divide(int dividend, int divisor) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long c = (long)dividend;
        long d = (long)divisor;
        long a = Math.abs(c);
        long b = Math.abs(d);
        
        long sum = 0;
        int count = 0;
        int output = 0;
        while(a >= b){
            count = 1;
            sum = b;
            while(sum + sum < a){
                sum += sum;
                count += count;
            }
            a -= sum;
            output += count;
        }
        return neg ? 0 - output : output;
    }
}
