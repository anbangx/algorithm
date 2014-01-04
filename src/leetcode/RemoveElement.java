package leetcode;

public class RemoveElement {
    
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null || A.length == 0)
            return 0;
            
        int lastItemIdx = A.length - 1;
        while(lastItemIdx > 0 && A[lastItemIdx] == elem)
            lastItemIdx--;
        
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == elem){
                if(lastItemIdx >= 0)
                    A[i] = A[lastItemIdx];
                lastItemIdx--;
                while(lastItemIdx > 0 && A[lastItemIdx] == elem)
                    lastItemIdx--;
                count++; 
            }
        }
        return A.length - count;
    }
    
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] A = {3,3};
        System.out.println(re.removeElement(A, 3));
    }

}
