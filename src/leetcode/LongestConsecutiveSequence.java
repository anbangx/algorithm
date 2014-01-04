package leetcode;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length == 0 || num.length == 1)
            return num.length;
        // build a map to store <num, index>
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            map.put(num[i], i);
        }
        // search longest
        int longestLength = 0;
        while (map.size() > 0) {
            int number = map.keySet().iterator().next();
            int curLength = 1;
            map.remove(number);
            int increNumber = number;
            while (map.containsKey(increNumber - 1)) {
                curLength++;
                increNumber--;
                map.remove(increNumber);
            }
            int decreNumber = number;
            while (map.containsKey(decreNumber + 1)) {
                curLength++;
                decreNumber++;
                map.remove(decreNumber);
            }
            if (longestLength < curLength)
                longestLength = curLength;
        }
        return longestLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] testcase = {1,0,-1};
        System.out.println(lcs.longestConsecutive(testcase));

    }

}
