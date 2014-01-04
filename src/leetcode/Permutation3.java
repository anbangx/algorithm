package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Permutation3 {
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
        
        // 1. get duplicatePermutations
        ArrayList<ArrayList<Integer>> duplicatePermutes = permute(num);
        
        // 2. build a set to store uniquePermutes
        Set<ArrayList<Integer>> uniquePermutes = new HashSet<ArrayList<Integer>>();
        for(ArrayList<Integer> permute : duplicatePermutes)
            uniquePermutes.add(permute);
        
        // 3. convert uniquePermutes set to result
        for(ArrayList<Integer> permute : uniquePermutes)
            results.add(permute);
        
        return results;
    }
    
    public static void main(String[] args) {
        Permutation3 p3 = new Permutation3();
        int[] num = {};
        System.out.println(p3.permuteUnique(num));
    }
    
    
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
             int[] subArray = removeElementIdx(num, i);
             ArrayList<ArrayList<Integer>> subresults = permute(subArray);
             for(ArrayList<Integer> subresult : subresults){
                 subresult.add(0, num[i]);
             }
             results.addAll(subresults);
        }
        return results;
    }
    
    public int[] removeElementIdx(int[] array, int elemIdx){
        int[] subArray = new int[array.length - 1];
        int x = 0;
        for(int i = 0; i < array.length; i++){
            if(i != elemIdx){
                subArray[x] = array[i];
                x++;
            }
        }
        return subArray;
    }

}
