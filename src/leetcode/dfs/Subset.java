package leetcode.dfs;
import java.util.ArrayList;
import java.util.Arrays;


public class Subset {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> candidate = new ArrayList<Integer>();
        if(S == null || S.length == 0)
            candidate.add(null); 
        results.add(candidate);
        if(S.length > 0){
            Arrays.sort(S);
            genSubset(S, 0, candidate, results);
        }
        return results;
    }
    
    public void genSubset(int[] S, int step, ArrayList<Integer> candidate, ArrayList<ArrayList<Integer>> results){
        for(int i = step; i < S.length; i++){
            candidate.add(S[i]);
            results.add(new ArrayList<Integer>(candidate));
            if(i < S.length - 1)
                genSubset(S, i + 1, candidate, results);
            candidate.remove(candidate.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Subset ss = new Subset();
        int[] S = {1,2,3};
        System.out.println(ss.subsets(S));
    }

}
