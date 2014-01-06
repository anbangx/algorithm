package leetcode.recursive;
import java.util.ArrayList;


public class Combination {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        // base case
        if (k == 0)
            return results;
        if (n == k) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++)
                result.add(i);
            results.add(result);
            return results;
        }
        // if doesn't pick num n as required element
        ArrayList<ArrayList<Integer>> nopickSelf = combine(n - 1, k);

        // otherwise
        ArrayList<ArrayList<Integer>> pickSelf = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> subSet = combine(n - 1, k - 1);
        if (subSet.size() == 0) {
            ArrayList<Integer> singleSet = new ArrayList<Integer>();
            singleSet.add(n);
            pickSelf.add(singleSet);
        } else {
            for (ArrayList<Integer> singleSet : subSet) {
                singleSet.add(n);
                pickSelf.add(singleSet);
            }
        }

        results.addAll(nopickSelf);
        results.addAll(pickSelf);
        return results;
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(combination.combine(4, 2));
    }

}
