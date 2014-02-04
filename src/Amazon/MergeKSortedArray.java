package Amazon;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    // Ascending order
    // for descending order, replace with "new PriorityQueue<Integer>(size, Collections.reverseOrder());"
    public ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> inputs) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (inputs == null || inputs.size() == 0)
            return result;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (ArrayList<Integer> arr : inputs) {
            for (Integer i : arr) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        MergeKSortedArray mksa = new MergeKSortedArray();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(3);
        arr1.add(5);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(6);
        arr2.add(8);
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
        inputs.add(arr1);
        inputs.add(arr2);
        System.out.println(mksa.mergeKSortedArray(inputs));
    }

}
