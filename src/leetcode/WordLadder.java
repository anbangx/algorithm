package leetcode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        // BFS
        int length = start.length();
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        int preCount = 1;
        int step = 1;
        int curCount = 0;
        HashSet<String> visited = new HashSet<String>();
        while (!q.isEmpty()) {
            String word = q.poll();
            for (int i = 0; i < length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    StringBuilder temp = new StringBuilder(word);
                    temp.setCharAt(i, c);
                    if (temp.toString().equals(start.charAt(i)))
                        continue;
                    if (temp.toString().equals(end)) {
                        return step + 1;
                    }
                    if (!visited.contains(temp.toString()) && dict.contains(temp.toString())) {
                        q.add(temp.toString());
                        visited.add(temp.toString());
                        curCount++;
                    }
                }
            }
            if ((--preCount) == 0) {
                preCount = curCount;
                curCount = 0;
                step++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String start = "kite";
        String end = "ashy";
        String[] array = { "ante","does","jive","achy","kids","kits","cart","ache","ands","ashe","acne","aunt","aids","kite","ants","anne","ashy"};

        System.out.println(wl.ladderLength(start, end, new HashSet<String>(Arrays.asList(array))));
    }

}
