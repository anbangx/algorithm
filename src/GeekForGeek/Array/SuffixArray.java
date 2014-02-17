package GeekForGeek.Array;

import java.util.Arrays;

public class SuffixArray {

	class Suffix implements Comparable<Suffix> {
		public String suff;
		public int idx;

		// public Suffix(String suff, int idx){
		// this.suff = suff;
		// this.idx = idx;
		// }

		@Override
		public int compareTo(Suffix other) {
			return this.suff.compareTo(other.suff);
		}

	}
	
	public int[] buildSuffixArray(String s) {
		int len = s.length();
		Suffix[] suffixes = new Suffix[len];
		for (int i = 0; i < len; i++) {
			suffixes[i] = new Suffix();
			suffixes[i].suff = s.substring(i);
			suffixes[i].idx = i;
		}

		Arrays.sort(suffixes);
		int[] suffixArr = new int[len];
		for (int i = 0; i < len; i++) {
			suffixArr[i] = suffixes[i].idx;
		}

		return suffixArr;
	}

	public void search(String pattern, String s, int[] suffixArr){
		int m = pattern.length();
		int n = s.length();
		int left = 0; int right = n - 1; 
		while(left <= right){
			int mid = left + (right - left)/2;
			int res = 0;
			if(mid + m <= n)
				res = pattern.compareTo(s.substring(suffixArr[mid], suffixArr[mid] + m));
			else
				res = pattern.compareTo(s.substring(suffixArr[mid]));
			if(res == 0){
				System.out.println("Find element in " + mid);
				return;
			} else if(res > 0){
				right = mid - 1;
			} else{
				left = mid + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		SuffixArray sa = new SuffixArray();
		int[] suffixArr = sa.buildSuffixArray("banana");
		Array.printArr(suffixArr);
		sa.search("ana", "banana", suffixArr);
	}

}
