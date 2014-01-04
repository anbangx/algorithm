package leetcode.palindrome;

public class PalindromeNumber {
    
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int temp = x;
        int count = 1;
        while(temp >= 10){
            temp = temp / 10;
            count = count * 10;
        }
        // To get the next last digit, x=x/10; x%10;
        // To get the next first digit, keep x = x/10,  until x<10
        int last = 0;
        int first = 0;
        while(x >= 0){
            if(x < 10)  return true;
            else if(x == 10)    return false;
            last = x % 10;
            first = x / count;
            if(first != last)   return false;
            x = (x - last - first * count) / 10;
            count = count / 100;
        }
        return false;
    }
    
    public static void main(String[] args) {

    }

}
