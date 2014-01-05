package leetcode.permutation;

public class PermutationSequence {
    
    public String getPermutation(int n, int k) {
        if(n == 0)
            return "";
        
        int[] array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = i + 1;
        
        return getPermutationFromArray(array, k);
    }
    
    public String getPermutationFromArray(int[] array, int k){
        int n = array.length;
        if(n == 0)
            return "";
        if(n == 2){
            if(k == 1)
                return array[0] + "" + array[1];
            else
                return array[1] + "" + array[0];
        }
        int fact = 1;
        for (int c = 1 ; c <= n - 1; c++)
            fact = fact*c;
        
        int firstNum = (int) Math.ceil((float)k/fact) - 1;
        int nextK = k % fact == 0 ? fact : k % fact;
        
        int[] subArray = new int[n-1];
        int x = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != array[firstNum]){
                subArray[x] = array[i];
                x++;
            }
        }
        return array[firstNum] + getPermutationFromArray(subArray, nextK);
    }
    
    
    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(4, 5));
    }

}
