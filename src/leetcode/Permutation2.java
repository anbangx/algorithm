package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Permutation2 {
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // 1. build a map to store <value count>
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return results;
        if(num.length == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(num[0]);
            results.add(result);
            return results;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            if(map.containsKey(num[i])){
                int count = map.get(num[i]);
                count++;
                map.put(num[i], count);
            } else{
                map.put(num[i], 1);
            }
        }
        // 2. convert map to the array which only has unique element
        int[] uniqueNum = new int[map.size()];
        int index = 0;
        for(int key : map.keySet()){
            uniqueNum[index] = key;
            index++;
        }
        // 3. permute uniqueNum
        ArrayList<ArrayList<Integer>> uniquePermutes = permute(uniqueNum);
        for(ArrayList<Integer> permute : uniquePermutes){
            ArrayList<Integer> newPermute = new ArrayList<Integer>();
            for(int elem : permute){
                for(int i = 0; i < map.get(elem); i++){
                    newPermute.add(elem);
                }
            }
            results.add(newPermute);
        }
        return results;
    }
    
    public static void main(String[] args) {
        Permutation2 p2 = new Permutation2();
        int[] num = {1,1,2};
        System.out.println(p2.permuteUnique(num));
    }
    
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
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
        for(int i = 0; i < num.length; i++){
             int[] subArray = removeElement(num, i);
             ArrayList<ArrayList<Integer>> subresults = permute(subArray);
             for(ArrayList<Integer> subresult : subresults){
                 subresult.add(0, num[i]);
             }
             results.addAll(subresults);
        }
        return results;
    }
    
    public int[] removeElement(int[] array, int elemIdx){
        int[] subArray = new int[array.length - 1];
        int x = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != array[elemIdx]){
                subArray[x] = array[i];
                x++;
            }
        }
        return subArray;
    }

}
