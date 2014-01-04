package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return results;
        int len = num.length;
        Arrays.sort(num);
        for(int i = 0; i < len; i++){
            int target = 0 - num[i];
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                if(target == num[start] + num[end]){
                    ArrayList<Integer> output = new ArrayList<Integer>();
                    output.add(num[i]);
                    output.add(num[start]);
                    output.add(num[end]);
                    results.add(output);
                    start++;
                    end--;
                    while(start<end && num[start] == num[start-1]) start++;
                    while(start<end && num[end] == num[end+1]) end--;
                } else if(target > num[start] + num[end])
                    start++;
                else
                    end--;
            }
            while(i < len - 1 && num[i + 1] == num[i])
                i++;
        }
        return results;
    }
        
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        // testcase 1
        int num[] = {1,-1,-1,0};
        System.out.println(threeSum.threeSum(num));
    }

}
