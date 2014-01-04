package leetcode;
import java.util.Arrays;


public class ThreeSumClosest {
    
    public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num == null || num.length == 0)
            return 0;
        int len = num.length;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(num);
        int closestSum = 0;
        for(int i = 0; i < len; i++){
            int cursor = num[i];
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                if(cursor + num[start] + num[end] == target){
                    return target;
                } else if(cursor + num[start] + num[end] < target){
                    if(minDiff > target - (cursor + num[start] + num[end])){
                        minDiff = target - (cursor + num[start] + num[end]);
                        closestSum = cursor + num[start] + num[end];
                    }
                    start++;
//                    while(start<end && num[start] == num[start-1]) start++;
                }
                else{
                    if(minDiff > (cursor + num[start] + num[end]) - target){
                        minDiff = (cursor + num[start] + num[end]) - target;
                        closestSum = cursor + num[start] + num[end];
                    }
                    end--;
//                    while(start<end && num[end] == num[end+1]) end--;
                }
            }
//            while(i < len - 1 && num[i + 1] == num[i])
//                i++;
        }
        return closestSum;
    }
    
    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] num = {1, 1, 1, 0};
        System.out.println(tsc.threeSumClosest(num, 100));
    }

}
