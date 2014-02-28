package leetcode.secondround;

import java.util.ArrayList;

public class UnionAndIntersectionOfTwoArray {

	public ArrayList<Integer> union(int[] A, int[] B){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(A == null && B == null)	return null;
		if(A == null){
			for(int i = 0; i < B.length; i++)
				result.add(B[i]);
			return result;
		}
		if(B == null){
			for(int i = 0; i < A.length; i++)
				result.add(A[i]);
			return result;
		}
		int lenA = A.length; int lenB = B.length;
		int i = 0; int j = 0;
		while(i < lenA && j < lenB){
			if(A[i] < B[j]){
				result.add(A[i++]);
			}else if(A[i] > B[j]){
				result.add(B[j++]);
			}else{
				result.add(A[i++]);
				j++;
			}
		}
		while(i < lenA){
			result.add(A[i++]);
		}
		while(j < lenB){
			result.add(A[j++]);
		}
		return result;
	}
	
	public ArrayList<Integer> intersection(int[] A, int[] B){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(A == null && B == null)	return null;
		if(A == null){
			for(int i = 0; i < B.length; i++)
				result.add(B[i]);
			return result;
		}
		if(B == null){
			for(int i = 0; i < A.length; i++)
				result.add(A[i]);
			return result;
		}
		int lenA = A.length; int lenB = B.length;
		int i = 0; int j = 0;
		while(i < lenA && j < lenB){
			if(A[i] < B[j]){
				i++;
			}else if(A[i] > B[j]){
				j++;
			}else{
				result.add(A[i++]);
				j++;
			}
		}
//		while(i < lenA){
//			result.add(A[i++]);
//		}
//		while(j < lenB){
//			result.add(A[j++]);
//		}
		return result;
	}
	
	public static void main(String[] args) {
		UnionAndIntersectionOfTwoArray ui = new UnionAndIntersectionOfTwoArray();
		int[] A = {1, 3, 4, 5, 7};
		int[] B = {2, 3, 5, 6};
		System.out.println(ui.intersection(A, B));
	}

}
