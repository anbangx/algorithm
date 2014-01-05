package leetcode.parentheses;
import java.util.Stack;


public class LongestValidParentheses {
    
    public int longestValidParentheses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null || s.length() == 0)
            return 0;
        Stack<Character> stack = new Stack<Character>();
        int winLen = 0;
        int maxWinLen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    winLen = 0;
                    continue;
                }
                else{
                    stack.pop();
                    winLen = winLen + 2;
                    if(maxWinLen < winLen)
                        maxWinLen = winLen;
                }
            }
        }
        return maxWinLen;
    }
    
    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses("()(()"));
        int i = 1;
        StringBuilder sb = new StringBuilder("");
        sb.append(i);
        System.out.println(sb.toString());
        
    }

}
