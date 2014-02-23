package GeekForGeek.Interview.mapr;

public class FindPeekElement {
	
	int findPeak(int arr[]) {
	    if(arr == null || arr.length == 0)
	        return -1;
	    int len = arr.length;
	    if(len == 1)
	        return arr[0];
	        
	    int left = 0;
	    int right = len - 1;
	    while(left <= right){
	        int mid = left + (right - left)/2; // idx: 5,  idx: 7
	        if((mid == 0 || arr[mid-1] < arr[mid]) &&
	                (mid == len - 1 || arr[mid+1] < arr[mid])) 
	            return arr[mid]; 
	        else if(mid > 0 && arr[mid] < arr[mid - 1]){ 
	        	right = mid - 1; // right = 6
	        } else{ 
	        	left = mid + 1; // left = 
	        }
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 3};
		test(A);
	}
	
	public static void test(int[] A){
		FindPeekElement fpe = new FindPeekElement();
		System.out.println(fpe.findPeak(A));
	}

}
