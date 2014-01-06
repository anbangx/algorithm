package leetcode.math;

public class MediaOfTwoSortedArray {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A == null || A.length == 0){
            if(B.length % 2 == 0)
                return (B[B.length/2 - 1] + B[B.length/2]) / 2.0;
            else
                return B[B.length/2];
        }
        if(B == null || B.length == 0){
            if(A.length % 2 == 0)
                return (A[A.length/2 - 1] + A[A.length/2]) / 2.0;
            else
                return A[A.length/2];
        }
        int n = A.length;
        int m = B.length;
        if((m + n) % 2 == 0)
            return (getMedian(A, 0, n, B, 0, m, (n + m)/2) + getMedian(A, 0, n, B, 0, m, (n + m)/2 + 1)) / 2;
        else
            return getMedian(A, 0, n, B, 0, m, (n + m)/2 + 1);
    }
    
    public double getMedian(int A[], int A_startIdx, int n, int B[], int B_startIdx, int m, int k){
        if(k == 4)
            System.out.println();
        if(n <= 0)
            return B[B_startIdx + k - 1];
        if(m <= 0)
            return A[A_startIdx + k - 1];
        if(k <= 1)
            return Math.min(A[A_startIdx], B[B_startIdx]);
        
        if(A[A_startIdx + n/2] <= B[B_startIdx + m/2]){
            if(n/2 + m/2 + 1 >= k){
                return getMedian(A, A_startIdx, n, B, B_startIdx, m/2, k);
            } else {
                return getMedian(A, A_startIdx + n/2 + 1, n - (n/2 + 1), B, B_startIdx, m, k - ((n/2 + 1)));
            }
        } else{
             if(n/2 + m/2 + 1 >= k){
                 return getMedian(A, A_startIdx, n/2, B, B_startIdx, m, k);
             } else{
                 return getMedian(A, A_startIdx, n, B, B_startIdx + m/2 + 1, m - (m/2 + 1), k - (m/2 + 1));
             }
        }
    }
    
    public static void main(String[] args) {
        MediaOfTwoSortedArray mtsa = new MediaOfTwoSortedArray();
        int[] A = {1,2,2};
        int[] B = {1,2,3};
        System.out.println(mtsa.findMedianSortedArrays(A, B));
    }

}
