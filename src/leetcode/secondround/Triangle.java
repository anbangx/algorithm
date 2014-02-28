package leetcode.secondround;

import java.util.ArrayList;

public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;

		int rowSize = triangle.size();
		int columnSize = triangle.get(rowSize - 1).size();
		int[] dp = new int[columnSize];
		dp[0] = triangle.get(0).get(0);
		for (int j = 1; j < columnSize; j++)
			dp[j] = Integer.MAX_VALUE;
		for (int i = 1; i < rowSize; i++) {
			ArrayList<Integer> row = triangle.get(i);
			for (int j = i; j >= 1; j--) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
			}
			dp[0] += row.get(0);
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < columnSize; j++)
			min = dp[j] < min ? dp[j] : min;
		return min;
	}

	public static void main(String[] args) {
		Triangle t = new Triangle();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(-1);
		triangle.add(firstRow);
		ArrayList<Integer> secondRow = new ArrayList<Integer>();
		secondRow.add(2);
		secondRow.add(3);
		triangle.add(secondRow);
		ArrayList<Integer> thirdRow = new ArrayList<Integer>();
		thirdRow.add(1);
		thirdRow.add(-1);
		thirdRow.add(-3);
		triangle.add(thirdRow);
		System.out.println(t.minimumTotal(triangle));
	}

}
