package leetcode;
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
        ArrayList<Integer> curOutput;
        for(int i = step; i < S.length; i++){
            curOutput = new ArrayList<Integer>(output);
            curOutput.add(S[i]);
            results.add(new ArrayList<Integer>(curOutput));
            while(i+1 < S.length && S[i+1] == S[i]){
                i++;
                curOutput.add(S[i]);
                results.add(new ArrayList<Integer>(curOutput));
            }
            if(i < S.length - 1)
                genSubset(S, i + 1, curOutput, results);
        }
    }
    
    public static void main(String[] args) {
        Subset2 ss = new Subset2();
        int[] S = {1, 2};
        System.out.println(ss.subsetsWithDup(S));
    }

}
