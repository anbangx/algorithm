package leetcode.permutation;
import java.util.ArrayList;


public class Permutation {
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return results;
        if(num.length == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(num[0]);
            results.add(result);
            return results;
        }
        for(int i = 0; i < num.length; i++){
             int[] subArray = removeElement(num, i);
             ArrayList<ArrayList<Integer>> subresults = permute(subArray);
             for(ArrayList<Integer> subresult : subresults){
                 subresult.add(0, num[i]);
             }
             results.addAll(subresults);
        }
        return results;
    }
    
    public int[] removeElement(int[] array, int elemIdx){
        int[] subArray = new int[array.length - 1];
        int x = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != array[elemIdx]){
                subArray[x] = array[i];
                x++;
            }
        }
        return subArray;
    }
    
    public static void main(String[] args) {

    }

}
