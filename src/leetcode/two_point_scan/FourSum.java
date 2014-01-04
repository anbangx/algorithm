package leetcode.two_point_scan;
import java.util.ArrayList;
import java.util.Arrays;


public class FourSum {
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4)
            return results;
        int len = num.length;
        Arrays.sort(num);
        for(int i = 0; i < len - 3; i++){
            if(num[i] > 0 && num[i] > target)    break;
            for(int j = i + 1; j < len - 2; j++){
                if(num[j] > 0 && num[i] + num[j] > target)    break;
                int start = j + 1;
                int end = len - 1;
                while(start < end){
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if(sum == target){
                        ArrayList<Integer> output = new ArrayList<Integer>();
                        output.add(num[i]);
                        output.add(num[j]);
                        output.add(num[start]);
                        output.add(num[end]);
                        results.add(output);
                        start++;
                        end--;
                        while(start<end && num[start] == num[start-1]) start++;
                        while(start<end && num[end] == num[end+1]) end--;
                    } else if(sum < target)
                        start++;
                    else
                        end--;
                }
                while(j < len - 2 && num[j + 1] == num[j])
                    j++;
            }
            while(i < len - 3 && num[i + 1] == num[i])
                i++;
        }
        return results;
    }
    
    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] num = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(fs.fourSum(num, -11));
    }

}
