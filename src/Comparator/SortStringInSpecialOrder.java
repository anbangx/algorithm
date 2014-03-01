package Comparator;

import java.util.ArrayList;
import java.util.HashMap;

public class SortStringInSpecialOrder {

	public String sort(String str, ArrayList<Character> list){
		HashMap<Character, Integer> hM = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(hM.containsKey(c)){
				hM.put(c, hM.get(c) + 1);
			} else{
				hM.put(c, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++){
			char c = list.get(i);
			if(hM.containsKey(c)){
				int count = hM.get(c);
				for(int j = 0; j < count; j++)
					sb.append(c);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		SortStringInSpecialOrder s = new SortStringInSpecialOrder();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('P');
		list.add('S');
		list.add('E');
		list.add('H');
		System.out.println(s.sort("SHEEP", list));
	}

}
