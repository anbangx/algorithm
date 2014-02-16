package GeekForGeek.Array;

public class Segregate0and1 {
	
	public int[] segregate0and1(int[] A){
	    if(A == null || A.length == 0)
	        return A;

	    int len = A.length;
	    int left = 0; int right = len - 1;
	    while(left < right){
	        while(A[left] == 0)
	            left++;
	        while(A[right] == 1)
	            right--;
	        if(left > right)
	            break;

	        // swap
	        int temp = A[left];
	        A[left] = A[right];
	        A[right] = temp;
	    }

	    return A;
	}
	
	public static void main(String[] args) {
		Segregate0and1 s = new Segregate0and1();
		int[] A = {1,0,0,0,1,0,1,0,1,1,0,1,0,1};
		int[] B = s.segregate0and1(A);
		for(int i = 0; i < B.length; i++)
			System.out.println(B[i]);
	}

}
