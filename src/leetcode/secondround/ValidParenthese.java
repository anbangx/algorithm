package leetcode.secondround;

import java.util.Stack;

public class ValidParenthese {

	public boolean isValid(String s) {
        if(s == null || s.length() == 0)    return true;
        
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            char preChar;
            switch(c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    preChar = stack.pop();
                    if(preChar != '(')  return false;
                    break;
                case ']':
                    if(stack.isEmpty()) return false;
                    preChar = stack.pop();
                    if(preChar != '[')  return false;
                    break;
                case '}':
                    if(stack.isEmpty()) return false;
                    preChar = stack.pop();
                    if(preChar != '{')  return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		ValidParenthese vp = new ValidParenthese();
		System.out.println(vp.isValid("(){}[]"));
	}

}
