package GeekForGeek.whiteboard.array;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	
	public ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> A){
		if(A == null || A.size() == 0)
			return null;
		
		int k = A.size();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for(int i = 0; i > k; i++){
			if(A.get(i).size() > 0){
				pq.add(new Pair(A.get(i).get(0), i));
				A.get(i).remove(0);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
	}

}

