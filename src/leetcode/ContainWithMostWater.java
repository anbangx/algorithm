package leetcode;

public class ContainWithMostWater {
    
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxarea = 0;
        while(left < right){
            int curarea = Math.min(height[left], height[right]) * (right - left);
            maxarea = maxarea < curarea ? curarea : maxarea;
            if(height[left] < height[right]){
                left++;
            } else { 
                right--;
            }
        }
        return maxarea;
    }
    
    public static void main(String[] args) {
        ContainWithMostWater cwm = new ContainWithMostWater();
        int[] height = {1, 1};
        System.out.println(cwm.maxArea(height));
    }

}
