package leetcode.convert;

public class ZigZagConversion {
    
    public String convert(String s, int nRows) {
        if(s == null || s.length() == 0)
            return null;
        if(nRows == 1)
           return s;
        int len = s.length();
        int zigSize = 2 * nRows - 2;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < nRows; i++){
            for(int base = i;; base += zigSize){
                if(base >= len)
                    break;
                sb.append(s.charAt(base));
                if(i > 0 && i < nRows - 1) {
                    int ti = base + zigSize - 2 * i;
                    if(ti < len)
                        sb.append(s.charAt(ti));
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("A", 1));
    }

}
