package leetcode;
import java.util.ArrayList;
import java.util.HashSet;


public class Permutation4 {
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return results;
        if(num.length == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(num[0]);
            results.add(result);
            return results;
        }
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++){
             int[] subArray = removeElement(num, i);
             ArrayList<ArrayList<Integer>> subresults = permuteUnique(subArray);
             for(ArrayList<Integer> subresult : subresults){
                 subresult.add(0, num[i]);
                 set.add(subresult);
             }
        }
        results = new ArrayList<ArrayList<Integer>>(set);
        return results;
    }
    
    public int[] removeElement(int[] array, int elemIdx){
        int[] subArray = new int[array.length - 1];
        int x = 0;
        for(int i = 0; i < array.length; i++){
            if(i!= elemIdx){
                subArray[x] = array[i];
                x++;
            }
        }
        return subArray;
    }
    
    public static void main(String[] args) {
        Permutation4 p4 = new Permutation4();
        int[] num = {3,3,0,0};
        System.out.println(p4.permuteUnique(num));
    }

}
