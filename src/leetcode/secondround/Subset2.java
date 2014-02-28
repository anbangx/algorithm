package leetcode.secondround;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {

	public void combineUtil(int[] S, int k, int start,
			ArrayList<Integer> candidate, ArrayList<ArrayList<Integer>> results) {
		if (candidate.size() == k) {
			results.add(new ArrayList<Integer>(candidate));
			return;
		}

		for (int i = start; i < S.length; i++) {
			candidate.add(S[i]);
			combineUtil(S, k, i + 1, candidate, results);
			candidate.remove(candidate.size() - 1);
			while (i < S.length - 1 && S[i + 1] == S[i])
				i++;
		}
	}

	public ArrayList<ArrayList<Integer>> combine(int[] S, int k) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		combineUtil(S, k, 0, new ArrayList<Integer>(), results);
		return results;
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return results;

		Arrays.sort(num);
		int len = num.length;
		for (int i = 0; i <= len; i++) {
			results.addAll(combine(num, i));
		}
		return results;
	}

	public static void main(String[] args) {
		Subset2 ss = new Subset2();
		int[] S = { 1, 1 };
		System.out.println(ss.combine(S, 2));
	}

}
