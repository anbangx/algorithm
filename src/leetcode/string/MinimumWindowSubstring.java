package leetcode.string;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length())
            return "";
        HashSet<Character> wholeLetters = new HashSet<Character>();
        HashSet<Character> notFound = new HashSet<Character>();
        for (char c : T.toCharArray()) {
            wholeLetters.add(c);
            notFound.add(c);
        }
        String minWindow = "";
        int leftIndex = -1;
        Queue<Character> foundQueue = new LinkedList<Character>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            if (wholeLetters.contains(S.charAt(i))) {
                if(notFound.contains(S.charAt(i))){
                    notFound.remove(S.charAt(i));
                    found.put(S.charAt(i), i);
                    foundQueue.add(S.charAt(i));
                    if (found.size() == 1)
                        leftIndex = i;
                } else{
                    found.put(S.charAt(i), i);
                    foundQueue.remove(S.charAt(i));
                    foundQueue.add(S.charAt(i));
                }
            }

            if (notFound.isEmpty()) {
                if (minWindow == "")
                    minWindow = S.substring(leftIndex, i + 1);
                else {
                    int windowLength = i - leftIndex;
                    if (windowLength < minWindow.length())
                        minWindow = S.substring(leftIndex, i + 1);
                }
                if (i < S.length() - 1) {
                    notFound.add(S.charAt(leftIndex));
                    found.remove(S.charAt(leftIndex));
                    foundQueue.remove(S.charAt(leftIndex));
                    if(!foundQueue.isEmpty())
                        leftIndex = found.get(foundQueue.peek());
                }
            }
        }
        return minWindow;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String S = "aa";
        String T = "aa";
        System.out.println(mws.minWindow(S, T));
    }
}
