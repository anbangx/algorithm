package leetcode.yesorno;

public class JumpGame {

    public boolean canJump(int[] A) {
        if(A == null || A.length == 0)
            return false;
        
        int maxIdx = A[0];
        if(maxIdx >= A.length - 1)
            return true;
        int cursor = 1;
        while(cursor <= maxIdx){
            int reachedIdx = cursor + A[cursor];
            if(maxIdx < reachedIdx)
                maxIdx = reachedIdx;
            if(maxIdx >= A.length - 1)
                return true;
            cursor++;
        }
        return false;
    }
    
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] A = {1,0,2};
        System.out.println(jg.canJump(A));
    }

}
