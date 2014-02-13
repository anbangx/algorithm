package GeekForGeek.whiteboard.array;

public class LargestSumContiguousSubarray {
	
	public int getMaximalSubarray(int[] A){
		if(A == null || A.length == 0)
			return 0;
		
		int maxSofar = 0;
		int maxEndhere = 0;
		for(int i = 0; i < A.length; i++){
			maxEndhere += A[i];
			if(maxEndhere < 0)
				maxEndhere = 0;
			maxSofar = maxEndhere > maxSofar ? maxEndhere : maxSofar;
		}
		
		return maxSofar;
	}
	
	public static void main(String[] args) {
		LargestSumContiguousSubarray lss = new LargestSumContiguousSubarray();
		int[] A = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(lss.getMaximalSubarray(A));
	}

}
