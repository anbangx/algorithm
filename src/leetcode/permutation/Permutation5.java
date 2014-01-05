package leetcode.permutation;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation5 {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return results;

        Arrays.sort(num);
        permute(num, new boolean[num.length], new ArrayList<Integer>(), results);
        
        return results;
    }

    public void permute(int[] num, boolean[] visited, ArrayList<Integer> candidate,
            ArrayList<ArrayList<Integer>> results) {
        if(num.length == candidate.size()){
            results.add(new ArrayList<Integer>(candidate));
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(!visited[i]){
                if(i > 0 && num[i - 1] == num[i] && visited[i - 1] != true)
                    continue;
                candidate.add(num[i]);
                visited[i] = true;
                permute(num, visited, candidate, results);
                visited[i] = false;
                candidate.remove(candidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation5 p5 = new Permutation5();
        int[] num = {1,1,2};
        System.out.println(p5.permuteUnique(num));
    }

}
