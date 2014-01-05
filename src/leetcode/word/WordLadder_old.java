package leetcode.word;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder_old {
    public int bfs(String start, String end, HashSet<String> dict, int level, ArrayList<String> output, ArrayList<ArrayList<String>> results) {
        int length = start.length();
        Queue<String> q = new LinkedList<String>();
        
        for(int i = 0; i < length; i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == start.charAt(i))
                    continue;
                StringBuilder temp = new StringBuilder(start);
                temp.setCharAt(i, c);
                if(temp.toString().equals(end)){
                    output.add(end);
                    results.add(new ArrayList<String>(output));
                    output.remove(end);
                    return level + 1;
                }
                if(dict.contains(temp.toString())){
                    q.add(temp.toString());
                }
            }
        }
        return 2;
//        int maxLength = -1;
//        while(!q.isEmpty()){
//            String s = q.poll();
//            dict.remove(s);
//            output.add(s);
//            int curLevel = bfs(s, end, dict, level + 1, output, results);
//            if(maxLength)
//            output.remove(s);
//            dict.add(s);
//        }
//        return false;
    }
    
    public void dfs(String start, String end, HashSet<String> dict, ArrayList<String> output, ArrayList<ArrayList<String>> results) {
        int length = start.length();
        for(int i = 0; i < length; i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == start.charAt(i))
                    continue;
                StringBuilder temp = new StringBuilder(start);
                temp.setCharAt(i, c);
                if(temp.toString().equals(end)){
                    output.add(end);
                    results.add(new ArrayList<String>(output));
                    output.remove(end);
                    return;
                }
                if(dict.contains(temp.toString())){
                    dict.remove(temp.toString());
                    output.add(temp.toString());
                    dfs(temp.toString(), end, dict, output, results);
                    output.remove(temp.toString());
                    dict.add(temp.toString());
                }
            }
        }
    }
}
