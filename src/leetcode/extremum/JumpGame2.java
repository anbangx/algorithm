package leetcode.extremum;

public class JumpGame2 {
    
    public int jump(int[] A) {
        int count = 0;
        if(A == null || A.length == 0)
            return count;
            
        int start = 0;
        int end = 0;
        while(end < A.length - 1){
            count++;
            int maxIdx = 0;
            for(int i = start; i <= end; i++){
                if(maxIdx < i + A[i])
                    maxIdx = i + A[i];
                if(maxIdx >= A.length - 1)
                    return count;
            }
            start = end;
            end = maxIdx;
        }
        return 0;
    }
}
