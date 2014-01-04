package leetcode.tricky;

public class SingleNumber {
    
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int xorSum = 0;
        for(int i = 0; i < A.length; i++){
            xorSum ^= A[i];
        }
        return xorSum;
    }
    
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] A = {1,2,3,4,5,4,3,2,1};
        System.out.println(sn.singleNumber(A));
    }

}
