package GeekForGeek.whiteboard.tree;

import java.util.HashMap;

public class Trie {
	
	TrieNode root = new TrieNode('0');
	public void insert(String word){
		int len = word.length();
		TrieNode crawl = root;
		for(int level = 0; level < len; level++){
			HashMap<Character, TrieNode> children = crawl.children;
			char ch = word.charAt(level);
			
			if(children.containsKey(ch))
				crawl = children.get(ch);
			else{
				TrieNode newNode = new TrieNode(ch);
				crawl.children.put(ch, newNode);
				crawl = newNode;
			}
		}
		crawl.isEnd = true;
	}
	
	public String getMatchingPrefix(String word){
		StringBuilder sb = new StringBuilder();
		int len = word.length();
		TrieNode crawl = root;
		int preMatch = 0;
		
		for(int level = 0; level < len; level++){
			HashMap<Character, TrieNode> children = crawl.children;
			char ch = word.charAt(level);
			
			if(children.containsKey(ch)){
				sb.append(ch);
				crawl = children.get(ch);
				
				if(crawl.isEnd)
					preMatch = level + 1;
			}
			else
				break;
		}
		return sb.toString().substring(0, preMatch);
	}
	
	public static void main(String[] args) {
		Trie dict = new Trie();       
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");       
        dict.insert("basement");
         
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));             
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                     
         
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));             
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));             
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                     
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input)); 
	}

}

class TrieNode {
	public char val;
	public HashMap<Character, TrieNode> children;
	public boolean isEnd;
	
    public TrieNode(char ch)  {
        val = ch;
        children = new HashMap<Character, TrieNode>();
        isEnd = false;
    }    
}
