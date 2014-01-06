package leetcode.dfs;
import java.util.ArrayList;
import java.util.Arrays;


public class Subset2 {
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        if(S == null || S.length == 0)
            output.add(null); 
        results.add(output);
        if(S.length > 0){
            Arrays.sort(S);
            genSubset(S, 0, output, results);
        }
        return results;
    }
    
    public void genSubset(int[] S, int step, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> results){
        for(int i = step; i < S.length; i++){
            output.add(S[i]);
            results.add(new ArrayList<Integer>(output));
            if(i < S.length - 1)
                genSubset(S, i + 1, output, results);
            output.remove(output.size() - 1);
            while(i < S.length - 1 && S[i+1] == S[i])
                i++;
        }
    }
    
    public static void main(String[] args) {
        Subset2 ss = new Subset2();
        int[] S = {1, 2, 2};
        System.out.println(ss.subsetsWithDup(S));
    }

}
