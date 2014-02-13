package GeekForGeek.whiteboard.array;

public class LongestConsecutiveSubstringOf1s0s {
	
	public int getLongestConsecutiveSubstring(int[] A){
		if(A == null || A.length == 0)
			return 0;
		
		int len = A.length;
		int[] helper = new int[len];
		if(A[0] == 0)
			helper[0] = -1;
		else
			helper[0] = 1;
		for(int i = 1; i < len; i++){
			if(A[i] == 0)
				helper[i] = helper[i - 1] - 1;
			else
				helper[i] = helper[i - 1] + 1;
		}
		boolean increase = helper[1] > helper[0] ? true : false;
		int curCount = 2;
		int maxCount = Integer.MIN_VALUE;
		for(int i = 2; i < len; i++){
			if((helper[i] > helper[i - 1] && increase)
					|| (helper[i] < helper[i - 1] && !increase)){
				curCount++;
				maxCount = curCount > maxCount ? curCount : maxCount;
			} else{
				curCount = 1;
				increase = helper[i] > helper[i - 1] ? true : false;
			}
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		LongestConsecutiveSubstringOf1s0s lc = new LongestConsecutiveSubstringOf1s0s();
		int[] A = {0,1,1,1,0,0,1,1,1,1,0};
		System.out.println(lc.getLongestConsecutiveSubstring(A));
	}

}
