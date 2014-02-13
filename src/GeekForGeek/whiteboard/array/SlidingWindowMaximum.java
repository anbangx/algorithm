package GeekForGeek.whiteboard.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	
	public int[] slidingWindow(int[] A, int w){
		int len = A.length;
		int[] B = new int[len];
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for(int i = 0; i < w; i++){
			Pair pair = new Pair(A[i], i);
			pq.add(pair);
		}
		for(int i = w; i < len; i++){
			Pair pair = pq.peek();
			B[i-w] = pair.val;
			while(pair.idx <= i - w){
				pq.poll();
				pair = pq.peek();
			}
			pq.add(new Pair(A[i], i));
		}
		B[len-w] = pq.peek().val;
		return B;
	}
	
	public static void main(String[] args) {
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int[] A = {3,4,5,6,1,2,7};
		int[] B = swm.slidingWindow(A, 3);
		for(int i = 0; i < B.length; i++)
			System.out.println(B[i]);
		
		Pair p1 = new Pair(1, 0);
		Pair p2 = new Pair(2, 0);
		Pair p3 = new Pair(4, 0);
		Pair p4 = new Pair(3, 0);
		Pair p5 = new Pair(5, 0);
		ArrayList<Pair> l = new ArrayList<Pair>();
		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);
		l.add(p5);
		Collections.sort(l);
		System.out.println(l);
	}

}

class Pair implements Comparable<Pair>{
	public int val;
	public int idx;
	public Pair(int val, int idx){
		this.val = val;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Pair another) {
		return -(another.val - this.val);
	}
	
	public String toString(){
		return "[" + this.val + ", " + this.idx + "]";
	}
}
