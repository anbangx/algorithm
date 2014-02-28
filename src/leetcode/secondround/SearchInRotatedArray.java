package leetcode.secondround;

public class SearchInRotatedArray {

	public int search(int[] A, int target) {
        if(A == null || A.length == 0)  return -1;
        if(A.length == 1){
            return A[0] == target ? 0 : -1;
        }
        
        int left = 0; int right = A.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(A[mid] == target)    return mid;
            if(mid == left){
                return A[right] == target ? right : -1;
            }
            if(A[mid] > A[left]){
                if(target >= A[left] && target < A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else{
                if(target > A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		SearchInRotatedArray sra = new SearchInRotatedArray();
		int[] A = {1, 3, 5};
		System.out.println(sra.search(A, 1));
	}

}
