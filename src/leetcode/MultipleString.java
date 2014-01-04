package leetcode;

public class MultipleString {
    
    public String multiply(String num1, String num2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        int n1;
        int n2;
        for(int i = 0; i < len1; i++){
            int carry = 0;
            n1 = num1.charAt(len1 - 1 - i) - '0';
            for(int j = 0; j < len2; j++){
               n2 =  num2.charAt(len2 - 1 - j) - '0';
               result[i + j] += carry + n1 * n2;
               carry = result[i + j] / 10;
               result[i + j] = result[i + j] % 10;
            }
            result[i + len2] = carry;
        }
        
        int i = len1 + len2 - 1;
        while(i >= 0 && result[i] == 0)
            i--;
        
        StringBuilder temp = new StringBuilder("");
        while(i>=0)
            temp.append((char)('0'+result[i--]));
        
        return temp.toString().isEmpty() ? "0" : temp.toString();
    }
    
    public static void main(String[] args) {
        MultipleString ms = new MultipleString();
        System.out.println(ms.multiply("98", "9"));
    }

}
