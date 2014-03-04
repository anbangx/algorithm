package leetcode.secondround;

public class SingleNumber2 {

	public int singleNumber(int[] A) {
        int[] bit = new int[32]; 
        int len = A.length;
        int rotated;
        for(int i = 0; i < len; i++){
            int k = 1;
            for(int j = 0; j < 32; j++){
                if((rotated = (A[i] >> j)) == 0) break;
                bit[j] += rotated & k;
            }
        }
        int target = 0;
        for(int i = 0; i < 32; i++){
            target += (bit[i] % 3) << i;
        }
        return target;
    }
	
	public static void main(String[] args) {
		SingleNumber2 sn = new SingleNumber2();
		int[] A = {1};
		System.out.println(sn.singleNumber(A));
	}

}
