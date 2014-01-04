package leetcode;
import java.util.ArrayList;


public class PascalTriangle2 {
    
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        if(rowIndex > 1)
            array.add(1);
        for(int i = 1; i < rowIndex + 1; i++){
            if(i == rowIndex)
                array.add(1);
            else
                array.set(i, array.get(i) + array.get(i-1));
        }
        return array;
    }
    
    public static void main(String[] args) {
        PascalTriangle2 pt = new PascalTriangle2();
        System.out.println(pt.getRow(3)); 
    } 

}
