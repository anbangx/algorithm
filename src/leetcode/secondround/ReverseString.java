package leetcode.secondround;

public class ReverseString {

	public String reverse(String str){
		int len = str.length();
		if(len == 1)	return str;
		
		StringBuilder sb = new StringBuilder();
		for(int i = len - 1; i >= 0; i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public String reverseRecursively(String str){
		int len = str.length();
		if(len == 1)	return str;
		
		StringBuilder newSB = new StringBuilder(reverseRecursively(str.substring(1)));
		newSB.append(str.charAt(0));
		return newSB.toString();
	}
	
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverse("ab"));
		System.out.println(rs.reverseRecursively("ab"));
	}

}
