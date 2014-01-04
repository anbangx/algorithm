package leetcode;
import java.util.Stack;


public class SimplifyPath {
    
    public String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<String> stack = new Stack<String>();
        int len = path.length();
        for(int i = 0; i < len; i++){
            while(i < len && path.charAt(i) == '/') i++;
            if(i == len)
                break;
            int start = i;
            while(i < len && path.charAt(i) != '/') i++;
            int end = i;
            String element = path.substring(start, end);
            if(element.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            } else if(!element.equals(".")){
                stack.push(element);
            }
        }
        if(stack.size() == 0)   return "/";
        String output = "";
        for(int i = 0; i < stack.size(); i++)
            output += "/" + stack.get(i);
        return output;
    }
    
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/.."));
        int i = 1;
        long w = 0;
        if(w == (long)i)
            System.out.println("s");
    }

}
