package leetcode.recursive;
import java.util.ArrayList;
import java.util.HashSet;

public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (n == 0) {
            results.add(0);
            return results;
        }
        if (n == 1) {
            results.add(0);
            results.add(1);
            return results;
        }
        if (n == 2) {
            results.add(0);
            results.add(1);
            results.add(3);
            results.add(2);
            return results;
        }

        ArrayList<Integer> prev = grayCode(n - 1);
        results.addAll(prev);

        int extra = (int) Math.pow(2, n - 1);
        ArrayList<Integer> newHalf = new ArrayList<Integer>();
        for (int i = prev.size() - 1; i >= 0; i--) {
            newHalf.add(prev.get(i) + extra);
        }
        results.addAll(newHalf);

        return results;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
    }

}
