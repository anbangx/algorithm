package leetcode.math;
import java.util.ArrayList;


public class PascalTriangle2 {
    
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] array = new int[rowIndex+1];
        array[0] = 1;
        if(rowIndex == 0)
            return getList(array);
        array[1] = 1;
        if(rowIndex == 1)
            return getList(array);
        int i = 0;
        int j = 0;
        for(i = 1; i < rowIndex + 1; i++){
            for(j = i - 1; j > 0; j--)
                array[j] = array[j] + array[j-1];
            array[i] = 1;
        }
        return getList(array);
    }
    
    public ArrayList<Integer> getList(int[] nums){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        PascalTriangle2 pt = new PascalTriangle2();
        System.out.println(pt.getRow(3)); 
    } 

}
