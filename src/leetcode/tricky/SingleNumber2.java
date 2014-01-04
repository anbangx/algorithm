package leetcode.tricky;

public class SingleNumber2 {
    
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = A.length;
        if(length == 0)
            return 0;
        
        int[] counts = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < length; j++){
                if(((A[j] >> i) & 1) == 1){
                    counts[i] = (counts[i] + 1) % 3; 
                }
            }
            result |= (counts[i] << i);
        }
        return result;
    }
    
    public static void main(String[] args) {

    }

}
