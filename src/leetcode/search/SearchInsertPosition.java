package leetcode.search;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null || A.length == 0)
            return 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] >= target)
                return i;
        }
        return A.length;
    }
}
