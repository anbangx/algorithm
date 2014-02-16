package GeekForGeek.Array;

public class Segregate01And2 {
	
	public int[] sort01And2(int[] A){
	    if(A == null || A.length == 0)
	        return A;
	    int left = 0; int mid = 0; int right = A.length - 1;
	    while(mid <= right){
	        if(A[mid] == 0){
	        	// swap
	            int temp = A[mid];
	            A[mid] = A[left];
	            A[left] = temp;
	            left++;
	            mid++;
	        } else if(A[mid] == 1){
	            mid++;
	        } else{
	            // swap
	            int temp = A[mid];
	            A[mid] = A[right];
	            A[right] = temp;
	            right--;
	        }
	    }
	    return A;
	}
	
	public static void main(String[] args) {
		Segregate01And2 s = new Segregate01And2();
		int[] A = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int[] B = s.sort01And2(A);
		for(int i = 0; i < B.length; i++)
			System.out.println(B[i]);
	}

}
