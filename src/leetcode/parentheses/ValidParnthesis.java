package leetcode.parentheses;
import java.util.Stack;


public class ValidParnthesis {
    
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char preC = stack.pop();
                if(c != flip(preC))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    
    public char flip(char c){
        switch(c){
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return '0';
        }
    }
    
    public static void main(String[] args) {
        ValidParnthesis vp = new ValidParnthesis();
        System.out.println(vp.isValid("()"));
    }

}
