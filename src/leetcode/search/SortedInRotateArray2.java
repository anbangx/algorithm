package leetcode.search;

public class SortedInRotateArray2 {
    
    public boolean search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null || A.length == 0)
            return false;
        if(A.length == 1){
            if(A[0] == target)
               return true;
            else
               return false;
        }
        int l = 0;
        int r = A.length - 1;
        int m = 0;
        while(l <= r){
            m = (l + r)/2;
            if(target == A[m])  return true;
            else if(A[m] > A[l]){
                if(target <= A[m] && target >= A[l])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (A[m] < A[l]){
                if(target >= A[l] || target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else
                l++;  
        }
        return false;
    }
    
    public static void main(String[] args) {
        SortedInRotateArray2 sra = new SortedInRotateArray2();
        int[] A = {1, 3};
        System.out.println(sra.search(A, 3));
    }

}
