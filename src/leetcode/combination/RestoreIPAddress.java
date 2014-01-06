package leetcode.combination;
import java.util.ArrayList;


public class RestoreIPAddress {
    
    public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> results = new ArrayList<String>();
        if(s == null)   return results;
        partitionIP(s, 0, 0, new StringBuffer(), results);
        return results;
    }
    
    public void partitionIP(String s, int startIndex, int partitionNum, StringBuffer output, ArrayList<String> results){
        int len = s.length();
        if(len - startIndex < 4 - partitionNum) return;
        if(len - startIndex > 3 * (4 - partitionNum))   return;
        if(startIndex == len && partitionNum == 4){
            output.deleteCharAt(output.length() - 1);
            results.add(output.toString());
            return;
        }
        int num = 0;
        for(int i = startIndex; i < startIndex + 3 && i < len; i++){
            num = 10 * num + (s.charAt(i) - '0');
            if(num <= 255){
                int addBeforeLength = output.length();
                output.append(num).append(".");
                partitionIP(s, i + 1, partitionNum + 1, output, results);
                output.delete(addBeforeLength, output.length());
            }
            if(num == 0)
                break;
        }        
    }
    
    public static void main(String[] args) {
        RestoreIPAddress ria = new RestoreIPAddress();
        System.out.println(ria.restoreIpAddresses("1111"));
    }

}
