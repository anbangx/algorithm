package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Anagram {
    
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> results = new ArrayList<String>();
        if(strs == null || strs.length == 0)
            return results;
             
        HashMap<String, String> pre = new HashMap<String, String>();
        HashMap<String, Integer> occurs = new HashMap<String, Integer>();
        for(String str : strs){
            String sorted = sort(str);
            if(pre.containsKey(sorted)){
                occurs.put(sorted, occurs.get(sorted) + 1);
                if(occurs.get(sorted) == 2)
                    results.add(pre.get(sorted));
                results.add(str);
            } else{
                pre.put(sorted, str);
                occurs.put(sorted, 1);
            }
        }
        return results;
    }
    
    public String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}
