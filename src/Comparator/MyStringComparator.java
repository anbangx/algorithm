package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MyStringComparator implements Comparator<String>{
	HashMap<Character, Integer> hM = new HashMap<Character, Integer>();
	
	public MyStringComparator(){
		hM.put('f', 5);
		hM.put('t', 4);
		hM.put('a', 3);
		hM.put('c', 2);
	}
	
	@Override
	public int compare(String s1, String s2){
		int len = s1.length();
		for(int i = 0; i < len; i++){
			if(hM.get(s1.charAt(i)) != hM.get(s2.charAt(i)))
				return hM.get(s1.charAt(i)) - hM.get(s2.charAt(i));
		}
		return 0;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("ttca");
		list.add("fcca");
		list.add("actf");
		list.add("aftf");
		Collections.sort(list, new MyStringComparator());
		System.out.println(list);
	}

}
