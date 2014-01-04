package leetcode;

public class SearchRange {

    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if(A == null || A.length == 0)
            return result;
        
        int targetIdx = findTarget(A, 0, A.length - 1, target);
        if(targetIdx == -1)
            return result;
        
        int left = targetIdx;
        while(left > 0){
            if(A[left - 1] != target)
                break;
            left--;
        }
        int right = targetIdx;
        while(right < A.length - 1){
            if(A[right + 1] != target)
                break;
            right++;
        }
        
        result[0] = left;
        result[1] = right;
        return result;
    }
    
    public int findTarget(int[] A, int start, int end, int target){
        if(A == null || A.length == 0)
            return -1;
        
        if(start >= end && A[start] != target)
            return -1;
            
        int mid = (start + end)/2;
        if(target == A[mid])
            return mid;
        else if(target < A[mid])
            return findTarget(A, start, mid - 1, target);
        else
            return findTarget(A, mid + 1, end, target);
    }
    
    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] A = {1,3};
        int target = 1;
        System.out.println(sr.searchRange(A, target));
    }

}
