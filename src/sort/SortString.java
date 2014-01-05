package sort;

import java.util.Arrays;

public class SortString {
    
    public String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
    
    public static void main(String[] args) {
        SortString ss = new SortString();
        System.out.println(ss.sort("hello world!"));
    }

}
