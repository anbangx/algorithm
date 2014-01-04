package leetcode;
import java.util.ArrayList;


public class GeneratePareneses {
    public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> results = new ArrayList<String>();
        genCombinationPar(0, 0, 0, n, new StringBuilder(), results); 
        return results;
    }
    
    public void genCombinationPar(int left, int right, int deep, int n, StringBuilder st, ArrayList<String> results){
        if(deep == 2*n){
            results.add(st.toString());
            return;
        }
        if(left < n){
            st.append('(').toString();
            genCombinationPar(left+1, right, deep+1, n, new StringBuilder(st), results);
            st.deleteCharAt(st.length() - 1);
        }
        if(right < left){
            st.append(')').toString();
            genCombinationPar(left, right+1, deep+1, n, new StringBuilder(st), results);
            st.deleteCharAt(st.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        GeneratePareneses generatePareneses = new GeneratePareneses();
        // testcase 1
        ArrayList<String> parentheses = generatePareneses.generateParenthesis(3);
        System.out.println(parentheses);
    }
}
