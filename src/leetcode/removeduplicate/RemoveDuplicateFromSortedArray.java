package leetcode.removeduplicate;

public class RemoveDuplicateFromSortedArray {
    
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null || A.length == 0)
            return 0;
        int preItem = A[0];
        int numUnique = 1;
        for(int i = 1; i < A.length; i++){
            if(preItem != A[i]){
                numUnique++;
            }
        }
        return numUnique;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
