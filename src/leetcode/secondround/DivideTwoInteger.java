package leetcode.secondround;

public class DivideTwoInteger {

	public int divideUtil(long divident, long divisor){
        if(divident < divisor)  return 0;
        
        long sum = divisor;
        int count = 1;
        while((sum << 1) < divident){
            sum <<= 1;
            count += count;
        }
        divident -= sum;
        return count + divideUtil(divident, divisor);
    }
    
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long c = (long)dividend;
        long d = (long)divisor;
        long a = Math.abs(c);
        long b = Math.abs(d);
        
        return neg ? (0 - divideUtil(a, b)) : divideUtil(a, b);
    }
	public static void main(String[] args) {
		DivideTwoInteger dti = new DivideTwoInteger();
		System.out.println(dti.divide(1000, 1));
	}

}
