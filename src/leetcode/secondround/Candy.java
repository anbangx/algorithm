package leetcode.secondround;

public class Candy {

	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)  return 0;
        
        int len = ratings.length;
        int[] A = new int[len];
        A[0] = 1;
        int min = 1;
        int totalCandy = A[0];
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i - 1]){
                A[i] = A[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1]){
                A[i] = A[i - 1] - 1;
                min = Math.min(A[i], min);
            } else
                A[i] = A[i - 1];
            totalCandy += A[i];
        }
        int extra = 0;
        if(min <= 0){
            extra = len * ((0 - min) + 1);
        }
        return totalCandy + extra;
    }
	
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = {2, 2};
		System.out.println(c.candy(ratings));
	}

}
