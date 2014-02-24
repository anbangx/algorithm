package leetcode.secondround;

import java.util.ArrayList;
import java.util.HashSet;

public class PermutationSequence {
	public void getPermutationUtil(int n, HashSet<Integer> visited, StringBuilder candidate, ArrayList<String> results){
        if(visited.size() == n){
            results.add(candidate.toString());
            return;
        }    
        for(int i = 1; i <= n; i++){
            if(visited.contains(i))
                continue;
            candidate.append(i);
            visited.add(i);
            getPermutationUtil(n, visited, candidate, results);
            visited.remove(i);
            candidate.deleteCharAt(candidate.length() - 1);
        }
    }
    
    public String getPermutation(int n, int k) {
        ArrayList<String> results = new ArrayList<String>();
        getPermutationUtil(n, new HashSet<Integer>(), new StringBuilder(), results);
        return results.get(k - 1);
    }
    
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(8, 15485));
	}

}
