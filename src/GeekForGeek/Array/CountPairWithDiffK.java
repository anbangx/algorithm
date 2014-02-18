package GeekForGeek.Array;

import java.util.HashSet;
import java.util.Iterator;

public class CountPairWithDiffK {

	public int countPairWithDiffK(int[] A, int diff){
		HashSet<Integer> hS = new HashSet<Integer>();
	    for(int i = 0; i < A.length; i++){
	        hS.add(A[i]);
	    }
	    int count = 0;
	    Iterator<Integer> it = hS.iterator();
	    while(it.hasNext()){
	    	int val = it.next();
	    	if(hS.contains(val - diff)){
	    		count++;
	    	}
	    	if(hS.contains(val + diff)){
	    		count++;
	    	}
	    	it.remove();
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 5, 3, 4, 2};
		test(A, 3);
		int[] B = {8, 12, 16, 4, 0, 20};
		test(B, 4);
	}
	
	public static void test(int[] A, int diff){
		CountPairWithDiffK cp = new CountPairWithDiffK();
		System.out.println(cp.countPairWithDiffK(A, diff));
	}

}
