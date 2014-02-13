package GeekForGeek.whiteboard.array;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	
	public ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> A){
		if(A == null || A.size() == 0)
			return null;
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		int k = A.size();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for(int i = 0; i < k; i++){
			if(A.get(i).size() > 0){
				pq.add(new Pair(A.get(i).get(0), i));
				A.get(i).remove(0);
			}
		}
		while(!pq.isEmpty()){
			Pair pair = pq.poll();
			B.add(pair.val);
			if(A.get(pair.idx).size() > 0){
				pq.add(new Pair(A.get(pair.idx).get(0), pair.idx));
				A.get(pair.idx).remove(0);
			}
		}
		return B;
	}
	
	public static void main(String[] args) {
		MergeKSortedArray msa = new MergeKSortedArray();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1); list1.add(4); list1.add(6);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(3); list2.add(5); list2.add(10);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(2); list3.add(7); list3.add(8);
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(list1);
		A.add(list2);
		A.add(list3);
		ArrayList<Integer> B = msa.mergeKSortedArray(A);
		for(Integer i : B)
			System.out.println(i);
	}

}

