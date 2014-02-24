package leetcode.secondround;

import java.util.Stack;

public class SimplifyPath {

	int startIdx = 0;
    public String getOneDir(String path){
        int len = path.length();
        while(startIdx < len && path.charAt(startIdx) == '/')
            startIdx++;
        if(startIdx == len) return null;
        int endIdx = startIdx + 1;
        while(endIdx < len && path.charAt(endIdx) != '/')
            endIdx++;
        String dir = path.substring(startIdx, endIdx);
        startIdx = endIdx;
        return dir;
    }
    
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
            return path;
        
        Stack<String> stack = new Stack<String>();
        String dir;
        while((dir = getOneDir(path)) != null){
            if(dir.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            } else if(dir.equals(".")){
                
            } else{
                stack.push(dir);
            }
        }
        
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.pop());
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/..."));
	}

}
