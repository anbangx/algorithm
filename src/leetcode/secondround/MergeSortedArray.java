package leetcode.secondround;

public class MergeSortedArray {

  public void merge(int A[], int m, int B[], int n) {
        int end = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[end--] = A[i--];
            } else{
                A[end--] = B[j--];
            }
        }
        while(j >= 0){
            A[end--] = B[j--];
        }
    }
  
	public static void main(String[] args) {
		int[] A = {0};
		int[] B = {1};
		test(A, 0, B, 1);
	}
	
	public static void test(int[] A, int m, int B[], int n){
		MergeSortedArray msa = new MergeSortedArray();
		msa.merge(A, m, B, n);
	}

}
