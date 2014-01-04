package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {
    
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return null;
        
        // <value,oldIndex>
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < numbers.length; i++){
            ArrayList<Integer> list;
            if(map.containsKey(numbers[i]))
                list = map.get(numbers[i]);
            else{
                list = new ArrayList<Integer>();
                map.put(numbers[i], list);
            }
            list.add(i);
        }
        Arrays.sort(numbers);
        int[] result = new int[2];
        for(int i = 0; i < numbers.length - 1; i++){
            if(numbers[i] > target)
                continue;
            for(int j = i + 1;j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    if(numbers[i] == numbers[j]){
                        int lessIdx = map.get(numbers[i]).get(0) < map.get(numbers[i]).get(1) ? map.get(numbers[i]).get(0) : map.get(numbers[i]).get(1);
                        int biggerIdx = map.get(numbers[i]).get(0) > map.get(numbers[i]).get(1) ? map.get(numbers[i]).get(0) : map.get(numbers[i]).get(1);              
                        result[0] = lessIdx + 1;
                        result[1] = biggerIdx + 1;
                    } else{
                        int lessIdx = map.get(numbers[i]).get(0) < map.get(numbers[j]).get(0) ? map.get(numbers[i]).get(0) : map.get(numbers[j]).get(0);
                        int biggerIdx = map.get(numbers[i]).get(0) > map.get(numbers[j]).get(0) ? map.get(numbers[i]).get(0) : map.get(numbers[j]).get(0);
                        result[0] = lessIdx + 1;
                        result[1] = biggerIdx + 1;
                    }
                    return result;
                } 
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] numbers = {5,75,25};
        System.out.println(ts.twoSum(numbers, 100));
    }

}
