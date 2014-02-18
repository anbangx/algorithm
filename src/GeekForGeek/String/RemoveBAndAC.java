package GeekForGeek.String;

public class RemoveBAndAC {
	
	public final int ONE = 1;
	public final int TWO = 2;
	public String removeBAndAC(StringBuilder sb){
		
		int state = ONE;
		int len = sb.length();
		int start = 0;
		for(int i = 0; i < len; i++){
			char c = sb.charAt(i);
			if(state == ONE){
				if(c != 'b' && c != 'a'){
					sb.setCharAt(start++, c);
				}
			} else{
				if(c != 'c'){
					sb.setCharAt(start++, 'a');
					if(c != 'b' && c != 'a'){
						sb.setCharAt(start++, c);
					}
				}
			}
			state = c == 'a' ? TWO : ONE;
		}
		return sb.substring(0, start);
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("ad");
		test(sb);
		sb = new StringBuilder("acbac");
		test(sb);
		sb = new StringBuilder("aaac");
		test(sb);
		sb = new StringBuilder("react");
		test(sb);
		sb = new StringBuilder("aa");
		test(sb);
		sb = new StringBuilder("ababaac");
		test(sb);
	}
	
	public static void test(StringBuilder sb){
		RemoveBAndAC r = new RemoveBAndAC();
		System.out.println(r.removeBAndAC(sb));
	}

}
