package leetcode;


public class Sqrt {

    public int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        long start = 0;
        long end = ((long) x + 1) / 2;
        long temp = 0;
        while (start < end) {
            long mid = (start + end) / 2;
            temp = mid * mid;
            if (temp == (long) x)
                return (int) mid;
            else if (temp > (long) x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        temp = end * end;
        if (temp > x)
            return (int) (end - 1);
        else
            return (int) end;
    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.sqrt(2147483647));
    }

}
