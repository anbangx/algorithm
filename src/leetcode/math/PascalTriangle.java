package leetcode.math;
import java.util.ArrayList;


public class PascalTriangle {
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return result;
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        result.add(lastRow);
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> curRow = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i)
                    curRow.add(1);
                else
                    curRow.add(lastRow.get(j-1) + lastRow.get(j));
            }
            lastRow = curRow;
            result.add(lastRow);
        }
        return result;
    }
    
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
    }

}
