package leetcode.secondround;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(start); visited.add(start);
        int preLevel = 1; int curLevel;
        int depth = 1;
        while(!q.isEmpty()){
            curLevel = 0;
            while(preLevel > 0){
                StringBuilder cur = new StringBuilder(q.poll());
                for(int i = 0; i < cur.length(); i++){
                	StringBuilder change = new StringBuilder(cur);
                    char curChar = change.charAt(i);                    
                    for(char c = 'a'; c <= 'z'; c++){
                        if(curChar == c)    continue;
                        change.setCharAt(i, c);
                        String curString = change.toString();
                        if(end.equals(curString)){
                            depth++;
                            return depth;
                        }
                        if(!visited.contains(curString) && dict.contains(curString)){
                            q.add(curString);
                            visited.add(curString);
                            curLevel++;
                        }
                    }
                }
                preLevel--;
            }
            preLevel = curLevel;
            depth++;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(wl.ladderLength("hit", "cog", dict));
	}

}
