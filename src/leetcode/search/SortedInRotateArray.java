package leetcode.search;

public class SortedInRotateArray {
    
    public int search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null || A.length == 0)
            return -1;
        if(A.length == 1){
            if(A[0] == target)
               return 0;
            else
               return -1;
        }
        int l = 0;
        int r = A.length - 1;
        int m = 0;
        while(l <= r){
            m = (l + r)/2;
            if(target == A[m])  return m;
            else if(A[m] >= A[l]){
                if(target <= A[m] && target >= A[l])
                    r = m - 1;
                else
                    l = m + 1;
            } else{
                if(target >= A[l] || target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        SortedInRotateArray sra = new SortedInRotateArray();
        int[] A = {1, 3};
        System.out.println(sra.search(A, 3));
    }

}
