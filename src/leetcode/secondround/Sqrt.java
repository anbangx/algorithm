package leetcode.secondround;

public class Sqrt {

	public int sqrt(int x) {
        if(x == 0)  return 0;
        if(x <= 3)  return 1;
        
        int left = 1; int right = x / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid * mid == x){
                return mid;
            } else if(mid * mid < x){
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return right;
    }
	
	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(2147395599));
	}

}
