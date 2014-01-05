package leetcode.sum;
import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum2 {
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return results;
        Arrays.sort(num);
        dfs(num, target, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    public void dfs(int[] num, int target, int startIdx, ArrayList<Integer> candidate, ArrayList<ArrayList<Integer>> results){
        for(int i = startIdx; i < num.length; i++){
            if(num[i] == target){
                candidate.add(num[i]);
                results.add(new ArrayList<Integer>(candidate));
                candidate.remove(candidate.size() - 1);
            } else if(num[i] < target){
                candidate.add(num[i]);
                dfs(num, target - num[i], i + 1, candidate, results);
                candidate.remove(candidate.size() - 1);
            } else
                return;
            while(i + 1 < num.length && num[i + 1] == num[i])
                i++;
        }
    }
    
    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        int[] num = {1};
        int target = 1;
        System.out.println(cs.combinationSum2(num, target));
    }

}
