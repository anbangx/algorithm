package leetcode.string;
import java.util.HashMap;
import java.util.Map;


public class MinimumWindowSubstring3 {
    
    public String minWindow(String S, String T) {
        if(S==null || T==null) return "";
        Map<Character,Integer> total = new HashMap<Character,Integer>();
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            if(total.containsKey(c))
                total.put(c,total.get(c)+1);
            else
                total.put(c,1);
        } 
        
        Map<Character,Integer> covered = new HashMap<Character,Integer>();
        int start=0,
            end=-1,
            cur1=0,
            cur2=0,
            count=0;

        while(cur1<S.length() && cur2<S.length()){
            while(cur1<S.length() && !total.containsKey(S.charAt(cur1))) 
                cur1++;
                
            if(cur1<S.length()){
                if(cur2<cur1) cur2=cur1;
                
                if(count<T.length()){
                    while(cur2<S.length() && !total.containsKey(S.charAt(cur2))) 
                        cur2++;
                    if(cur2<S.length()){
                        char c = S.charAt(cur2);   
                        if(!covered.containsKey(c) ){
                            covered.put(c,1);
                            count++;
                        }else{                        
                            if(covered.get(c)<total.get(c)) 
                                count++;
                            covered.put(c,covered.get(c)+1);
                        } 
                        if(count<T.length()) cur2++;
                    }
                }else{
                    if(start>end || end-start>cur2-cur1){
                        end=cur2;
                        start=cur1;
                    }
                    char c = S.charAt(cur1);
                    covered.put(c,covered.get(c)-1);
                    cur1++;
                    if(covered.get(c)<total.get(c)){
                         count--;
                         cur2++;
                    }
                }
            }
        }
        return  S.substring(start,end+1);
    }
}
