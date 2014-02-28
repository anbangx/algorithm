package leetcode.secondround;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)    return 0;
        
        int len = height.length;
        int maxArea = 0;
        int curArea = 0;
        Stack<Integer> barStack = new Stack<Integer>();
        Stack<Integer> idxStack = new Stack<Integer>();
        int startIdx = 0;
        for(int i = 0; i < len; i++){
        	if(height[i] == 0){
                startIdx = i + 1;
                continue;
            }
            if(barStack.isEmpty() || barStack.peek() <= height[i]){
                barStack.push(height[i]);
                idxStack.push(i);
            } else{
                while(!barStack.isEmpty() && barStack.peek() > height[i]){
                    int barHeight = barStack.pop();
                    int popIdx = idxStack.pop();
                    int dist = i - popIdx;
                    if(!barStack.isEmpty())
                        curArea = barHeight * (popIdx - startIdx + 1);
                    else
                        curArea = barHeight * dist;
                    maxArea = curArea > maxArea ? curArea : maxArea;
                }
                barStack.push(height[i]);
                idxStack.push(i);
            }
        }
        int right = len - 1;
        while(barStack.size() > 1){
            int barHeight = barStack.pop();
            int dist = right - idxStack.pop() + 1;
            curArea = barHeight * dist;
            maxArea = curArea > maxArea ? curArea : maxArea;
        }
        if(barStack.size() == 1){
            int barHeight = barStack.pop();
            int dist = right - startIdx + 1;
            curArea = barHeight * dist;
            maxArea = curArea > maxArea ? curArea : maxArea;
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		int height[] = {0, 2, 0};
		System.out.println(lr.largestRectangleArea(height));
	}

}
