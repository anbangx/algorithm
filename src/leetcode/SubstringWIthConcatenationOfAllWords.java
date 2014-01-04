package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SubstringWIthConcatenationOfAllWords {
    
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(S == null || L == null)
            return results;
        int sLen = S.length();
        int lLen = L.length;
        int wLen = L[0].length();
        Map<String, Integer> covered = new HashMap<String, Integer>();
        for(int i = 0; i < lLen; i++){
            if(covered.containsKey(L[i]))
                covered.put(L[i], covered.get(L[i]) + 1);
            else
                covered.put(L[i], 1);
        }
        for(int i = 0; i < sLen - lLen * wLen + 1; i++){
            Map<String, Integer> cur = new HashMap<String, Integer>(covered);
            for(int j = 0; j < lLen; j++){
                String testStr = S.substring(i + j * wLen, i + (j + 1) * wLen);
                if(cur.containsKey(testStr)){
                    cur.put(testStr, cur.get(testStr) - 1);
                    if(cur.get(testStr) == 0)
                        cur.remove(testStr);
                }
                else
                    break;
            }
            if(cur.isEmpty()){
                results.add(i);
            }
        }
        return results;
    }
    
    public static void main(String[] args) {
        SubstringWIthConcatenationOfAllWords sw = new SubstringWIthConcatenationOfAllWords();
        String S = "a";
        String[] L = {"a"};
        System.out.println(sw.findSubstring(S, L));
    }

}
