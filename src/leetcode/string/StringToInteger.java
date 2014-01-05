package leetcode.string;

public class StringToInteger {
    
    public int atoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
            
        int len = str.length();
        int sign = 1;
        int i = 0;
        while(i < len && str.charAt(i) == ' ')
            i++;
        if(str.charAt(i) == '+')
            i++;
        if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        
        int num = 0;
        while(i < len){
            char c = str.charAt(i);
            if(c == ' ')
                break;
            if(str.charAt(i) < '0' || str.charAt(i) > '9') break; 
            if(Integer.MAX_VALUE/10 < num || Integer.MAX_VALUE/10 == num && Integer.MAX_VALUE % 10 < (str.charAt(i) -'0')){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num*10 + str.charAt(i) -'0';  
            i++;
        }
        return num * sign;
    }
    
    public static void main(String[] args) {
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.atoi("+1"));
    }

}
