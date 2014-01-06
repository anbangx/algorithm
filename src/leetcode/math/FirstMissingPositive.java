package leetcode.math;

public class FirstMissingPositive {
    
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0)
            return 1;
        
        for(int i = 0; i < A.length; i++){
            while(A[i] != i + 1){
                if(A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] -1])
                    break;
                int temp = A[i];
                A[i] = A[A[i] - 1];
                A[temp - 1] = temp;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
    
    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] A = {1};
        System.out.println(fmp.firstMissingPositive(A));
    }

}
