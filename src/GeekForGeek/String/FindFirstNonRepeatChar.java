package GeekForGeek.String;

import java.util.HashMap;
import java.util.Map;

public class FindFirstNonRepeatChar {
	
	public char findFirstNonRepeatChar(String str){
		
		HashMap<Character, Count> hM = new HashMap<Character, Count>();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(hM.containsKey(c)){
				hM.get(c).count++;
			} else{
				Count r = new Count(1, i);
				hM.put(c, r);
			}
		}
		int leftmostIdx = Integer.MAX_VALUE;
		for(Map.Entry<Character, Count> entry : hM.entrySet()){
			if(entry.getValue().count == 1 && entry.getValue().index < leftmostIdx){
					leftmostIdx = entry.getValue().index;
			}
		}
		
		return str.charAt(leftmostIdx);
	}
	
	public static void main(String[] args) {
		test("geeksforgeeks");
	}

	public static void test(String str){
		FindFirstNonRepeatChar fnr = new FindFirstNonRepeatChar();
		char c =fnr.findFirstNonRepeatChar(str);
		System.out.println(c);
	}
}

class Count{
	int count;
	int index;
	public Count(int count, int index){
		this.count = count;
		this.index = index;
	}
	
	public String toString(){
		return count + " " + index;
	}
}