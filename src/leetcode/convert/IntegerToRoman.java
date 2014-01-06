package leetcode.convert;

public class IntegerToRoman {
    
    public String intToRoman(int num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        StringBuffer sb = new StringBuffer(); 
        String symbol[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  
        for(int i = 0; num != 0; i++){
            while(value[i] <= num){
                num -= value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}
