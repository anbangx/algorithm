package leetcode.secondround;

import java.util.ArrayList;

public class StringPermutation {

	public ArrayList<StringBuilder> permutation(String str){
		ArrayList<StringBuilder> results = new ArrayList<StringBuilder>();
		int len = str.length();
		char first = str.charAt(0);
		if(len == 1){
			StringBuilder here = new StringBuilder();
			here.append(first);
			results.add(here);
			return results;
		}
		ArrayList<StringBuilder> perms = permutation(str.substring(1));
		for(StringBuilder sb : perms){
			for(int i = 0; i < len; i++){
				StringBuilder cur = new StringBuilder(sb);
				cur.insert(i, first);
				results.add(cur);
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		StringBuilder sb = new StringBuilder("abc");
//		System.out.println(sb.toString());
		System.out.println(sp.permutation("ABC"));
	}

}
