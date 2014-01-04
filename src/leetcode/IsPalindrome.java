package leetcode;

public class IsPalindrome {
    
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int temp = x;
        int count = 1;
        while(temp >= 10){
            temp = temp / 10;
            count = count * 10;
        }
        int last = 0;
        int first = 0;
        while(x >= 0){
            if(x < 10)  return true;
            last = x % 10;
            first = x / count;
            if(first != last)   return false;
            x = (x - last - first * count) / 10;
            count = count / 100;
        }
        return false;
    }
    
    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome(1358228531));
        StringBuffer sb = new StringBuffer();
    }

}
