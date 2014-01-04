package leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0)
            return results;
        
        Arrays.sort(candidates);
        
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] > target)
                break;
            output.add(candidates[i]);
            if(candidates[i] == target)
                results.add(new ArrayList<Integer>(output));
            getCombination(candidates, i, target - candidates[i], output, results);
            output.remove(output.size() - 1);
        }
        return results;
    }
    
    public void getCombination(int[] candidates, int startIdx, int target, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> results) {
        for(int i = startIdx; i < candidates.length; i++){
            if(candidates[i] > target)
                return;
            else if(candidates[i] == target){
                output.add(candidates[i]);
                results.add(new ArrayList<Integer>(output));
                output.remove(output.size() - 1);
                return;
            } else{
                output.add(candidates[i]);
                getCombination(candidates, i, target - candidates[i], output, results);
                output.remove(output.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {1,2};
        int target = 2;
        System.out.println(cs.combinationSum(candidates, target));
    }

}
