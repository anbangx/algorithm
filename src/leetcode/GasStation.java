package leetcode;
import java.util.LinkedList;


public class GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int sum = 0;
        int total = 0;
        int startIndex = -1;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0){
                startIndex = i;
                sum = 0;
            }
        }
        return total == 0 ? startIndex + 1 : -1;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList<String> queue = new LinkedList<String>();
    }

}
