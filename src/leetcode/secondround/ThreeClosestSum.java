package leetcode.secondround;

import java.util.Arrays;

public class ThreeClosestSum {

	public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        int minDiff = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for(int i = 0; i < len - 2; i++){
            int twoSum = target - num[i];
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int curSum = num[left] + num[right];
                if(curSum == twoSum){
                    return target;
                } else if(curSum < twoSum){
                    if(twoSum - curSum < minDiff){
                        minDiff = twoSum - curSum;
                        closestSum = twoSum + num[i];
                    }
                    left++;
                } else{
                    if(curSum - twoSum < minDiff){
                        minDiff = curSum - twoSum;
                        closestSum = twoSum + num[i];
                    }
                    right--;
                }
            }
        }
        return closestSum;
    }
	
	public static void main(String[] args) {
		ThreeClosestSum tcs = new ThreeClosestSum();
		int[] num = {0, 0, 0};
		System.out.println(tcs.threeSumClosest(num, 1));
	}

}
