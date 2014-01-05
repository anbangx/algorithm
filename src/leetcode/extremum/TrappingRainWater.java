package leetcode.extremum;

public class TrappingRainWater {
    
    public int trap(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        
        int[] leftMax = new int[A.length];
        int preLeftMax = -1;
        int[] rightMax = new int[A.length];
        int preRightMax = -1;
        for(int i = 0; i < A.length; i++){
            if(preLeftMax < A[i])
                preLeftMax = A[i];
            leftMax[i] = preLeftMax;
            
            if(preRightMax < A[A.length - i - 1])
                preRightMax = A[A.length - i - 1];
            rightMax[A.length - i - 1] = preRightMax;
        }
        
        int sum = 0;
        for(int i = 1; i < A.length - 1; i++){
            int min = Math.min(leftMax[i - 1], rightMax[i + 1]);
            int diff = min > A[i] ? min - A[i] : 0;
            sum += diff;
        }
        return sum;
    }
}
