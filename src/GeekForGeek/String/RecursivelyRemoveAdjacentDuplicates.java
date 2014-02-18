package GeekForGeek.String;

public class RecursivelyRemoveAdjacentDuplicates {
	
	public StringBuilder removeAdjacentDuplicates(StringBuilder sb, Result r){
		if(sb == null || sb.length() <= 1)
				return sb;
		
		char first = sb.charAt(0);
		if(first == sb.charAt(1)){
			r.lastRemove = first;
			while(sb.length() > 1 && first == sb.charAt(1)){
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
			return removeAdjacentDuplicates(sb, r);
		}
		
		sb.deleteCharAt(0);
		StringBuilder rem_sb = removeAdjacentDuplicates(sb, r);
		if(rem_sb.length() == 0)
			return new StringBuilder(first);
		if(first == rem_sb.charAt(0)){
			r.lastRemove = first;
			rem_sb.deleteCharAt(0);
		} else if(first != r.lastRemove){
			rem_sb.insert(0, first);
		}
		
		return rem_sb;	
	}
	
	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder("azxxxzy");
//		test(sb);
//		sb = new StringBuilder("caaabbbaac");
//		test(sb);
//		sb = new StringBuilder("gghhg");
//		test(sb);
//		sb = new StringBuilder("aaaacddddcappp");
//		test(sb);
		StringBuilder sb = new StringBuilder("geeksforgeeg");
		test(sb);
//		sb = new StringBuilder("geeksforgeeg");
//		test(sb);
		
	}
	
	public static void test(StringBuilder sb){
		RecursivelyRemoveAdjacentDuplicates r = new RecursivelyRemoveAdjacentDuplicates();
		StringBuilder result = r.removeAdjacentDuplicates(sb, new Result());
		System.out.println(result.toString());
	}

}

class Result{
	char lastRemove;
}