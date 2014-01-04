package leetcode;

public class NextPermutation {
    
    public void nextPermutation(int[] num) {
        if(num == null || num.length == 0 || num.length == 1)
            return;
        
        // find cursor        
        int len = num.length;
        int prev = len - 1;
        int cursor = len - 2;
        for(; cursor >= 0; cursor--){
            if(num[cursor] < num[prev])
                break;
            prev = cursor;
        }
        
        // if no find cursor, reverse the whole array
        if(cursor == -1){
            reverse(num, 0, len - 1);
            return;
        }
        
        // find swap element
        int swap = cursor + 1;
        while(swap <= len - 1 && num[swap] > num[cursor])
            swap++;
        
        // swap with cursor
        swap--;
        int temp = num[cursor];
        num[cursor] = num[swap];
        num[swap] = temp;
        
        // reverse [cursor + 1 to end]
        reverse(num, cursor + 1, len - 1);
    }
    
    public void reverse(int[] num, int left, int right){
        while(left < right){
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
    
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] num = {1, 2};
        np.nextPermutation(num);
        System.out.println(num);
    }

}
