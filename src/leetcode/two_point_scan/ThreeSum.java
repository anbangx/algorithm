package leetcode.two_point_scan;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        // base case
        if (num == null || num.length == 0)
            return results;
        // sort
        int len = num.length;
        Arrays.sort(num);
        for (int i = 0; i < len; i++) {
            int target = 0 - num[i];
            int start = i + 1;
            int end = len - 1;
            // shrink the window
            while (start < end) {
                if (target == num[start] + num[end]) {
                    ArrayList<Integer> output = new ArrayList<Integer>();
                    output.add(num[i]);
                    output.add(num[start]);
                    output.add(num[end]);
                    results.add(output);
                    start++;
                    end--;
                    // skip duplicate value in the two points
                    while (start < end && num[start] == num[start - 1])
                        start++;
                    while (start < end && num[end] == num[end + 1])
                        end--;
                } else if (target > num[start] + num[end])
                    start++;
                else
                    end--;
            }
            // skip duplicate value in the first number
            while (i < len - 1 && num[i + 1] == num[i])
                i++;
        }
        return results;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        // testcase 1
        int num[] = { 1, -1, -1, 0 };
        System.out.println(threeSum.threeSum(num));
    }

}
