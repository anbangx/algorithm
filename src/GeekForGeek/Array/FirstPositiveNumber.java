package GeekForGeek.Array;

public class FirstPositiveNumber {

	public void swap(int[] A, int x, int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0)  return 1;
        
        // move non-postive to front
        int len = A.length;
        int start = 0;
        for(int i = 0; i < len; i++){
            if(A[i] <= 0){
                swap(A, i, start++);
            }
        }
        // use array index to mark occur positive
        int posLen = len - start;
        for(int i = start; i < len; i++){
            if(Math.abs(A[i]) <= posLen){
                int index = start + Math.abs(A[i]) - 1;
                A[index] = 0 - A[index];   
            }
        }
        // find smallest postive
        int i = start;
        for(; i < len; i++){
            if(A[i] > 0)
                break;
        }
        return i - start + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
