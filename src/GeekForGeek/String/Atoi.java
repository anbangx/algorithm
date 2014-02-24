package GeekForGeek.String;

public class Atoi {
	
	public int myAtoi(String str){
		if(str == null || str.length() == 0)
            return 0;
        int res = 0;
		int sign = 1;
		int i = 0;
		while(str.charAt(i) == ' ' || str.charAt(i) == '0')
		    i++;
		if(str.charAt(i) == '-'){
			sign = -1;
			i++;
		} else if(str.charAt(i) == '+'){
			i++;
		}
		while(str.charAt(i) == '0')
		    i++;
		for(; i < str.length(); i++){
			char c = str.charAt(i);
			if(c < '0' || c > '9')
				return sign * res;
			res = 10 * res + c - '0';
		}
		
		return sign * res;
	}
	
	public static void main(String[] args) {
		Atoi atoi = new Atoi();
		System.out.println(atoi.myAtoi("2147483648"));
	}

}
