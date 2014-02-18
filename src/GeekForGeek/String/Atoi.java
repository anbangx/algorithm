package GeekForGeek.String;

public class Atoi {
	
	public int myAtoi(String str){
		int res = 0;
		int sign = 1;
		int i = 0;
		if(str.charAt(i) == '-'){
			sign = -1;
			i++;
		}
		for(; i < str.length(); i++){
			char c = str.charAt(i);
			if(c < '0' && c > '9')
				return 0;
			res = 10 * res + c - '0';
		}
		
		return sign * res;
	}
	
	public static void main(String[] args) {
		Atoi atoi = new Atoi();
		System.out.println(atoi.myAtoi("-123"));
	}

}
