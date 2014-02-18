package GeekForGeek.String;

public class WildCard {
	
	public boolean match(String first, String second){
		if(first.equals("") && second.equals(""))
			return true;
		
		if(first.equals(""))
			return false;
		
		char f = first.charAt(0);
		if(second.equals("")){
			if(f == '*' && first.length() == 1)
				return true;
			else
				return false;
		}
		
		char s = second.charAt(0);
		if(f == '?' || f == s)
			return match(first.substring(1), second.substring(1));
			
		if(f == '*')
			return match(first, second.substring(1)) ||
					match(first.substring(1), second);
		
		return false;
	}
	
	public static void main(String[] args) {
		test("g*ks", "geeks");
		test("ge?ks*", "geeksforgeeks");
		test("g*k", "gee");
		test("*pqrs", "pqrst");
		test("abc*bcd", "abcdhghgbcd");
	}
	
	public static void test(String first, String second){
		WildCard wc = new WildCard();
		System.out.println(wc.match(first, second));
	}
}
