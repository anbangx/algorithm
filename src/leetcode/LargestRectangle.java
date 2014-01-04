package leetcode;

public class LargestRectangle {
    
    public int largestRectangleArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(height == null || height.length == 0)
            return 0;
        if(height.length == 1)
            return height[0];
        int[] area = new int[height.length];
        for(int i = 0; i < height.length; i++){
            if(i > 0 && i < height.length - 1 && height[i] == height[i+1])
                continue;
            area[i] = height[i];
            int left = i - 1;
            while(left >= 0 && height[left] >= height[i]){
                area[i] += height[i];
                left--;
            }
            int right = i + 1;
            while(right < height.length && height[right] >= height[i]){
                area[i] += height[i];
                right++;
            }
        }
        int max = 0;
        for(int i = 0; i < area.length; i++){
            if(max < area[i])
                max = area[i];
        }
        return max;
    }
    
    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();
        int[] height = {2, 4};
        System.out.println(lr.largestRectangleArea(height));
    }

}
