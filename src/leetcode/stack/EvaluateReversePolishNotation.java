package leetcode.stack;
import java.util.Stack;


public class EvaluateReversePolishNotation {
    
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> s = new Stack<Integer>();
        int rightOperant;
        int leftOperant;
        int result;
        for(int i = 0; i < tokens.length; i++){
           if(tokens[i].equals("+")){
                rightOperant = s.pop();
                leftOperant = s.pop();
                result = leftOperant + rightOperant;
                s.push(result);
           }else if(tokens[i].equals("-")){
                rightOperant = s.pop();
                leftOperant = s.pop();
                result = leftOperant - rightOperant;
                s.push(result);
           }else if(tokens[i].equals("*")){
                rightOperant = s.pop();
                leftOperant = s.pop();
                result = leftOperant * rightOperant;
                s.push(result);
           }else if(tokens[i].equals("/")){
                rightOperant = s.pop();
                leftOperant = s.pop();
                result = leftOperant / rightOperant;
                s.push(result);
           }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return s.peek();
    }
    
    public static void main(String[] args) {
        EvaluateReversePolishNotation erp = new EvaluateReversePolishNotation();
        String[] input = {"2", "1", "+", "3", "*"};
        System.out.println(erp.evalRPN(input));
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(erp.evalRPN(tokens));
        String[] tokens2 = {"0", "3", "/"};
        System.out.println(erp.evalRPN(tokens2));
        
        StringBuilder myName = new StringBuilder("domanokz");
        myName.setCharAt(4, 'x');
        System.out.println(myName);
    }

}
