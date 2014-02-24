package leetcode.secondround;

public class MaximalSubarray {
	public int maxSubArray(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        
        int len = A.length;
        int curMax = A[0];
        int max = A[0];
        for(int i = 1; i < len; i++){
            if(curMax + A[i] < 0){
                curMax = A[i];
            } else{
                curMax += A[i];
            } 
            max = curMax > max ? curMax : max;
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		test(A);
	}
	
	public static void test(int[] A){
		MaximalSubarray ms = new MaximalSubarray();
		System.out.println(ms.maxSubArray(A));
	}
}
