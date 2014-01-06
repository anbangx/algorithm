package leetcode.merge;
import java.util.Arrays;


public class MergeSortedArray {
    
    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] answer = new int[m + n];
        int i = 0, j = 0, k = 0;
    
        while (i < m && j < n){
            if (A[i] < B[j])       
                answer[k++] = A[i++];
            else        
                answer[k++] = B[j++];               
        }
    
        while (i < m)  
            answer[k++] = A[i++];
    
        while (j < n)    
            answer[k++] = B[j++];
        System.arraycopy(answer, 0, A, 0, m + n);
    }
    
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] A = new int[10];
        int[] B = {1};
        msa.merge(A, 0, B, 1);
        System.out.println(Arrays.toString(A));
    }

}
